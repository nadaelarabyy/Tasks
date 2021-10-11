package com.example.task8;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController

public class TaskApplication {

    public static void main(String[] args) {

        SpringApplication.run(TaskApplication.class, args);
    }
//    create departments
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
        return args -> {
            System.out.println("Query Employees by their role==>");
            employeeRepository
                    .queryAllByRole("DEVELOPER")
                    .forEach(System.out::println);
            System.out.println("Query Employees by their project name==>");
//            get id of project
            int projId = employeeRepository.getProjectIdByName("NBE").intValue();
//            get employees
//            employeeRepository.queryAllByWorkingProjectName(projId).forEach(System.out::println);





        };
    }


    public static void generateEmps(EmployeeRepository employeeRepository,
                                    RoleRepository roleRepository){
        //            ------------------------Employee-----------------------------------

    }
    public static void generateDeps(DepartmentRepository departmentRepository){
        //            department instances
        Department department1 = new Department("SOFTWARE_DEVELOPMENT", "1ST_FLOOR");
        Department department2 = new Department("BUSINESS_ANALYSIS", "2ND_FLOOR");
        Department department3 = new Department("SALES", "3RD_FLOOR");
        Department department4 = new Department("HUMAN_RESOURCES", "3RD_FLOOR");
        Department department5 = new Department("MANAGEMENT", "1ST_FLOOR");
            departmentRepository.saveAll(List.of(department1,department2,
                    department3,department4,department5));

    }
    public static void generateRoles(
            DepartmentRepository departmentRepository
            ,RoleRepository roleRepository){

//  ------------------          create roles --------------------------
        Optional<Department> dep1 = departmentRepository.findById(6L);
        Optional<Department> dep2 = departmentRepository.findById(7L);
        Optional<Department> dep3 = departmentRepository.findById(8L);
        Optional<Department> dep4 = departmentRepository.findById(9L);
        Optional<Department> dep5 = departmentRepository.findById(10L);
        Role role1 =null;
        Role role2 = null;
        Role role3 = null;
        Role role4 = null;
        Role role5 = null;
        Role role6 = null;
        Role role7= null;
        if(dep1.isPresent()) {
            role1 = new Role("DEVELOPER",
                    dep1.get());
            role2 = new Role("HEAD_DEVELOPER",
                    dep1.get());
        }
        if(dep2.isPresent()) {
            role3 = new Role("ANALYST",
                    dep2.get());
            role5 = new Role("SALES_ENGINEER",
                    dep3.get());
            role6 = new Role("HEAD_SALES",
                    dep3.get());
        }
        if(dep4.isPresent()) {
            role4 = new Role("HR_ASSOCIATE",
                    dep4.get());
        }
        if(dep5.isPresent()) {
            role7 = new Role("PROJECT_MANAGER",
                    dep5.get());
        }
//            roleRepository.saveAll(List.of(role1,role2,role3,role4,
//            role5,role6,role7));
    }



}
