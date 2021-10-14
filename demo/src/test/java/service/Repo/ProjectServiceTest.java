package service.Repo;

import entity.DepartmentEntity;
import entity.EmployeeEntity;
import entity.ProjectEntity;
import entity.RoleEntity;
import org.junit.jupiter.api.Test;

import javax.persistence.NoResultException;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class ProjectServiceTest {

    @Test
    void getProjectByIdSuccessfully(){
        ProjectService ps = mock(ProjectService.class);
        ProjectEntity created = new ProjectEntity();
        created.setProjId(1);
        created.setProjName("Test project");
        created.setStartDate(Date.valueOf("2020-12-27"));
//        --------------------------------------
        EmployeeEntity ee = new EmployeeEntity();
        ee.setEmpId(1);
        ee.setAge((byte) 23);
        ee.setEmail("nadaelaraby@yaho.com");
        ee.setFirstName("nada");
        ee.setLastName("elaraby");
        ee.setHireDate(Date.valueOf("2021-08-15"));
        ee.setNationalId("XXXX-XXXX-XX");
        ee.setSalary(1000);
        RoleEntity re = new RoleEntity();
        re.setRoleId(1);
        re.setRoleName("DEVELOPER");
        DepartmentEntity de = new DepartmentEntity();
        de.setDepId(1);
        de.setDepName("SOFTWARE");
        de.setDepLoc("2nd floor");
        re.setDepartmentId(de);
        ee.setDepRoleId(re);
//                -----
        created.setProjectManager(ee);
        when(ps.getProjectByid(1)).thenReturn(created);
        ProjectEntity pe = ps.getProjectByid(1);
        assertEquals(created.getProjId(),pe.getProjId(),
                "Fetching the project by id successfully");
    }
    @Test
    void getProjectByIdNotFound(){
        ProjectService ps = spy(ProjectService.class);
        Throwable exception = assertThrows(NoResultException.class, () -> ps.getProjectByid(0));
        assertEquals("No project found with this id!!", exception.getMessage());

    }

}