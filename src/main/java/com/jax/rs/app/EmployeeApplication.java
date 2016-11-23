package main.java.com.jax.rs.app;

import main.java.com.jax.rs.service.EmployeeServiceImpl;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by intel on 22.09.2016.
 */
public class EmployeeApplication extends Application {

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    private Set<Object> singletons = new HashSet<Object>();

    public EmployeeApplication() {
        singletons.add(new EmployeeServiceImpl());
    }

}
