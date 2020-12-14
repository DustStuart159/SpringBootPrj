package com.example.demo.service.impl;

import com.example.demo.models.Contacts;
import com.example.demo.repository.IContactRepository;
import com.example.demo.service.IContactService;
import com.example.demo.service.dto.ContactDTO;
import com.example.demo.service.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {
    private final IContactRepository contactRepo;
    private final ContactMapper contactMapper;

    @Override
    public ContactDTO save(ContactDTO contactDTO) {
        Contacts contact = contactRepo.save(contactMapper.convertToEntity(contactDTO));

        return contactMapper.convertToDTO(contact);
    }

    @Override
    public Set<ContactDTO> findAll() {
        Set<ContactDTO> set = new HashSet<>();

        for (Contacts contact : contactRepo.findAll()) {
            set.add(contactMapper.convertToDTO(contact));
        }

        return set;
    }
}
