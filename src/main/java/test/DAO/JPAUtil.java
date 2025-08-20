/**
     * metodo para criar entidade e fabrica da conexao banco dados
     * 
     * 
     */

package test.DAO;

  import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

  
  public class JPAUtil {
 
    private static final String PERSISTENCE_UNIT = "odonto";
    
    private static EntityManager em;
    private static EntityManagerFactory fabrica;
    
    //cria a entidade se estiver nula e a retorna
    public static EntityManager getEntityManager(){
        if(fabrica == null || !fabrica.isOpen())
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        
        if(em == null || !em.isOpen()) //cria se em nulo ou se o entity manager foi fechado
            em = fabrica.createEntityManager();

        return em;
    }
    
    //fecha o EntityManager e o factory
public static void closeEntityManager() {
    if (em != null && em.isOpen()) {
        em.close();
    }
    if (fabrica != null && fabrica.isOpen()) {
        fabrica.close();
    }
}

  }              
