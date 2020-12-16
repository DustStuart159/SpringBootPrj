package com.example.demo.service.mapper;

import com.example.demo.models.Contacts;
import com.example.demo.service.dto.ContactDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactMapper extends BaseMapper {
    public ContactDTO convertToDTO(Contacts input) {
        ContactDTO output = this.tranferData(input, ContactDTO.class);

        return output;
    }

    public Contacts convertToEntity(ContactDTO input) {
        Contacts output = this.tranferData(input, Contacts.class);

        return output;
    }
}
