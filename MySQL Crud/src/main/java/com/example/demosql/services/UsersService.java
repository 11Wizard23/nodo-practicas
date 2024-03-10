package com.example.demosql.services;

import com.example.demosql.models.User;
import com.example.demosql.repositories.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepositories usersRepositories;

    public Iterable<User> getAllUsers() {
        return usersRepositories.findAll();
    }

    public Optional<User> getUserById(Long id){
        return usersRepositories.findById(id);
    }

    public void deleteUser(Long id){
        usersRepositories.deleteById(id);
    }

    public User createUser(User user) {
        return usersRepositories.save(user);
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUser = usersRepositories.findById(id);

        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setPassword(user.getPassword());

            return usersRepositories.save(updatedUser);
        } else {
            return null;
        }
    }
}
