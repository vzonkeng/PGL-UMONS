package be.umons_project.pgl_back_end.controller;


import be.umons_project.pgl_back_end.dtos.controllerResponse.PersonDto;
import be.umons_project.pgl_back_end.dtos.controllerResponse.ResponseDto;
import be.umons_project.pgl_back_end.models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("PGL/")
public interface PersonController {



    @GetMapping("get/persons")
    ResponseEntity<ResponseDto> getAllPerson();
    @PostMapping("create/person")
    ResponseEntity<ResponseDto> createPerson(@RequestBody PersonDto person);
    @GetMapping("get/person/{id}")
     ResponseEntity<ResponseDto> getPersonById(@PathVariable int id);
    @PutMapping("update/person/{id}")
     ResponseEntity<ResponseDto> updatePerson(@PathVariable int id, @RequestBody PersonDto personDetail);
    @DeleteMapping("delete/person/{id}")
     ResponseEntity<ResponseDto> deletePerson(@PathVariable int id);


}
