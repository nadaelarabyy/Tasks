package com.example.task8;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Department")
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dep_id", nullable = false,
    columnDefinition = "int")
    private long depId;
    @Column(name = "dep_name", nullable = false,columnDefinition = "tinytext")
    private String depName;
    @Column(name = "dep_loc", columnDefinition = "text")
    private String depLoc;

//    @OneToMany(mappedBy = "department")
//    private Set<Role> roles;

    public Department(String depName, String depLoc) {
        this.depName = depName;
        this.depLoc = depLoc;
    }

    public Department() {

    }

    public long getDepId() {
        return depId;
    }

    public String getDepName() {
        return depName;
    }

    public String getDepLoc() {
        return depLoc;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", depLoc='" + depLoc + '\'' +
                '}';
    }
}
