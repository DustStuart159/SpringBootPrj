package com.dust.myhibernate.controllers;


import com.dust.myhibernate.entities.Person;
import com.dust.myhibernate.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repo;

    @PostMapping("/create")
    public Person createOnePerson(@RequestBody Person person){
        return repo.save(person);
    }

    @GetMapping("/get-all")
    public List<Person> getAllRecords(){
        return repo.findAll();
    }

    @GetMapping("/get-one")
    public Person getPersonById(@RequestParam long id){
        return repo.findById(id).get();
    }

    @PutMapping("/update")
    public Person updatePersonById(@RequestParam long id, @RequestBody Person input){
        Person person = repo.findById(id).get();

        person.setName(input.getName());

        return person;
    }

    @DeleteMapping("/delete-all")
    public void deleteAllPerson(){
        repo.deleteAll();
    }

    @DeleteMapping("/delete-one")
    public void deletePersonById(@RequestParam long id){
        repo.deleteById(id);
    }
}
