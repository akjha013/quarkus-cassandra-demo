package org.ashwani.crudexample.entities;

import java.util.Date;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.datastax.oss.driver.api.mapper.annotations.PropertyStrategy;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@PropertyStrategy(mutable = false)
@CqlName(PersonEntity.DEFAULT_TABLE_NAME)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PersonEntity {

    @PartitionKey
    private long personId;
    private String personName;
    private Date personBirthday;
    private String personAddress;

    public PersonEntity() {

    }

    public static final String DEFAULT_TABLE_NAME = "person";

    public PersonEntity(long personId, String personName, Date personBirthday, String personAddress) {
        this.personId = personId;
        this.personName = personName;
        this.personBirthday = personBirthday;
        this.personAddress = personAddress;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Date getPersonBirthday() {
        return personBirthday;
    }

    public void setPersonBirthday(Date personBirthday) {
        this.personBirthday = personBirthday;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personBirthday=" + personBirthday +
                ", personAddress='" + personAddress + '\'' +
                '}';
    }



    public static Builder of(PersonEntity personEntity){
        return new Builder()
                .withPersonId(personEntity.personId)
                .withPersonName(personEntity.personName)
                .withPersonBirthday(personEntity.personBirthday)
                .withPersonAddress(personEntity.personAddress);
    }

    public static class Builder {

        private final PersonEntity personEntity = new PersonEntity();

        public PersonEntity build() {
            return personEntity;
        }

        public PersonEntity.Builder withPersonId(Long personId) {
            personEntity.personId = personId;
            return this;
        }

        public PersonEntity.Builder withPersonName(String personName) {
            personEntity.personName = personName;
            return this;
        }

        public PersonEntity.Builder withPersonBirthday(Date personBirthday) {
            personEntity.personBirthday = personBirthday;
            return this;
        }

        public PersonEntity.Builder withPersonAddress(String personAddress) {
            personEntity.personAddress = personAddress;
            return this;
        }


    }

}
