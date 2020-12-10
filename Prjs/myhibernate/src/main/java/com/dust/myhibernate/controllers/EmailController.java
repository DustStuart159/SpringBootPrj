package com.dust.myhibernate.controllers;


import com.dust.myhibernate.entities.Email;
import com.dust.myhibernate.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailRepository repo;

    @PostMapping("/create")
    public Email createOneAddress(@RequestBody Email email){
        return repo.save(email);
    }

    @GetMapping("/get-all")
    public List<Email> getAllRecords(){
        return repo.findAll();
    }

    @GetMapping("/get-one")
    public Email getPersonById(@RequestParam long id){
        return repo.findById(id).get();
    }

    @PutMapping("/update")
    public Email updatePersonById(@RequestParam long id, @RequestBody Email input){
        Email email = repo.findById(id).get();

        email.setEmail(input.getEmail());

        return email;
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
