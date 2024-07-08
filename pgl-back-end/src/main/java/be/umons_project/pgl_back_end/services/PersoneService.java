package be.umons_project.pgl_back_end.services;

import be.umons_project.pgl_back_end.dtos.controllerResponse.PersonDto;
import be.umons_project.pgl_back_end.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersoneService {

    Person serviceCreatePerson(PersonDto personDto);

    Optional<Person> serviceFindPerson(int id);

    Person editePerson(String id);

    List<Person> serviceGetAllPerson();

    Person serviceUpdatePerson(int id, PersonDto person);

    void serviceDeletePerson(int id);
}
