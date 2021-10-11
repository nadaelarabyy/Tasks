import entity.DepartmentEntity;
import entity.EmployeeEntity;
import entity.RoleEntity;

import javax.management.relation.Role;
import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
//            query 1 -> all employees with their respective role and info
            TypedQuery<EmployeeEntity> query1 = entityManager.createNamedQuery("EmployeeByRole",EmployeeEntity.class);
            query1.setParameter(1, "DEVELOPER");
            for (EmployeeEntity employee : query1.getResultList()) {
                System.out.println(employee.toString());
            }
            System.out.println("==================================================");
//            query 2 -> all employees with a specific project name
            Query query2 = entityManager.createNativeQuery("select * from employee e inner join employee_project ep inner join project p on e.emp_id = ep.Employee_id and ep.Project_id = p.proj_id where p.proj_name= ?",
                    EmployeeEntity.class);
            query2.setParameter(1,"NBE");
            for(Object emp:query2.getResultList()){
                System.out.println(emp.toString());
            }
//            query 3 -> add an employee to a certain project
            Query query3 = entityManager.createNativeQuery("insert into employee_project(Employee_id,Project_id) values(?1,?2)");
            query3.setParameter(1,1);
            query3.setParameter(2,5);
//            query3.executeUpdate();
//            query 4 -> display employees with a certain role who are currently
//            not working on a project
            Query query4 = entityManager.createNativeQuery("select empl.* from (select * from employee e inner join role r on r.role_id = e.dep_role_id where r.role_name = ?1) As empl left join (select * from Employee_project ep) as epp on empl.emp_id = epp.Employee_id;",EmployeeEntity.class);
            query4.setParameter(1,"HR_ASSOCIATE");
            for(Object emp:query4.getResultList()){
                System.out.println(emp.toString());
            }







transaction.commit();

        }
        finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
