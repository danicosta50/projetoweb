package test.DAO;

import Entidades.OrcamentoItem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
  
  public class OrcamentoItemDAO {
      
      public void cadastrar(OrcamentoItem o){
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
 
public List<OrcamentoItem> listar() {  
    EntityManager em = JPAUtil.getEntityManager();
    try {
        String textoquery = " SELECT o FROM OrcamentoItem o "
             
               ;
        Query consultaSql = em.createQuery(textoquery);     
        
      

        List<OrcamentoItem> orcamentoLista = consultaSql.getResultList();
        return orcamentoLista;
    } catch(Exception e) {
        em.getTransaction().rollback();
        JOptionPane.showMessageDialog(null, "Erro ao listar itens de orcamento: " + e);
        throw e;
    } finally {
        JPAUtil.closeEntityManager();
    }
}

     public OrcamentoItem listarporId(Integer id){
      EntityManager em = JPAUtil.getEntityManager();
      try{
         String textquery = "SELECT OI FROM OrcamentoItem OI WHERE  OI.id = :id";
          Query consulta = em.createQuery(textquery, OrcamentoItem.class);
           consulta.setParameter("id",id);
          
          return (OrcamentoItem) consulta.getSingleResult();
      }
      catch(Exception e){
             
               JOptionPane.showMessageDialog(null, "erro ao listar pacientes" + e);
              throw e;
                
          }
      finally{
          JPAUtil.closeEntityManager();
      }
    } 
       
   public void excluir(int id) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        // Verifica se existe um Orcamento vinculado ao OrcamentoItem
        Query consulta = em.createQuery("SELECT COUNT(o) FROM Orcamento o WHERE o.id_item = :id");
        consulta.setParameter("id", id);
        Long qtdOrcamentos = (Long) consulta.getSingleResult(); // Obtém a quantidade de registros encontrados

        if (qtdOrcamentos > 0) {
            JOptionPane.showMessageDialog(null, "Não é possível excluir este item. Ele está vinculado a um orçamento.");
            return; // Sai do método sem excluir
        }

        // Prossegue com a exclusão se não houver vínculos
        OrcamentoItem o = em.find(OrcamentoItem.class, id);
        if (o != null) {
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
        }
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
        throw e;
    } finally {
        em.close(); // Fecha o EntityManager corretamente
    }
}
 
         
   public void atualizar(OrcamentoItem orcamentoItem){
      EntityManager em = JPAUtil.getEntityManager();
      try{
        OrcamentoItem o  = em.find(OrcamentoItem.class, orcamentoItem.getId());

          if(o != null){
              em.getTransaction().begin();
             o.setDescricao(orcamentoItem.getDescricao());
             o.setItem(orcamentoItem.getItem());
             o.setValor(orcamentoItem.getValor());
             
            
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
