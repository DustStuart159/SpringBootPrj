package com.dust.myhibernate.controllers;


import com.dust.myhibernate.entities.Address;
import com.dust.myhibernate.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository repo;

    @PostMapping("/create")
    public Address createOneAddress(@RequestBody Address address){
        return repo.save(address);
    }

    @GetMapping("/get-all")
    public List<Address> getAllRecords(){
        return repo.findAll();
    }

    @GetMapping("/get-one")
    public Address getPersonById(@RequestParam long id){
        return repo.findById(id).get();
    }

    @PutMapping("/update")
    public Address updatePersonById(@RequestParam long id, @RequestBody Address input){
        Address address = repo.findById(id).get();

        address.setAddress(input.getAddress());

        return address;
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
