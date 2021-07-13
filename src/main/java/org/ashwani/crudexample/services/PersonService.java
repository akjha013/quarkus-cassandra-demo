package org.ashwani.crudexample.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.ashwani.crudexample.dao.PersonDao;
import org.ashwani.crudexample.entities.PersonEntity;

@ApplicationScoped

public class PersonService {

    @Inject PersonDao dao;

    public PersonEntity save(PersonEntity personEntity) {
        PersonEntity.Builder personBuilder = PersonEntity.of(personEntity);
        PersonEntity result = personBuilder.build();
        return dao.update(result);
    }

    public List<PersonEntity> getAll() {
        return dao.findAll().all();
    }

}
