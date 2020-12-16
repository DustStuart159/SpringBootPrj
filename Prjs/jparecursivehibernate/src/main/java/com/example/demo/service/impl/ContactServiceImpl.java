package com.example.demo.service.impl;

import com.example.demo.models.Contacts;
import com.example.demo.repository.IContactRepository;
import com.example.demo.service.IContactService;
import com.example.demo.service.dto.ContactDTO;
import com.example.demo.service.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
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

    @Override
    public ContactDTO findById(Long id) {
        Optional<Contacts> opt = contactRepo.findById(id);
        if (!opt.isPresent()){
            log.error("ID " + id + "is not exist");
            ResponseEntity.badRequest().build();
        }

        return contactMapper.convertToDTO(opt.get());
    }
}
