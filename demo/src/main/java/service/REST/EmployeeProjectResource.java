package service.REST;

import entity.EmployeeProjectEntity;
import service.Repo.EmployeeProjectService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/EmployeeProject")
public class EmployeeProjectResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response AddEmployeeToProject(EmployeeProjectEntity ep) throws Exception {
        EmployeeProjectService eps = new EmployeeProjectService();
        String result = null;
        try {
            result = eps.addEmployeeProject(ep);
        }
        catch (Exception e){
            throw new Exception("Exception ocurs!!");
        }
        return Response.ok(result).build();


    }
}
