package service.Repo;

import entity.EmployeeEntity;
import entity.ProjectEntity;

import javax.persistence.*;

public class ProjectService {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;
    public ProjectService(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
    public ProjectEntity getProjectByid(int id){
        transaction.begin();
        try {
            Query query2 = entityManager.createNativeQuery("select * from project p where proj_id= ?1",ProjectEntity.class);
            query2.setParameter(1,id);
            Object out = query2.getSingleResult();
            return (ProjectEntity) out;
        }catch (NoResultException ne){
            throw new NoResultException("No project found with this id!!");
        }
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

    }
}
