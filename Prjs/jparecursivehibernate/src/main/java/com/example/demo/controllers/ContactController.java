package com.example.demo.controllers;

import com.example.demo.service.dto.AccountDTO;
import com.example.demo.service.dto.ContactDTO;
import com.example.demo.service.impl.AccountServiceImpl;
import com.example.demo.service.impl.ContactServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final ContactServiceImpl contactService;

    @PostMapping("/create")
    public ContactDTO save(@RequestBody ContactDTO contactDTO){
        return contactService.save(contactDTO);
    }

    @GetMapping("/get-all")
    public Set<ContactDTO> findAll(){
        return contactService.findAll();
    }
}
