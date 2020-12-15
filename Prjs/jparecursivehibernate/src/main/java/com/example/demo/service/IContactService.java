package com.example.demo.service;

import com.example.demo.service.dto.ContactDTO;

import java.util.Set;

public interface IContactService {
    ContactDTO save(ContactDTO contactDTO);
    Set<ContactDTO> findAll();
}
