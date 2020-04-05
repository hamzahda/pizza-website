package com.example.controller;

import java.util.List;

import com.example.entity.User;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

@Autowired
private UserService userService;

@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
private List<User> getAll() {
try {
    return userService.getUser();
} catch (final Exception e) {

}
return null;
    
}
@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
private User getUser(@PathVariable final long id ) {
   return userService.findById(id);
}

@PostMapping("/")
private void postUser (@RequestBody final User user){
    userService.createUser(user);
}

@DeleteMapping("/{id}")
private void deleteUser (@PathVariable final long id){
    userService.deleteUserById(id);
}

@PutMapping("/{id}")
public  User modifAddr(@RequestBody final User user, @PathVariable final Long id) {
    User usr = userService.findById(id);
    usr.setAddress(user.getAddress());
    userService.update(usr);
    return usr;
  }






}
