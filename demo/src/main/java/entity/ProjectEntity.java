package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "project", schema = "employeesdb")
public class ProjectEntity {

    @Id
    @Column(name = "proj_id")
    private int projId;
    @Basic
    @Column(name = "proj_name")
    private String projName;
    @ManyToOne
    @JoinColumn(name="project_manager")
    private EmployeeEntity projectManager;
    @Basic
    @Column(name = "start_date")
    private Date startDate;


    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }


    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public EmployeeEntity getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(EmployeeEntity projectManager) {
        this.projectManager = projectManager;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectEntity that = (ProjectEntity) o;

        if (projId != that.projId) return false;
        if (projName != null ? !projName.equals(that.projName) : that.projName != null) return false;
        if (projectManager != null ? !projectManager.equals(that.projectManager) : that.projectManager != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projId;
        result = 31 * result + (projName != null ? projName.hashCode() : 0);
        result = 31 * result + (projectManager != null ? projectManager.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }
}
