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
public class BillingInformation {
    private String id;
    private String receiversName;
    private String receiversPhoneNumber;
    private String deliveryAddress;
    private CreditCardInformation creditCardInformation;
}
