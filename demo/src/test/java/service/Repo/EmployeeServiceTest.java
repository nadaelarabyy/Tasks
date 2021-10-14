package service.Repo;

import entity.DepartmentEntity;
import entity.EmployeeEntity;
import entity.RoleEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.NoResultException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {
    EmployeeService es;
    EmployeeEntity created;
    @BeforeEach
    void init(){
         es = mock(EmployeeService.class);
         created = new EmployeeEntity();
         created.setEmpId(1);
        created.setAge((byte) 23);
        created.setEmail("nadaelaraby@yaho.com");
        created.setFirstName("nada");
        created.setLastName("elaraby");
        created.setHireDate(Date.valueOf("2021-08-15"));
        created.setNationalId("XXXX-XXXX-XX");
        created.setSalary(1000);
        RoleEntity re = new RoleEntity();
        re.setRoleId(1);
        re.setRoleName("DEVELOPER");
        DepartmentEntity de = new DepartmentEntity();
        de.setDepId(1);
        de.setDepName("SOFTWARE");
        de.setDepLoc("2nd floor");
        re.setDepartmentId(de);
        created.setDepRoleId(re);

    }
    @Test
    void FetchNonWorkingEmployeesByRoleNotFoundRole(){
        EmployeeService employeeService = spy(EmployeeService.class);
        List<EmployeeEntity> employeesReturned = employeeService.getNonWorkingEmployeesByRole("Tester");
        assertEquals(employeesReturned.size(),0,"Returned an empty list as this role does not exist");
    }
    @Test
    void fetchEmployeesByProjectNameNotFound(){
        EmployeeService employeeService = spy(EmployeeService.class);
        List<EmployeeEntity> employeesReturned = employeeService.getEmployeesByProjectName("NBQ");
        assertEquals(employeesReturned.size(),0,
                "Returned an empty list as this project does not exist");
    }
    @Test
    void fetchEmployeeByIdNotFound(){
        EmployeeService employeeService = spy(EmployeeService.class);
        Throwable exception = assertThrows(NoResultException.class,
                () -> employeeService.getEmployeeByid(0));
        assertEquals("No Employee found with this id!!",
                exception.getMessage());
    }
    @Test
    void getEmployeesIndexSizeExceeded(){
        EmployeeService employeeService = spy(EmployeeService.class);
        List<EmployeeEntity> employeesReturned = employeeService.getAllEmployeesPaginated(100,10000);
        assertEquals(employeesReturned.size(),0,"Returned an empty list as this index and sized exceeds values!!");
    }

    @Test
    void getAllEmployees() {
        EmployeeService employeeService = spy(EmployeeService.class);
        List<EmployeeEntity> employeesCreated = new ArrayList<EmployeeEntity>();
        employeesCreated.add(created);
        when(employeeService.getAllEmployees()).thenReturn(employeesCreated);
        List<EmployeeEntity> employeesReturned = employeeService.getAllEmployees();
        assertTrue(employeesCreated.equals(employeesReturned));


    }

    @Test
    void getNonWorkingEmployeesByRole() {
        List<EmployeeEntity> employeesCreated = new ArrayList<EmployeeEntity>();
        employeesCreated.add(created);
        when(es.getNonWorkingEmployeesByRole("DEVELOPER")).thenReturn(employeesCreated);
        List<EmployeeEntity> employeesReturned = es.getNonWorkingEmployeesByRole("DEVELOPER");
        assertTrue(employeesCreated.equals(employeesReturned));
    }

    @Test
    void getEmployeesByProjectName() {
        List<EmployeeEntity> employeesCreated = new ArrayList<EmployeeEntity>();
        employeesCreated.add(created);
        when(es.getEmployeesByProjectName("NBE")).thenReturn(employeesCreated);
        List<EmployeeEntity> employeesReturned = es.getEmployeesByProjectName("NBE");
        assertTrue(employeesCreated.equals(employeesReturned),
                "Employees by project name fetched successfully");
    }

    @Test
    void getEmployeeById() {
        when(es.getEmployeeByid(1)).thenReturn(created);
        EmployeeEntity returned = es.getEmployeeByid(1);
        assertEquals(created.getEmpId(),returned.getEmpId(),
                "Employee is returned successfully");
    }

    @Test
    void getAllEmployeesPaginated() {
        List<EmployeeEntity> employeesCreated = new ArrayList<EmployeeEntity>();
        employeesCreated.add(created);
        when(es.getAllEmployeesPaginated(0,1)).thenReturn(employeesCreated);
        List<EmployeeEntity> employeesReturned = es.getAllEmployeesPaginated(0,1);
        assertTrue(employeesCreated.equals(employeesReturned),
                "Testing pagination successfully");
    }
}