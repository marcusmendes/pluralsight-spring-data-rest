package com.pluralsight.springdatarest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private String zipCode;

    @Getter
    @Setter
    private String state;

    protected Address() {}

    public Address(String street, String city, String zipCode, String state) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
    }
}
