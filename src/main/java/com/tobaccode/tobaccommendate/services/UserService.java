package com.tobaccode.tobaccommendate.services;

import com.tobaccode.tobaccommendate.entities.User;
import com.tobaccode.tobaccommendate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String username, String firstName, String lastName) {
        this.userRepository.save(new User(username, firstName, lastName));
    }

    public Iterable<User> getAll() {
        return this.userRepository.findAll();
    }

    public Optional<User> getByUsername(String username) {
        return this.userRepository.findById(username);
    }

    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    public long getSize() {
        return this.userRepository.count();
    }
}
