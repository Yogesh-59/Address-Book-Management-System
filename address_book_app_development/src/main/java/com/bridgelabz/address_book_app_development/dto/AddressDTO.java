package com.bridgelabz.address_book_app_development.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressDTO {

    @NotEmpty(message = "Full Name cannot be empty")
    private String fullName;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotEmpty(message = "City cannot be empty")
    private String city;

    @NotEmpty(message = "State cannot be empty")
    private String state;

    @NotEmpty(message = "ZIP code cannot be empty")
    @Pattern(regexp = "^[0-9]{5,6}$", message = "ZIP code must be 5 or 6 digits")
    private String zip;

    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

//    @NotEmpty(message = "Email cannot be empty")
//    @Email(message = "Invalid email format")
//    private String email;
}
