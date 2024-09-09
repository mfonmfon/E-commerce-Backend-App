package com.semicolon.africa.hikestream.data.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardInformation {
    private String id;
    private String cardCvv;
    private String cardExpirationDate;
    private String cardNumber;
    private String creditCardName;
    private CardType cardType;
}
