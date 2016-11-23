package main.java.test.java.com.jax.rs.app;

import main.java.com.jax.rs.model.Employee;
import main.java.com.jax.rs.model.GenericResponse;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by intel on 22.09.2016.
 */
public class TestEmployeeService {

    public static void main(String[] args) {

        ResteasyClient client = new ResteasyClientBuilder().build();

        //get dummy
        ResteasyWebTarget getDummy = client.target("http://localhost:8080/Rest-example/employee/33/getDummy");
        Response getDummyResponse = getDummy.request().get();
        String value = getDummyResponse.readEntity(String.class);
        System.out.println(value);
        getDummyResponse.close();

        //add
        ResteasyWebTarget addEmployee = client.target("http://localhost:8080/Rest-example/employee/add");
        Employee employee = new Employee();
        employee.setId(65);
        employee.setName("Frank");
        employee.setSalary(324.34);
        Response addResponse = addEmployee.request().post(Entity.entity(employee, MediaType.APPLICATION_XML));
        GenericResponse addValue = addResponse.readEntity(GenericResponse.class);
        System.out.println(addValue);
        System.out.println("Http status code: " + addResponse.getStatus());
        addResponse.close();

        //delete
        ResteasyWebTarget deleteEmployee = client.target("http://localhost:8080/Rest-example/employee/65/delete");
        Response deleteResponse = deleteEmployee.request().delete();
        GenericResponse deleteValue = deleteResponse.readEntity(GenericResponse.class);
        System.out.println(deleteValue);
        System.out.println("Http status code: "+ deleteResponse.getStatus());
        deleteResponse.close();


    }
}
