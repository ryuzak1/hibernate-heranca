package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    public static EntityManagerFactory factory= null;
    static {

        init();
    }

    public static void init(){

      try {
          if (factory==null) {
              factory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
              System.out.println("Conectado ao banco");
          }
      }catch (Exception e){
          e.printStackTrace();
          System.out.println("erro ao conectad com banco\n");
          System.out.println("Mensagem:"+e.getMessage()+"\n");
          System.out.println("Mensagem:"+e.getCause()+"\n");

      }

    }

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

}
