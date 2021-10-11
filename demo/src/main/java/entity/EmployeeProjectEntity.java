package entity;

import javax.persistence.*;

@Entity
@Table(name = "employee_project", schema = "employeesdb")
@IdClass(EmployeeProjectEntityPK.class)
public class EmployeeProjectEntity {
    @Id
    @OneToOne
    @JoinColumn(name = "Employee_id")
    private EmployeeEntity employeeId;
    @Id
    @OneToOne
    @JoinColumn(name = "Project_id")
    private ProjectEntity projectId;

    public EmployeeEntity getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeEntity employeeId) {
        this.employeeId = employeeId;
    }

    public ProjectEntity getProjectId() {
        return projectId;
    }

    public void setProjectId(ProjectEntity projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeProjectEntity that = (EmployeeProjectEntity) o;

        if (employeeId != that.employeeId) return false;
        if (projectId != that.projectId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId.getEmpId();
        result = 31 * result + projectId.getProjId();
        return result;
    }
}
