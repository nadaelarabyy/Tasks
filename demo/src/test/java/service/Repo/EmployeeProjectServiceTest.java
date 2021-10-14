package service.Repo;

import entity.EmployeeEntity;
import entity.EmployeeProjectEntity;
import entity.ProjectEntity;
import org.hibernate.HibernateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeProjectServiceTest {
    EmployeeProjectService eps;
    EmployeeProjectEntity epe;
    @BeforeEach
    void init(){
        eps = mock(EmployeeProjectService.class);
        EmployeeService es = new EmployeeService();
        ProjectService ps = new ProjectService();
        EmployeeEntity ee = es.getEmployeeByid(1);
        ProjectEntity pe = ps.getProjectByid(1);
        epe = new EmployeeProjectEntity();
        epe.setEmployeeId(ee);
        epe.setProjectId(pe);
    }
    @Test
    void assignEmployeeProjectSuccess() throws Exception {
        when(eps.addEmployeeProject(epe)).thenReturn("Success");
        String response1 = eps.addEmployeeProject(epe);
        assertEquals(response1,"Success","Employee and project added sucessfully");
    }
    @Test
    void assignEmployeeProjectException(){
        EmployeeProjectService eps = spy(EmployeeProjectService.class);
        Throwable exception = assertThrows(Exception.class, () -> eps.addEmployeeProject(epe));
        assertEquals("This entry added already exists", exception.getMessage());

    }

}