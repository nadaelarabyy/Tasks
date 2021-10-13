package service.Repo;

import entity.EmployeeEntity;

import javax.persistence.*;
import java.util.List;

public class EmployeeService {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public EmployeeService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();

    }

    public List<EmployeeEntity> getAllEmployees() {

        String out = "";
        try {
            transaction.begin();
//            query 1 -> all employees with their respective role and info
            Query query1 = entityManager.createNativeQuery("select distinct * from employee", EmployeeEntity.class);

//            for (Object employee : query1.getResultList()) {
//                out += employee.toString() + "\n";
//            }
            return query1.getResultList();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public List<EmployeeEntity> getNonWorkingEmployeesByRole(String role) {
        transaction.begin();
        String out="";
        try {
//            query 1 -> all employees with their respective role
            Query query4 = entityManager.createNativeQuery("select distinct empl.* from (select * from employee e inner join role r on r.role_id = e.dep_role_id where r.role_name = ?1) As empl left join (select * from Employee_project ep) as epp on empl.emp_id = epp.Employee_id;",EmployeeEntity.class);
            query4.setParameter(1,role);
            return query4.getResultList();

            
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }

    public List<EmployeeEntity> getEmployeesByProjectName(String project) {
        transaction.begin();
        String out="";
        try {
            Query query2 = entityManager.createNativeQuery("select e.* from employee e inner join employee_project ep inner join project p on e.emp_id = ep.Employee_id and ep.Project_id = p.proj_id where p.proj_name= ?",EmployeeEntity.class);
            query2.setParameter(1,project);

//            for (Object emp:query2.getResultList()){
//                out+=emp.toString()+"\n";
//            }
            return query2.getResultList();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }

    public EmployeeEntity getEmployeeByid(int id){
        transaction.begin();
        try {
            Query query2 = entityManager.createNativeQuery("select * from employee e where e.emp_id=?1",EmployeeEntity.class);
            query2.setParameter(1,id);
            Object out = query2.getSingleResult();
            return (EmployeeEntity) out;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

    }

}
