package com.pluralsight.springdatarest.events;

import com.pluralsight.springdatarest.model.User;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Service;

@Service
public class RepositoryEventListener extends AbstractRepositoryEventListener<User> {

    @Override
    protected void onBeforeCreate(User user) {
        System.out.println("I'll make an effort to create " + user.getName());
    }

    @Override
    protected void onAfterCreate(User user) {
        System.out.println("I did my best an I was alte to create " + user.getName());
    }

    @Override
    protected void onBeforeSave(User user) {
        System.out.println("I'll take a breath and I will save " + user.getName());
    }

    @Override
    protected void onAfterSave(User user) {
        System.out.println("Hard, hard to save " + user.getName());
    }

    @Override
    protected void onBeforeDelete(User user) {
        System.out.println("I'll delete " + user.getName() + ", you might never seen him/her again");
    }

    @Override
    protected void onAfterDelete(User user) {
        System.out.println("Say good-bye to " + user.getName() + ", I deleted him/her");
    }
}
