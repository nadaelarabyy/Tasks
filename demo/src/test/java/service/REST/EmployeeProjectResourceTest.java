package service.REST;

import entity.*;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.Repo.EmployeeProjectService;
import service.Repo.EmployeeService;
import service.Repo.ProjectService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class EmployeeProjectResourceTest {
    WebTarget target;
    EmployeeProjectEntity epe;
    @BeforeEach
    void init(){
        URI uri = UriBuilder.fromUri("http://localhost:8080").build();
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        target = client.target(uri);

    }

    @Test
    void assignEmployeeProject() throws Exception {
        EmployeeProjectResource epr = spy(EmployeeProjectResource.class);

        Throwable ex = assertThrows(Exception.class,()->epr.AddEmployeeToProject(null));
        assertEquals(ex.getMessage(),"Exception ocurs!!");


    }

}