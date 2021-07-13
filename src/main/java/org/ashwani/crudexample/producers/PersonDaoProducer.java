package org.ashwani.crudexample.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.datastax.oss.quarkus.runtime.api.session.QuarkusCqlSession;
import org.ashwani.crudexample.dao.PersonDao;
import org.ashwani.crudexample.entities.PersonEntity;
import org.ashwani.crudexample.mapper.PersonMapper;
import org.eclipse.microprofile.config.inject.ConfigProperty;

public class PersonDaoProducer {

        private final PersonDao personDao;

        @ConfigProperty(name = "quarkus.cassandra.keyspace")
        String keySpace;

        @Inject
        public PersonDaoProducer(QuarkusCqlSession session) {
            // create a mapper
            PersonMapper personMapper = new PersonMapperBuilder(session).build();
            // instantiate Dao
            personDao = mapper.personDao(keySpace, PersonEntity.DEFAULT_TABLE_NAME);
        }

        @Produces
        @ApplicationScoped
        PersonDao producePersonDao() {
            return personDao;
        }



}
