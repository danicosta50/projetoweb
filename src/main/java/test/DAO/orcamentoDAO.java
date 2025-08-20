package test.DAO;

import Entidades.Orcamento;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
  
  public class orcamentoDAO {
      
      public void cadastrar(Orcamento o){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(o);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              JOptionPane.showMessageDialog(null, "erro ao cadastrar orcamento" + e);
              throw e;
          }
      
          finally{
              JPAUtil.closeEntityManager();
          }
      }
 
public List<Orcamento> listar(int paciente_id) {  
    EntityManager em = JPAUtil.getEntityManager();
    try {
        String textoquery = " SELECT o FROM Orcamento o "
                + "WHERE ( o.paciente_id = :paciente_id ) "
               ;
        Query consultaSql = em.createQuery(textoquery);     
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
       
        consultaSql.setParameter("paciente_id", paciente_id );       

        List<Orcamento> orcamentoLista = consultaSql.getResultList();
        return orcamentoLista;
    } catch(Exception e) {
        em.getTransaction().rollback();
        JOptionPane.showMessageDialog(null, "Erro ao listar consultas: " + e);
        throw e;
    } finally {
        JPAUtil.closeEntityManager();
    }
}

public Orcamento listarporId(int id) {  
    EntityManager em = JPAUtil.getEntityManager();
    try {
        String textoquery = "SELECT o FROM Orcamento o WHERE o.id = :id";
        Query consultaSql = em.createQuery(textoquery);
        consultaSql.setParameter("id", id); // Definir o parâmetro

        List<Orcamento> resultado = consultaSql.getResultList(); // Melhor abordagem para evitar exceção
        if (resultado.isEmpty()) {
            return null; // Retorna null se não encontrar o orçamento
        }
        return resultado.get(0); // Retorna o primeiro elemento da lista
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao selecionar orçamento: " + e.getMessage());
        throw e;
    } finally {
        JPAUtil.closeEntityManager();
    }
}

    
       
         public void excluir(int id){
      EntityManager em = JPAUtil.getEntityManager();
      try{
        Orcamento o  = em.find(Orcamento.class, id);
          if(o!= null){
              em.getTransaction().begin();
              em.remove(o);
              em.getTransaction().commit();
          }
      }catch(Exception e){
          em.getTransaction().rollback();
           JOptionPane.showMessageDialog(null, "erro ao cadastrar consulta" + e);
          throw e;
      }
      finally{
          JPAUtil.closeEntityManager();
      }
    }  
         
         
   public void atualizar(Orcamento orcamento){
      EntityManager em = JPAUtil.getEntityManager();
      try{
        Orcamento o  = em.find(Orcamento.class, orcamento.getId());

          if(o != null){
              em.getTransaction().begin();
             o.setId_item(orcamento.getId_item());
             o.setPaciente_id(orcamento.getPaciente_id());
             o.setPago(orcamento.isPago());
             
            
              em.getTransaction().commit();
          }
      }catch(Exception e){
          em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "erro ao cadastrar consulta" + e);
          throw e;
      }
      finally{
          JPAUtil.closeEntityManager();
      }
    } 
     
     
    
}
