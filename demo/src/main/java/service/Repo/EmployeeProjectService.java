package service.Repo;


import entity.EmployeeProjectEntity;
import org.hibernate.HibernateException;

import javax.persistence.*;

public class EmployeeProjectService {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public EmployeeProjectService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();

    }

    public String addEmployeeProject(EmployeeProjectEntity epe) throws Exception {
        String message = "";
        try
        {
            transaction.begin();
            Query query3 = entityManager.createNativeQuery("insert into employee_project(Employee_id,Project_id) values(?1,?2)");
            query3.setParameter(1,epe.getEmployeeId());
            query3.setParameter(2,epe.getProjectId());
            query3.executeUpdate();
            transaction.commit();
            entityManager.close();
            message = "Success";
        } catch (Exception ex)
        {
            message = ex.getMessage();
            throw new Exception("This entry added already exists");
        }
        return message;



    }


}
