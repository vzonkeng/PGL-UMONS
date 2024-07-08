package be.umons_project.pgl_back_end.controller.impl;

import be.umons_project.pgl_back_end.controller.PersonController;
import be.umons_project.pgl_back_end.dtos.controllerResponse.*;
import be.umons_project.pgl_back_end.services.PersoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonControllerImp implements PersonController {

    private final PersoneService personService;
    private final ResponseDetails responsesDetails;

    @Override
    public ResponseEntity<ResponseDto> getAllPerson() {
        try {
            var persons = personService.serviceGetAllPerson();
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(persons)
                    .errors(null)
                    .meta(MetaDto.builder().message("liste des persons")
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            if(e.getMessage().equals("1001")){
                return new ResponseEntity<>(ResponseDto.builder()
                        .data(null)
                        .errors("la liste de person est vide dans  la BD")
                        .meta(MetaDto.builder().message("la liste de person est vide dans  la BD")
                                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).statusDescription("Echec").build())
                        .pagination(PaginationDto.builder().count(0).total(0).build())
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails("pas d'object dans la BD",
                    HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> createPerson(@RequestBody PersonDto personDto) {
        var newPerson = personService.serviceCreatePerson(personDto);
        return new ResponseEntity<>(ResponseDto.builder()
                .data(newPerson)
                .errors(null)
                .meta(MetaDto.builder().message("Creation d'une person")
                        .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                .pagination(PaginationDto.builder().count(0).total(0).build())
                .build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> getPersonById(@PathVariable int id) {

        try {
            //@PathVariable parce que c'est variable qui est dan le chemin fournis
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(personService.serviceFindPerson(id).get())
                    .errors(null)
                    .meta(MetaDto.builder().message("Obtention d'une person")
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);

        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> updatePerson(@PathVariable int id, @RequestBody PersonDto personDetail) {


        try {
            //@PathVariable parce que c'est variable qui est dan le chemin fournis
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(personService.serviceUpdatePerson(id,personDetail))
                    .errors(null)
                    .meta(MetaDto.builder().message("updated person")
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);

        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> deletePerson(@PathVariable int id) {
        try {
            personService.serviceDeletePerson(id);
        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

}

