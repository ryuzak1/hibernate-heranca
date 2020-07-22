package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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

    public E pesquisar(E entidade){

        Object id = HibernateUtil.getPrimaryKey(entidade);
        E e = (E)entityManager.find(entidade.getClass(),id);
        return  e;
    }

    public E pesquisaID(long id,Class<E> entidade){
        E e = (E)entityManager.find(entidade,id);
        return e;

    }
    public void deletarId(E enridade){
        Object id = HibernateUtil.getPrimaryKey(enridade);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String slq = "delete from "+enridade.getClass().getSimpleName().toLowerCase()+ " where id="+id;
        entityManager.createQuery(slq).executeUpdate();
        transaction.begin();
    }

    public void deleteID(E entidade){

        Object id = HibernateUtil.getPrimaryKey(entidade);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String sql = "delete from"+entidade.getClass().getSimpleName().toLowerCase()+
                " where id="+id;
        System.out.println(sql);
        entityManager.createNativeQuery("delete from "+entidade.getClass().getSimpleName().toLowerCase()+
                " where id="+id).executeUpdate();
        transaction.commit();

    }

    public List<E> listar(Class<E> entidade){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<E> listar = entityManager.createQuery("from "+entidade.getName()).getResultList();
        entityTransaction.commit();
        return listar;
    }

}
