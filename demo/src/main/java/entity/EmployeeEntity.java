package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee", schema = "employeesdb")
@NamedQuery(name = "EmployeeByRole",query = "select e from EmployeeEntity e inner join RoleEntity r on e.depRoleId.roleId = r.roleId where r.roleName=?1")
public class EmployeeEntity {
    @Id
    @Column(name = "emp_id")
    private int empId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "national_ID")
    private String nationalId;
    @Basic
    @Column(name = "age")
    private Byte age;
    @Basic
    @Column(name = "hire_date")
    private Date hireDate;
    @Basic
    @Column(name = "salary")
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "dep_role_id")
    private RoleEntity depRoleId;


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }


    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }


    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }


    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public RoleEntity getDepRoleId() {
        return depRoleId;
    }

    public void setDepRoleId(RoleEntity depRoleId) {
        this.depRoleId = depRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (empId != that.empId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (nationalId != null ? !nationalId.equals(that.nationalId) : that.nationalId != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (hireDate != null ? !hireDate.equals(that.hireDate) : that.hireDate != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;
        if (depRoleId != null ? !depRoleId.equals(that.depRoleId) : that.depRoleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nationalId != null ? nationalId.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (depRoleId != null ? depRoleId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee: " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", age=" + age +
                ", hireDate=" + hireDate +
                ", salary=" + salary
                +", role= "+depRoleId.getRoleName()
                +", department Name= "+depRoleId.getDepartmentId().getDepName()
                +", department location= "+depRoleId.getDepartmentId().getDepLoc();
    }
}
