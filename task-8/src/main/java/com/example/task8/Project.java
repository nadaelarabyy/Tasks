package com.example.task8;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Project")
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proj_id", nullable = false,columnDefinition = "int")
    private long project_ID;
    @Column(name = "proj_name", nullable = false,
            columnDefinition = "text")
    private String title;
    @Column(
            name="start_date",
            columnDefinition="Date",
            nullable = false)
    private Date start_date;
    @ManyToOne
    @JoinColumn(name="project_manager")
    private Employee project_manager;


    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "Project_id"),
            inverseJoinColumns = @JoinColumn(name = "Employee_id")
    )
    private Set<Employee> workingEmployees = new HashSet<>();

    public Project(String title, Date start_date, Employee project_manager) {
        this.title = title;
        this.start_date = start_date;
        this.project_manager = project_manager;
    }

    public Project() {

    }


    public long getProject_ID() {
        return project_ID;
    }

    public String getTitle() {
        return title;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Employee getProject_manager() {
        return project_manager;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_ID=" + project_ID +
                ", title='" + title + '\'' +
                ", start_date=" + start_date +
                ", project_manager=" + project_manager +
                '}';
    }
}
