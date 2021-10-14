package service.REST;

import DTO.Paginator;
import entity.DepartmentEntity;
import entity.EmployeeEntity;
import entity.RoleEntity;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


class EmployeeResourceTest {
    WebTarget target;
    EmployeeResource employeeResource;
    List<EmployeeEntity> employeeEntities;
    @BeforeEach
    void init(){
        URI uri = UriBuilder.fromUri("http://localhost:8080").build();
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        target = client.target(uri);
        EmployeeEntity created = new EmployeeEntity();
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
        employeeEntities = new ArrayList<>();
        employeeEntities.add(created);
        employeeResource = spy(EmployeeResource.class);
    }


    @Test
    void getAllEmployeesTest(){
        Response responseCreated = Response.ok(employeeEntities).build();
        when(employeeResource.getAllEmployees()).thenReturn(responseCreated);
        Response response = target.path("api")
                .path("Employee").request()
                .accept(MediaType.APPLICATION_JSON)
                .get(Response.class);

        assertTrue(response.getMediaType().toString()
                .equals("application/json"));
        assertEquals(response.getStatus(),200);
    }
    @Test
    void getNonWorkingByRoleTest(){
        Response responseCreated = Response.ok(employeeEntities).build();
        when(employeeResource.getNonWorkingEmployeesByRole("DEVELOPER"))
                .thenReturn(responseCreated);
        Response response = target.path("api")
                .path("Employee")
                .path("NonWorking")
                .queryParam("role","DEVELOPER")
                .request()
                .accept(MediaType.APPLICATION_JSON).get(Response.class);
//        test status code
        assertEquals(response.getStatus(),200);
//        test return media type
        assertTrue(response.getMediaType().toString()
                .equals("application/json"));
    }
    @Test
    void getEmployeesByProjectNameTest(){
        Response responseCreated = Response.ok(employeeEntities).build();
        when(employeeResource.getEmployeesByProjectName("NBE"))
                .thenReturn(responseCreated);
        Response response = target.path("api").path("Employee")
                .path("Projects")
                .path("NBE").request().accept(MediaType.APPLICATION_JSON)
                .get(Response.class);
        assertEquals(response.getStatus(),200);
        assertTrue(response.getMediaType()
                .toString().equals("application/json"));

    }
    @Test
    void getEmployeesPaginated(){
        Paginator pg = new Paginator();
        pg.setPageIndex(0);
        pg.setPageSize(1);

        Response responseCreated = Response.ok(employeeEntities).build();
        when(employeeResource.getEmployeesPaginated(pg))
                .thenReturn(responseCreated);
        Response response = target.path("api").path("Employee").path("pages")
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.json(pg),Response.class);
        assertEquals(response.getStatus(),200);
        assertTrue(response.getMediaType()
                .toString().equals("application/json"));
        }






}