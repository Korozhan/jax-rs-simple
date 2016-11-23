package main.java.com.jax.rs.service;

import main.java.com.jax.rs.model.Employee;
import main.java.com.jax.rs.model.GenericResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by intel on 22.09.2016.
 */
@Path("/employee")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeServiceImpl implements EmployeeService {

    Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();

    @Override
    @POST
    @Path("/add")
    public Response addEmployee(Employee employee) {
        GenericResponse response = new GenericResponse();

        employeeMap.put(employee.getId(), employee);
        response.setStatus(true);
        response.setMessage("Employee created!");
        return Response.ok(response).build();
    }

    @Override
    @DELETE
    @Path("/{id}/delete")
    public Response deleteEmployee(@PathParam("id") int id) {
        GenericResponse response = new GenericResponse();
        if (employeeMap.get(id) == null) {
            response.setStatus(false);
            response.setMessage("Employee doesn't exist");
            response.setErrorCode("EC-02");
            return Response.status(404).entity(response).build();
        }
        employeeMap.remove(id);
        response.setStatus(true);
        response.setMessage("Employee removed");
        return Response.ok(response).build();
    }

    @Override
    @GET
    @Path("/{id}/get")
    public Employee getEmployee(@PathParam("id") int id) {
        return employeeMap.get(id);
    }

    @Override
    @GET
    @Path("/getAll")
    public Employee[] getAll() {
        List<Employee> employees = new ArrayList<Employee>();
        Set<Integer> employeeSet = employeeMap.keySet();
        Employee[] employeeArray = new Employee[employeeSet.size()];
        int i=0;
        for(int id:employeeSet){
        employeeArray[i]=employees.get(id);
            ++i;
        }
        return employeeArray;
    }

    @GET
    @Path("/{id}/getDummy")
    public Employee getDummyEmployee(@PathParam("id") int id){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("Johnnnn");
        employee.setSalary(1300.4);
        return employee;
    }

}
