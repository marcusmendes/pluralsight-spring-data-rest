package com.pluralsight.springdatarest.repositories;

import com.pluralsight.springdatarest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(path = "users", exported = false) // Block access to the User repository
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

//    @Override
//    @RestResource(exported = false) // Block method to the User repository
//    void deleteById(Long id);
//
//    @Override
//    @RestResource(exported = false) // Block method to the User repository
//    void delete(User user);
}
