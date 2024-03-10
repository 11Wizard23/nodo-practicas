package com.example.demosql.controllers;

import com.example.demosql.models.User;
import com.example.demosql.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    public UsersController() {
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        Optional<User> existingUser = usersService.getUserById(id);
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(existingUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<User>> deleteUser(@PathVariable Long id) {
        Optional<User> existingUser = usersService.getUserById(id);
        if (existingUser.isPresent()) {
            usersService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(existingUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = usersService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> existingUser = usersService.getUserById(id);
        if (existingUser.isPresent()) {
            User updatedUser = usersService.updateUser(id, user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
