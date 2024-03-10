package com.example.demosql.services;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demosql.models.User;
import com.example.demosql.repositories.UsersRepositories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UsersServiceTest {
    @Mock
    private UsersRepositories usersRepositories;

    @InjectMocks
    private UsersService usersService;

    private User user1, user2, updatedUser;

    @BeforeEach
    void setUp() {
        user1 = new User(1L, "Esteban", "password1");
        user2 = new User(2L, "Amiguito", "password2");
        updatedUser = new User(1L, "Tuvez", "newpassword");
    }

    @Test
    void testGetAllUsers() {
        List<User> userList = Arrays.asList(user1, user2);
        when(usersRepositories.findAll()).thenReturn(userList);

        Iterable<User> result = usersService.getAllUsers();
        assertIterableEquals(userList, result);
    }

    @Test
    void testGetUserById() {
        when(usersRepositories.findById(1L)).thenReturn(Optional.of(user1));
        when(usersRepositories.findById(2L)).thenReturn(Optional.empty());

        Optional<User> result = usersService.getUserById(1L);
        assertTrue(result.isPresent());
        assertEquals(user1, result.get());

        result = usersService.getUserById(2L);
        assertFalse(result.isPresent());
    }

    @Test
    void testDeleteUser() {
        usersService.deleteUser(1L);
        verify(usersRepositories, times(1)).deleteById(1L);
    }

    @Test
    void testCreateUser() {
        when(usersRepositories.save(any(User.class))).thenReturn(user1);

        User result = usersService.createUser(user1);
        assertEquals(user1, result);
    }

    @Test
    void testUpdateUser() {
        when(usersRepositories.findById(1L)).thenReturn(Optional.of(user1));
        when(usersRepositories.save(any(User.class))).thenReturn(updatedUser);

        User result = usersService.updateUser(1L, updatedUser);
        assertEquals(updatedUser, result);

        result = usersService.updateUser(2L, updatedUser);
        assertNull(result);
    }
}