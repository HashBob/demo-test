package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
//    public interface UserRepository extends JpaRepository<User,Long>{
//
//    }
    @Autowired
    UserRepository repository;

    @PostMapping("/user")
    public String addUser(User user){
        repository.save(user);
        return "User added successfully";
    }
    @GetMapping("/user")
    public List<User> getUsers(){
        return repository.findAll();
    }
}
