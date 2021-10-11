package com.example.task8;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "select new Employee(e.firstName,e.lastName,e.email,e.nationalID,e.age,e.hireDate,e.salary,e.depRole) from Employee e inner join Role r on e.depRole.roleID = r.roleID where r.roleName=?1")
    List<Employee> queryAllByRole(String role);

    @Query(value = "select p.project_ID from Project p where p.title=?1")
    Integer getProjectIdByName(String projName);

//    @Query(value = "select new Employee(e.firstName,e.lastName,e.email,e.nationalID,e.age,e.hireDate,e.salary,e.depRole) from Employee e inner join Employee_project ep on ep.Employee_id = e.id where ep.Project_id = ?1 ")
//    List<Employee> queryAllByWorkingProjectName(int projectId);










}
