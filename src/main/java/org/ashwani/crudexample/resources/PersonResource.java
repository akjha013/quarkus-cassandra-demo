package org.ashwani.crudexample.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.ashwani.crudexample.entities.PersonEntity;
import org.ashwani.crudexample.models.Person;
import org.ashwani.crudexample.services.PersonService;


@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject PersonService personService;

    @GET
    public List<PersonEntity> getAll() {
        return personService.getAll().stream().map(convertFromDto()Collectors.toList());
    }

    @POST
    public Response add(PersonEntity personEntity) {

        PersonEntity pe = PersonEntity.of(personEntity).build();



        return Response.ok(personService.save(pe)).build();
    }

    PersonEntity convertFromDto(Person person) {
        PersonEntity.Builder builder = new PersonEntity.Builder();
        return builder
                .withPersonId(person.getPersonId())
                .withPersonName(person.getPersonName())
                .withPersonBirthday(person.getPersonBirthday())
                .withPersonAddress(person.getPersonAddress()).build();
    }
    Person convertFromEntity(PersonEntity personEntity){
        Person.Builder builder = new Person.Builder();
        return builder
                .withPersonId(personEntity.getPersonId())
                .withPersonName(personEntity.getPersonName())
                .withPersonBirthday(personEntity.getPersonBirthday())
                .withPersonAddress(personEntity.getPersonAddress()).build();
    }

//    private PersonDto convertToDto(PersonEntity person) {
//        return new PersonDto(person.getPersonId(),person.getPersonName(),person.getPersonBirthday(),person.getPersonAddress());
//    }
//
//    private PersonEntity convertFromDto(PersonDto personDto) {
//        return new PersonEntity(personDto.getPersonId(),personDto.getPersonName(),personDto.getPersonBirthday(),personDto.getPersonAddress());
//    }
}
