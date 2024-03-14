package com.example.contactapp.service;

import com.example.contactapp.entity.Contact;
import com.example.contactapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    public ContactRepository contactRepository;

    @Override
    public boolean saveContact(Contact contact) {
        contact.setActiveSw("Y");
        Contact save = contactRepository.save(contact);
        if (save.getContactId() != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Contact> getAllContact() {
        Contact contact = new Contact();
        contact.setActiveSw("Y");
        return contactRepository.findAll(Example.of(contact));
    }

    @Override
    public Contact getContactById(Integer contactId) {
        Optional<Contact> findById = contactRepository.findById(contactId);
        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    @Override
    public boolean deleteContactById(Integer contactId) {
        Optional<Contact> findById = contactRepository.findById(contactId);
        if (findById.isPresent()) {
            Contact contact = findById.get();
            contact.setActiveSw("N");
            contactRepository.save(contact);
            return true;
        }
        return false;
    }
}
