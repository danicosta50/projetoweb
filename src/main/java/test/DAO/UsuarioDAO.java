/**
     * metodo dao para salvar dados na tabela usuario
     * 
     * 
     */
package test.DAO;

import Entidades.usuario;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;


public class UsuarioDAO {
     public static usuario validarUsuario(usuario usuario) {
                 usuario usuarioEncontrado = new usuario();
                    usuarioEncontrado = null;
                    ;
         try{
         EntityManager em = JPAUtil.getEntityManager();
         
        em.getTransaction().begin();
        
         TypedQuery<usuario> consulta = em.createQuery("SELECT u FROM usuario u WHERE u.login = :login AND u.senha = :senha", usuario.class);
         String login = usuario.getLogin();
         String senha = usuario.getSenha();
         consulta.setParameter("login", login);
         consulta.setParameter("senha", senha);
         usuarioEncontrado = consulta.getSingleResult();
            if (em != null && em.isOpen()) {
        em.close();
    }
   
         } catch(Exception e){
              //JOptionPane.showMessageDialog(null, "Ocorreu uma falha:\n" + e.getMessage());
              JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum usuario com este login e senha.");

         }
            finally{
              JPAUtil.closeEntityManager();
          }
        return  usuarioEncontrado;
}
     
     
    
}

