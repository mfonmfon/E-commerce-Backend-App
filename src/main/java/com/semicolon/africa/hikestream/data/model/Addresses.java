package com.semicolon.africa.hikestream.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Addresses {
    private String id;
    private String cityName;
    private String countryName;
    private String houseNumber;
    private String streetName;
    private String stateName;
}
