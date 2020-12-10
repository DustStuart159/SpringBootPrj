package com.dust.myhibernate.controllers;


import com.dust.myhibernate.entities.Person;
import com.dust.myhibernate.entities.Phone;
import com.dust.myhibernate.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private PhoneRepository repo;

    @PostMapping("/create")
    public Phone createOnePerson(@RequestBody Phone phone){
        return repo.save(phone);
    }

    @GetMapping("/get-all")
    public List<Phone> getAllRecords(){
        return repo.findAll();
    }

    @GetMapping("/get-one")
    public Phone getPersonById(@RequestParam long id){
        return repo.findById(id).get();
    }

    @PutMapping("/update")
    public Phone updatePersonById(@RequestParam long id, @RequestBody Phone input){
        Phone phone = repo.findById(id).get();

        phone.setPhone(input.getPhone());

        return phone;
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
