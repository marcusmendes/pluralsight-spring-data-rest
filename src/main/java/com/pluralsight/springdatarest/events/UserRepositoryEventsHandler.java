package com.pluralsight.springdatarest.events;

import com.pluralsight.springdatarest.model.User;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

@RepositoryEventHandler
@Service
public class UserRepositoryEventsHandler {

    @HandleBeforeCreate
    public void handlerUserBeforeCreate(User user) {
        if ((user.getName().toUpperCase().charAt(0) >= 'A') && (user.getName().toUpperCase().charAt(0) <= 'M')) {
            System.out.println("User " + user.getName() + " is to be created, goes to the first part of the alphabet");
        } else {
            System.out.println("User " + user.getName() + " is to be created, goes to the second part of the alphabet");
        }
    }

    @HandleAfterCreate
    public void handlerUserAfterCreate(User user) {
        System.out.println("I am so tired to have created " + user.getName());
    }

    @HandleBeforeDelete
    public void handlerUserBeforeDelete(User user) {
        System.out.println("This is just to let you know that " + user.getName() + " is about to be deleted");
    }

    @HandleAfterDelete
    public void handlerUserAfterDelete(User user) {
        System.out.println("Sad but true " + user.getName() + " has been deleted");
    }
}
