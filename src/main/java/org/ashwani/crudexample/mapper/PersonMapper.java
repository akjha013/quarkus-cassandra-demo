package org.ashwani.crudexample.mapper;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.DaoProfile;
import com.datastax.oss.driver.api.mapper.annotations.DaoTable;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import org.ashwani.crudexample.dao.PersonDao;

@Mapper
public interface PersonMapper {

    @DaoFactory
    PersonDao personDao();

    @DaoFactory
    PersonDao availableCardDao(@DaoKeyspace
            String keyspace);

    /**
     * This method allows to overwrite the keyspace and the table
     */
    @DaoFactory
    PersonDao availableCardDao(@DaoKeyspace String keyspace, @DaoTable
            String table);

    /**
     * This method allows to set the profile
     */
    @DaoFactory
    PersonDao availableCardDaoFromProfile(@DaoProfile
            String profileName);

}
