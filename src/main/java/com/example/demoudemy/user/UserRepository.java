package com.example.demoudemy.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called UserRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@Component
public interface UserRepository extends JpaRepository<User, Integer> {

}
