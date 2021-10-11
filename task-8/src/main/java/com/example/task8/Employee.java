package com.example.task8;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_id", nullable = false,columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name",
            nullable = false,
            columnDefinition = "tinytext")
    private String firstName;
    @Column(name = "last_name",
            columnDefinition = "tinytext")
    private String lastName;
    @Column(name = "email", nullable = false,
    unique = true, columnDefinition = "text")
    private String email;
    @Column(name = "national_ID",
            columnDefinition = "text", unique = true)
    private String nationalID;
    @Column(name = "age",columnDefinition = "tinyint")
    private int age;
    @Column(
            name="hire_date",
            columnDefinition="Date",
            nullable = false)
    private Date hireDate;
    @Column(name = "salary", columnDefinition = "int default 0")
    private int salary;
//    -------------------------------------
    @ManyToOne
    @JoinColumn(name = "dep_role_id")
    private Role depRole;
//    ---------------------------------------


    @OneToMany(mappedBy = "project_manager")
    private Set<Project> management_project;
    @ManyToMany(mappedBy = "workingEmployees")
    private Set<Project> projects = new HashSet<>();
    public Employee(){}
    public Employee(String firstName, String lastName, String email,
                    String nationalID, int age, Date hireDate,
                    int salary, Role depRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nationalID = nationalID;
        this.age = age;
        this.hireDate = hireDate;
        this.salary = salary;
        this.depRole = depRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getNationalID() {
        return nationalID;
    }

    public int getAge() {
        return age;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public Role getDepRole() {
        return depRole;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", nationalID='" + nationalID + '\'' +
                ", age=" + age +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", depRole=" + depRole +
                '}';
    }
}
