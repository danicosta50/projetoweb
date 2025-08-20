/**
     * metodo dao para salvar dados na tabela usuario
     * 
     * 
     */
package test.DAO;

import Entidades.paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
  
  public class pacienteDAO {
      
      public void cadastrar(paciente p){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(p);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "erro ao cadastrar paciente" + e);
      
              throw e;
          }
          finally{
              JPAUtil.closeEntityManager();
          }
      }
      
      
      public List<paciente> listar(String nome, String cpf){
      EntityManager em = JPAUtil.getEntityManager();
      try{
         String textquery = "SELECT p FROM paciente p WHERE (:nome is null OR p.nome LIKE :nome)  And (:cpf is null or p.cpf like :cpf)";
          Query paciente = em.createQuery(textquery);
           paciente.setParameter("nome", nome.isEmpty() ? null : "%" + nome + "%" );
           paciente.setParameter("cpf",cpf.isEmpty()?null:"%" + cpf + "%");
          List<paciente> pacientes = paciente.getResultList();
          return pacientes;
      }
      catch(Exception e){
              em.getTransaction().rollback();
               JOptionPane.showMessageDialog(null, "erro ao listar pacientes" + e);
              throw e;
                
          }
      finally{
          JPAUtil.closeEntityManager();
      }
    } 
         public List<paciente> listar(){
      EntityManager em = JPAUtil.getEntityManager();
      try{
      
          Query consulta = em.createQuery("SELECT p FROM paciente p");
   
          List<paciente> pacientes = consulta.getResultList();
          return pacientes;}
          catch(Exception e){
              em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "erro ao listar pacientes" + e);
      
              throw e;
          }
          finally{
              JPAUtil.closeEntityManager();
          }
 
    } 
         public void excluir(int id){
      EntityManager em = JPAUtil.getEntityManager();
      try{
        paciente p  = em.find(paciente.class, id);
          if(p != null){
              em.getTransaction().begin();
              em.remove(p);
              em.getTransaction().commit();
          }
      }catch(Exception e){
          em.getTransaction().rollback();
          throw e;
      }
      finally{
          JPAUtil.closeEntityManager();
      }
    }  
     
     public void atualizar(paciente paciente){
      EntityManager em = JPAUtil.getEntityManager();
      try{
        paciente p  = em.find(paciente.class, paciente.getId());

          if(p != null){
              em.getTransaction().begin();
             p.setCpf(paciente.getCpf());
             p.setDataNasc(paciente.getDataNasc());
            p.setEmail(paciente.getEmail());
            p.setEndereco(paciente.getEndereco());
           p.setHistorico_medico(paciente.getHistorico_medico());
           p.setNome(paciente.getNome());
           p.setTelefone(paciente.getTelefone());
              em.getTransaction().commit();
          }
      }catch(Exception e){
          em.getTransaction().rollback();
          throw e;
      }
      finally{
          JPAUtil.closeEntityManager();
      }
    }  
     
    
}
