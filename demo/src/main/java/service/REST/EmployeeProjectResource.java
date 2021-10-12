package service.REST;

import entity.EmployeeProjectEntity;
import service.Repo.EmployeeProjectService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/EmployeeProject")
public class EmployeeProjectResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String AddEmployeeToProject(EmployeeProjectEntity ep) {
        EmployeeProjectService eps = new EmployeeProjectService();
        return eps.addEmployeeProject(ep);
    }
}
