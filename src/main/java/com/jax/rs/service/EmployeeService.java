package main.java.com.jax.rs.service;

import main.java.com.jax.rs.model.Employee;

import javax.ws.rs.core.Response;

/**
 * Created by intel on 22.09.2016.
 */
public interface EmployeeService {

    public Response addEmployee(Employee employee);
    public Response deleteEmployee(int id);
    public Employee getEmployee(int id);
    public Employee[] getAll();

}
