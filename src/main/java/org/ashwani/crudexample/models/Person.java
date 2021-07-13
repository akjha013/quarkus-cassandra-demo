package org.ashwani.crudexample.models;

import java.util.Date;

import org.ashwani.crudexample.models.Person;
import org.ashwani.crudexample.models.Person.Builder;

public class Person {

    private long personId;
    private String personName;
    private Date personBirthday;
    private String personAddress;

    public long getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }

    public Date getPersonBirthday() {
        return personBirthday;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public static Builder of(Person person){
        return new Builder()
                .withPersonId(person.personId)
                .withPersonName(person.personName)
                .withPersonBirthday(person.personBirthday)
                .withPersonAddress(person.personAddress);
    }

    public static class Builder {

        private final Person person = new Person();

        public Person build() {
            return person;
        }

        public Person.Builder withPersonId(Long personId) {
            person.personId = personId;
            return this;
        }

        public Person.Builder withPersonName(String personName) {
            person.personName = personName;
            return this;
        }

        public Person.Builder withPersonBirthday(Date personBirthday) {
            person.personBirthday = personBirthday;
            return this;
        }

        public Person.Builder withPersonAddress(String personAddress) {
            person.personAddress = personAddress;
            return this;
        }


    }

}
