package be.umons_project.pgl_back_end.services;


import be.umons_project.pgl_back_end.dtos.controllerResponse.PersonDto;
import be.umons_project.pgl_back_end.mappers.PersonMapper;
import be.umons_project.pgl_back_end.models.Person;
import be.umons_project.pgl_back_end.repositries.PersonRepositories;
import be.umons_project.pgl_back_end.services.impl.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

@DataJpaTest
public class PersonServiceTest {

    @Mock
    private PersonRepositories personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonServiceImpl personService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testServiceCreatePerson() {
        // Given
        PersonDto personDto = new PersonDto();
        personDto.setRole("Etudiant");
        personDto.setFirstName("Vanel");
        personDto.setLastName("Guepi");


        Person person = new Person();
        person.setRole("Etudiant");
        person.setFirstName("Vanel");
        person.setLastName("Guepi");


        // When
        when(personMapper.convertPersonDtoToPerson(any(PersonDto.class))).thenReturn(person);
        doNothing().when(personRepository).save(any(Person.class));

        personService.serviceCreatePerson(personDto);

        // Then
        verify(personMapper, times(1)).convertPersonDtoToPerson(any(PersonDto.class));
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    public void testServiceCreatePersonWithNullDto() {
        // Given
        PersonDto personDto = null;

        // When
        personService.serviceCreatePerson(personDto);

        // Then
        verify(personMapper, never()).convertPersonDtoToPerson(any(PersonDto.class));
        verify(personRepository, never()).save(any(Person.class));
    }
}
