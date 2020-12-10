package com.dust.myhibernate.controllers;


import com.dust.myhibernate.entities.Level;
import com.dust.myhibernate.repositories.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/level")
public class LevelController {

    @Autowired
    private LevelRepository repo;

    @PostMapping("/create")
    public Level createOneAddress(@RequestBody Level level){
        return repo.save(level);
    }

    @GetMapping("/get-all")
    public List<Level> getAllRecords(){
        return repo.findAll();
    }

    @GetMapping("/get-one")
    public Level getPersonById(@RequestParam long id){
        return repo.findById(id).get();
    }

    @PutMapping("/update")
    public Level updatePersonById(@RequestParam long id, @RequestBody Level input){
        Level level = repo.findById(id).get();

        level.setLevel(input.getLevel());

        return level;
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
