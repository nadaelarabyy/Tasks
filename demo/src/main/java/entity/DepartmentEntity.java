package entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @Column(name = "dep_id")
    private int depId;
    @Basic
    @Column(name = "dep_name")
    private String depName;
    @Basic
    @Column(name = "dep_loc")
    private String depLoc;


    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }


    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }


    public String getDepLoc() {
        return depLoc;
    }

    public void setDepLoc(String depLoc) {
        this.depLoc = depLoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (depId != that.depId) return false;
        if (depName != null ? !depName.equals(that.depName) : that.depName != null) return false;
        if (depLoc != null ? !depLoc.equals(that.depLoc) : that.depLoc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = depId;
        result = 31 * result + (depName != null ? depName.hashCode() : 0);
        result = 31 * result + (depLoc != null ? depLoc.hashCode() : 0);
        return result;
    }
}
