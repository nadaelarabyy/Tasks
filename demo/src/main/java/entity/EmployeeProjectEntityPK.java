package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EmployeeProjectEntityPK implements Serializable {
    private int employeeId;
    private int projectId;

    @Column(name = "Employee_id")
    @Id
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "Project_id")
    @Id
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeProjectEntityPK that = (EmployeeProjectEntityPK) o;

        if (employeeId != that.employeeId) return false;
        if (projectId != that.projectId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + projectId;
        return result;
    }
}
