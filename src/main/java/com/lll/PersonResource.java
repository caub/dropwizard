package com.lll;

import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonDAO peopleDAO;

    public PersonResource(PersonDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @POST
    @UnitOfWork
    public Person createPerson(Person person) {
        return peopleDAO.create(person);
    }
    
    
    @Path("/add/{name}")
    @GET
    @UnitOfWork
    public Person addPerson(@PathParam("name") String name) {
        return peopleDAO.create(new Person(name, ""));
    }
    @Path("/add/{name}/{job}")
    @GET
    @UnitOfWork
    public Person addPerson2(@PathParam("name") String name, @PathParam("job") String job) {
        return peopleDAO.create(new Person(name, job));
    }
    
    @Path("/find/{name}")
    @GET
    @UnitOfWork
    public List<Person> find(@PathParam("name") String name) {
        return peopleDAO.findByName(name);
    }
    
    @Path("/remove/{name}")
    @GET
    @UnitOfWork
    public String remove(@PathParam("name") String name) {
        peopleDAO.remove(name);
        return name;
    }
    

    @GET
    @UnitOfWork
    public List<Person> listPeople() {
        return peopleDAO.findAll();
    }

}
