package com.example.task8;

import javax.persistence.*;
import java.util.Set;

@Entity(name="Role")
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false,columnDefinition = "int")
    private long roleID;
    @Column(name = "role_name", nullable = false,columnDefinition = "tinytext")
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
//    --------------------------
//    @OneToMany(mappedBy = "depRole")
//    private Set<Employee> employees;

//    ------------------------------

    public Role(String roleName, Department department) {
        this.roleName = roleName;
        this.department = department;
    }

    public Role() {

    }

    public long getRoleID() {
        return roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public Department getDepartment() {
        return department;
    }


    @Override
    public String toString() {
        return "Role{" +
                "roleID=" + roleID +
                ", roleName='" + roleName + '\'' +
                ", department=" + department +
                '}';
    }
}
