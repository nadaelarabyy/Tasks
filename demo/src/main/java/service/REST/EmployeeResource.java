package service.REST;

import entity.EmployeeEntity;
import service.Repo.EmployeeService;

import javax.persistence.*;
import javax.ws.rs.*;
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


}
