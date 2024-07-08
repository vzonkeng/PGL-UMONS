package be.umons_project.pgl_back_end.mappers;

import be.umons_project.pgl_back_end.dtos.controllerResponse.PersonDto;
import be.umons_project.pgl_back_end.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper {

    public Person convertPersonDtoToPerson(PersonDto personDto){
        return Person.builder()
                .address(personDto.getAddress())
                .Role(personDto.getRole())
                .FirstName(personDto.getFirstName())
                .LastName(personDto.getLastName())
                .inscriptionDate(personDto.getInscriptionDate())
                .password(personDto.getPassword())
                .address(personDto.getAddress())
                .build();
    }
}
