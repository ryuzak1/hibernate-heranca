package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DaoGerenic<E> {

    private EntityManager entityManager = HibernateUtil.getEntityManager();

    public boolean salvar(E entidade){
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(entidade);
            transaction.commit();
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;

        }
    }
}
