package com.semicolon.africa.hikestream.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Sellers {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String homeAddress;
    private String phoneNumber;
}
