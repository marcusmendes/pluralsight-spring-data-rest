package com.pluralsight.springdatarest.beans;

import com.pluralsight.springdatarest.model.Auction;
import com.pluralsight.springdatarest.model.User;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvDataLoader {

    @Bean
    public Auction buildAuction() throws IOException {
        Auction auction = new Auction("1234", 20);
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/users_information.csv"))) {
            String line = null;
            do {
                line = reader.readLine();
                if (line != null) {
                    User user = new User(line);
                    user.setRegistered(false);
                    auction.addUser(user);
                }

            } while (line != null);
        }
        return auction;
    }
}
