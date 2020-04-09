package com.user.controller;

import java.util.List;

import com.user.entity.User;
import com.user.service.UserService;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;

@GetMapping(value = "/")
public ResponseEntity<List<User>> getAll() {
    logger.info(" get request : get all users ");
    return ResponseEntity.ok(userService.getUser());   
}

@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<User> getUser(@PathVariable Long id) {
    if (!userService.checkUser(id)) {
        logger.error("the given user id: %d is not found", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    logger.info("get request : get user with the id : %d", id);
    return ResponseEntity.ok(userService.findById(id));
}

@PostMapping("/")
public ResponseEntity<User> postUser (@RequestBody final User user){
    logger.error("post request : create user");
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteUser (@PathVariable final long id){
    if (!userService.checkUser(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    logger.error("delete request:  %d user is deleted", id);
    return ResponseEntity.ok(String.format("User with ID : %d is deleted successfuly", id));
}

@PutMapping("/{id}")
public ResponseEntity<User> modifyUser(@RequestBody final User user, @PathVariable final Long id) {
    if (!userService.checkUser(id)) {
        logger.error("the given user id: %d is not found", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    logger.error("put request: %d user is modified ", id);
    return ResponseEntity.ok(userService.update(user));
  }






}
