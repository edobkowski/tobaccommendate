package com.tobaccode.tobaccommendate.controllers;

import com.tobaccode.tobaccommendate.entities.User;
import com.tobaccode.tobaccommendate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.GET)
    User getUserByUsername(@PathVariable(value = "username") String username) {
        Optional<User> user = this.userService.getByUsername(username);
        if(!user.isPresent()) {
            throw new NoSuchElementException("Cannot find user: " + username);
        }

        return user.get();
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "username") String username) {
        User user = getUserByUsername(username);
        this.userService.deleteUser(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        if (this.userService.getByUsername(user.getUsername()).isPresent()) {
            throw new PersistenceException("Username " + user.getUsername() + " is already taken");
        }
        this.userService.createUser(user.getUsername(), user.getFirstName(), user.getLastName());
    }
}
