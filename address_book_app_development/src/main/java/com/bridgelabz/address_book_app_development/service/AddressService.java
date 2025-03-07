package com.bridgelabz.address_book_app_development.service;

import com.bridgelabz.address_book_app_development.dto.AddressDTO;
import com.bridgelabz.address_book_app_development.model.AddressModel;
import com.bridgelabz.address_book_app_development.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    // Add a new contact
    public AddressModel addContact(AddressDTO contactDTO) {
        AddressModel contact = new AddressModel();
        contact.setFullName(contactDTO.getFullName());
        contact.setAddress(contactDTO.getAddress());
        contact.setCity(contactDTO.getCity());
        contact.setState(contactDTO.getState());
        contact.setZip(contactDTO.getZip());
        contact.setPhoneNumber(contactDTO.getPhoneNumber());

        return addressRepository.save(contact); // Store in MySQL
    }

    // Get all contacts
    public List<AddressModel> getAllContacts() {
        return addressRepository.findAll();
    }

    // Get contact by ID
    public Optional<AddressModel> getContactById(Long id) {
        return addressRepository.findById(id);
    }

    // Update contact by ID
    public AddressModel updateContact(Long id, AddressDTO contactDTO) {
        Optional<AddressModel> existingContact = addressRepository.findById(id);
        if (existingContact.isPresent()) {
            AddressModel contact = existingContact.get();
            contact.setFullName(contactDTO.getFullName());
            contact.setAddress(contactDTO.getAddress());
            contact.setCity(contactDTO.getCity());
            contact.setState(contactDTO.getState());
            contact.setZip(contactDTO.getZip());
            contact.setPhoneNumber(contactDTO.getPhoneNumber());

            return addressRepository.save(contact); // Update in MySQL
        } else {
            throw new RuntimeException("Contact not found with ID: " + id);
        }
    }

    // Delete contact by ID
    public boolean deleteContact(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true; // Successfully deleted
        }
        return false; // Contact not found
    }
}
