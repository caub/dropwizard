package com.lll;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Person")
@NamedQueries({
    @NamedQuery(
        name = "com.example.helloworld.core.Person.findAll",
        query = "SELECT p FROM Person p"
    ),
    @NamedQuery(
        name = "com.example.helloworld.core.Person.findByName",
        query = "SELECT p FROM Person p WHERE p.name like :name"
    ),
    @NamedQuery(
            name = "com.example.helloworld.core.Person.removeByName",
            query = "delete from Person p where p.name = :name"
    )
    
})
@XmlRootElement
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "jobTitle", nullable = false)
    private String jobTitle;
    
    

    public Person() {
	}

	public Person(String name, String jobTitle) {
		this.name = name;
		this.jobTitle = jobTitle;
	}

    @JsonProperty
	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @JsonProperty
	public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }



    public boolean equals(Object obj){
        if (obj instanceof Person){
            Person p = (Person)obj;
            if (!p.getName().equals(name)) return false;
            return true;
        }else
            return false;

    }

}
