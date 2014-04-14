package com.lll;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PersonDAO extends AbstractDAO<Person> {
    public PersonDAO(SessionFactory factory) {
        super(factory);
    }

    public List<Person> findByName(String name) {
    	return list(namedQuery("com.example.helloworld.core.Person.findByName").setString("name", "%"+name+"%"));
    }

    public Person create(Person person) {
        return persist(person);
    }

    public List<Person> findAll() {
        return list(namedQuery("com.example.helloworld.core.Person.findAll"));
    }

    public void remove(String name){
        namedQuery("com.example.helloworld.core.Person.removedByName").setString("name", name);
    }
    
}
