package com.lll;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lll.Person;
import com.lll.PersonDAO;
import com.lll.PersonResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PersonResourceTest {
	
	private static final PersonDAO dao = mock(PersonDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PersonResource(dao))
            .build();

    private final Person person = new Person("john", "IT");

    @Before
    public void setup() {
    	when(dao.findByName(eq(person.getName()))).thenReturn(Arrays.asList(person));
    }

    @Test
    public void testGetPerson() {

        List<Person> l = resources.client().resource("/api/find/"+person.getName()).get(List.class);


        ObjectMapper mapper = new ObjectMapper();
        Person[] p = mapper.convertValue(l, Person[].class);
        System.out.println(">>>>>>>>>>>"+l.size()+" "+p+" "+person);
        assertThat(p).contains(person);

        verify(dao).findByName(person.getName());
    }
}
