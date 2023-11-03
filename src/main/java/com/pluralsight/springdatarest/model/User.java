package com.pluralsight.springdatarest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @JsonIgnore // Disable this field from being exposed in the API
    private boolean isRegistered;

    @Getter
    @Setter
    private boolean isCitizen;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter
    @Setter
    private Address address;

    protected User() {}

    public User(String name) {
        this.name = name;
    }
}
