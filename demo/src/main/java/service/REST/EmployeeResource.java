package service.REST;

import DTO.Paginator;
import entity.EmployeeEntity;
import entity.EmployeeProjectEntity;
import service.Repo.EmployeeProjectService;
import service.Repo.EmployeeService;

import javax.json.JsonObject;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Employee")
public class EmployeeResource {

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllEmployees(){
        EmployeeService es = new EmployeeService();

        return Response.ok(es.getAllEmployees()).build();
    }
    @GET
    @Path("/NonWorking")
    @Produces("application/json")
    public Response getNonWorkingEmployeesByRole(@QueryParam("role") String role){
        EmployeeService es = new EmployeeService();
        return Response.ok(es.getNonWorkingEmployeesByRole(role)).build();
    }
    @GET
    @Path("/Projects/{project}")
    @Produces("application/json")
    public Response getEmployeesByProjectName(@PathParam("project") String project){
        EmployeeService es = new EmployeeService();
        return Response.ok(es.getEmployeesByProjectName(project)).build();
    }


//    DTO post paginated request
    @POST
    @Path("/pages")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesPaginated(Paginator pg) {
        EmployeeService es = new EmployeeService();
        return Response
                .ok(es.getAllEmployeesPaginated(pg.getPageIndex(),pg.getPageSize()))
                .build();
    }


}
