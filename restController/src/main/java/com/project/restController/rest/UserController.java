package com.project.restController.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hibernate.entity.UserEntity;
import com.project.hibernate.service.UserService;



@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired(required=true)
    private UserService userService;
	
	@PostMapping("/createuser")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
//
//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }

}
