package test.DAO;

import Entidades.consulta;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
  
  public class consultaDAO {
      
      public void cadastrar(consulta c){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(c);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              JOptionPane.showMessageDialog(null, "erro ao cadastrar consulta" + e);
              throw e;
          }
      
          finally{
              JPAUtil.closeEntityManager();
          }
      }
 public List<consulta> listar(String nome) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        String jpql = "SELECT C FROM consulta C WHERE LOWER(C.nomePaciente) LIKE :nome";
        Query query = em.createQuery(jpql);
        query.setParameter("nome", "%" + nome.toLowerCase() + "%");

        return query.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao listar consultas: " + e.getMessage());
        throw e;
    } finally {
        JPAUtil.closeEntityManager();
    }
}

public List<consulta> listar(String nome, String dataIni, String dataFim) {  
    EntityManager em = JPAUtil.getEntityManager();
    try {
        String textoquery = " SELECT C FROM consulta C "
                + "WHERE (:nome is null OR C.nomePaciente LIKE :nome ) "
                + "AND (:dataIni is null OR C.dataConsulta >= :dataIni) "
                + "AND (:dataFim is null OR C.dataConsulta <= :dataFim)  ";
        Query consultaSql = em.createQuery(textoquery);     
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Converte LocalDate para java.sql.Date
        java.util.Date dataIniDate = dataIni == null ? null : Date.valueOf(LocalDate.parse(dataIni, formatter));
        java.util.Date dataFimDate = dataFim == null ? null : Date.valueOf(LocalDate.parse(dataFim, formatter));
        
        consultaSql.setParameter("dataIni", dataIniDate);
        consultaSql.setParameter("dataFim", dataFimDate);
        consultaSql.setParameter("nome", nome.isEmpty() ? null : "%" + nome + "%" );       

        List<consulta> consultasLista = consultaSql.getResultList();
        return consultasLista;
    } catch(Exception e) {
        em.getTransaction().rollback();
        JOptionPane.showMessageDialog(null, "Erro ao listar consultas: " + e);
        throw e;
    } finally {
        JPAUtil.closeEntityManager();
    }
}

    
         public List<consulta> listar(){
      EntityManager em = JPAUtil.getEntityManager();
      try{
      
          Query consultalista = em.createQuery("SELECT c FROM consulta c");
   
          List<consulta>consultas = consultalista.getResultList();
          return consultas;}
          catch(Exception e){
          em.getTransaction().rollback();
                JOptionPane.showMessageDialog(null, "erro ao cadastrar consulta" + e);
          throw e;
      }finally{
          JPAUtil.closeEntityManager();
      }
    } 
         public void excluir(int id){
      EntityManager em = JPAUtil.getEntityManager();
      try{
        consulta c  = em.find(consulta.class, id);
          if(c!= null){
              em.getTransaction().begin();
              em.remove(c);
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
        
   public List<consulta> listar_Nome(String nome) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        String jpql = "SELECT C FROM consulta C WHERE LOWER(C.nomePaciente) LIKE :nome";
        Query query = em.createQuery(jpql);
        query.setParameter("nome", "%" + nome.toLowerCase() + "%");

        return query.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao listar consultas: " + e.getMessage());
        throw e;
    } finally {
        JPAUtil.closeEntityManager();
    }
}

         
   public void atualizar(consulta consulta){
      EntityManager em = JPAUtil.getEntityManager();
      try{
        consulta c  = em.find(consulta.class, consulta.getId());

          if(c != null){
              em.getTransaction().begin();
          
             c.setConsultaRealizada(consulta.isConsultaRealizada());
             c.setCpf(consulta.getCpf());
             c.setDataConsulta(consulta.getDataConsulta());
             c.setNomePaciente(consulta.getNomePaciente());
             c.setReceitaObservacoes(consulta.getReceitaObservacoes());
             c.setValor(consulta.getValor());
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
