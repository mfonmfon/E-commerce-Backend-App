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
@Document
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String productName;
    private String price;
    private String productDescription;
    private ProductCategory productCategory;
}
