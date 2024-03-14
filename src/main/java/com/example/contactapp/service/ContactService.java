package com.example.contactapp.service;

import com.example.contactapp.entity.Contact;

import java.util.List;

public interface ContactService {
    public boolean saveContact(Contact contact);
    public List<Contact> getAllContact();
    public Contact getContactById(Integer contactId);
    public boolean deleteContactById(Integer contactId);
}
