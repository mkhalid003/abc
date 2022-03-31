package com.abc.abcdemoservice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.abc.abcdemoservice.entities.UserModel;
import com.abc.abcdemoservice.repositories.UserRespository;

@RestController
public class UserController {

	@Autowired
    private UserRespository userRespository;

    @Autowired
    public UserController(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @GetMapping("/user/all")
    Iterable<UserModel> all() {
        return userRespository.findAll();
    }

    @GetMapping("/user/{id}")
    UserModel userById(@PathVariable Long id) {
        return userRespository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user/save")
    UserModel save(@RequestBody UserModel user) {
        return userRespository.save(user);
    }

}