package org.ashwani.crudexample.dao;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import org.ashwani.crudexample.entities.PersonEntity;

@Dao
public interface PersonDao {

    @Update
    PersonEntity update(PersonEntity personEntity);

    @Select
    PagingIterable<PersonEntity> findAll();
}
