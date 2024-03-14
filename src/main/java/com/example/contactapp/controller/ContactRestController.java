package com.example.contactapp.controller;

import com.example.contactapp.constants.AppConstants;
import com.example.contactapp.entity.Contact;
import com.example.contactapp.props.AppProperties;
import com.example.contactapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ContactRestController {
    @Autowired
    private ContactService service;
    @Autowired
    private AppProperties appProps;

    @PostMapping("/contact")
    public String saveContact(@RequestBody Contact contact) {
        boolean status = service.saveContact(contact);

        Map<String,String> messages = appProps.getMessages();
        if (status) {
            return messages.get(AppConstants.CONTACT_SAVE_SUCC );
        } else {
            return messages.get(AppConstants.CONTACT_SAVE_FAIL);
        }
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContact() {
        return service.getAllContact();
    }

    @GetMapping("/contact/{cid}")
    public Contact editContact(@PathVariable("cid") Integer contactId) {
        return service.getContactById(contactId);
    }

    @DeleteMapping("/contact/{cid}")
    public String deleteContact(@PathVariable("cid") Integer contactId) {
        boolean status = service.deleteContactById(contactId);

        Map<String,String> messages = appProps.getMessages();
        if (status) {
            return messages.get(AppConstants.CONTACT_DEL_SUCC);
        } else {
            return messages.get(AppConstants.CONTACT_DEL_FAIL);
        }
    }
}
