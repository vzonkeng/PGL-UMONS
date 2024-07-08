package be.umons_project.pgl_back_end.services.impl;

import be.umons_project.pgl_back_end.dtos.controllerResponse.PersonDto;
import be.umons_project.pgl_back_end.dtos.controllerResponse.ResponseDetails;
import be.umons_project.pgl_back_end.exeption.CustomException;
import be.umons_project.pgl_back_end.mappers.PersonMapper;
import be.umons_project.pgl_back_end.models.Person;
import be.umons_project.pgl_back_end.repositries.PersonRepositories;
import be.umons_project.pgl_back_end.services.PersoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersoneService {

    private PersonRepositories personRepositories;
    private PersonMapper personMapper;
    private  ResponseDetails responsesDetails;

    @Override
    public Person serviceCreatePerson(PersonDto personDto) {
        try {
            var personToSave = personMapper.convertPersonDtoToPerson(personDto);
            if (personDto != null) {
                Person personCreated = personRepositories.save(personToSave);
                return  personCreated;
            } else {
                throw new CustomException("PersonDto is null");
            }
        } catch (Exception e) {
            throw new CustomException("Failed to save person: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Person> serviceFindPerson(int id) {
        Optional<Person> person = personRepositories.findById(id);

        if (person.isPresent()) {
            return person;
        } else {
            throw new CustomException("Person with id: "+id+" is not present");
        }
    }

    @Override
    public Person editePerson(String id) {
        return null;
    }

    @Override
    public List<Person> serviceGetAllPerson() {
            var persons = personRepositories.findAll();
            if(persons==null){
                throw  new CustomException("1001");
            }
            return persons;
    }

    @Override
    public Person serviceUpdatePerson(int id,PersonDto personDetail) {
        Optional<Person> person = personRepositories.findById(id);
        if (person.isPresent()) {
            Person existingPerson = person.get();
            existingPerson.setAddress(personDetail.getAddress());
            existingPerson.setInscriptionDate(personDetail.getInscriptionDate());

             Person personUpdated = personRepositories.save(existingPerson);
            return personUpdated;
        } else {
            throw new CustomException("PersonDto is null");
        }

    }

    @Override
    public void serviceDeletePerson(int id) {

        Optional<Person> person = personRepositories.findById(id);
        if (person.isPresent()) {
            personRepositories.delete(person.get());
        } else {
            System.out.println("erreur de suppression");
        }

    }


}
