package com.pluralsight.springdatarest.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ToString
public class Auction {

    @Getter
    private String auctionNumber;
    private int seats;
    private Set<User> users = new HashSet<>();

    public Auction(String actionNumber, int seats) {
        this.auctionNumber = actionNumber;
        this.seats = seats;
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public boolean addUser(User user) {
        if (users.size() >= seats) {
            throw new RuntimeException("Cannot add more users than the capacity of the auction");
        }
        return users.add(user);
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }
}
