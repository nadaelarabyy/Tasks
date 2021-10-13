import entity.*;
import org.glassfish.jersey.client.ClientConfig;
import service.Repo.EmployeeService;
import service.Repo.ProjectService;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class Main {
    public static void main(String[] args) {

        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(getBaseURI());
//        getting all employees
        System.out.println(target.path("api")
        .path("Employee").request().accept(MediaType.APPLICATION_JSON)
        .get(String.class));
//      get non working employees for example developers
        System.out.println(target.path("api")
                .path("Employee")
                .path("NonWorking")
                .queryParam("role","DEVELOPER")
                .request()
                .accept(MediaType.APPLICATION_JSON).get(String.class));
//        get Employees by project name for example NBE
        System.out.println(
                target.path("api").path("Employee").path("Projects")
                        .path("NBE").request().accept(MediaType.APPLICATION_JSON)
                        .get(String.class)
        );
//        add employee to a specific project
        EmployeeService es = new EmployeeService();
        ProjectService ps = new ProjectService();
        EmployeeEntity ee = es.getEmployeeByid(3);
        ProjectEntity pe = ps.getProjectByid(4);
        EmployeeProjectEntity epe = new EmployeeProjectEntity();
        epe.setEmployeeId(ee);
        epe.setProjectId(pe);
        System.out.println(
                target.path("api").path("EmployeeProject")
                        .request(MediaType.APPLICATION_JSON)
                        .accept(MediaType.TEXT_PLAIN)
                        .post(Entity.json(epe),String.class)
        );

    }
    private static URI getBaseURI() {
        //here server is running on 4444 port number and project name is restfuljersey
        return UriBuilder.fromUri("http://localhost:8080").build();
    }

}
