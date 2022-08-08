package uk.co.killoran.codingassessment.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import uk.co.killoran.codingassessment.data.UserLifetime;
import uk.co.killoran.codingassessment.data.repositories.UserEntity;
import uk.co.killoran.codingassessment.domain.User;
import uk.co.killoran.codingassessment.domain.UserData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserLifetimeControllerTest {

    @Test
    void createUserGood() {
        UserData userData = new UserEntity(null, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", null);
        User user = new UserEntity(1L, "Mr", "John", "Killoran",
                                         LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserLifetime good = Mockito.mock(UserLifetime.class);
        UserLifetimeController controller = new UserLifetimeController(good);
        Mockito.when(good.create(any(UserData.class))).thenReturn(user);
        ResponseEntity<User> result = controller.createUser(userData);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(user, result.getBody());
    }

    @Test
    void createUserBad() {
        UserData userData = new UserEntity(null, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", null);
        UserLifetime bad = Mockito.mock(UserLifetime.class);
        UserLifetimeController controller = new UserLifetimeController(bad);
        Mockito.when(bad.create(any(UserData.class))).thenThrow(IllegalArgumentException.class);
        ResponseEntity<User> result = controller.createUser(userData);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }

    @Test
    void deleteUserGood() {
        User user = new UserEntity(1L, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserLifetime good = Mockito.mock(UserLifetime.class);
        UserLifetimeController controller = new UserLifetimeController(good);
        Mockito.doNothing().when(good).delete(any(User.class));
        ResponseEntity<User> result = controller.deleteUser(user);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(user, result.getBody());
    }

    @Test
    void deleteUserBad() {
        User user = new UserEntity(1L, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserLifetime bad = Mockito.mock(UserLifetime.class);
        UserLifetimeController controller = new UserLifetimeController(bad);
        Mockito.doThrow(IllegalArgumentException.class).when(bad).delete(any(User.class));
        ResponseEntity<User> result = controller.deleteUser(user);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }

    @Test
    void DeleteUserByIdGood() {
        Long id = 1L;
        UserLifetime good = Mockito.mock(UserLifetime.class);
        UserLifetimeController controller = new UserLifetimeController(good);
        Mockito.doNothing().when(good).deleteById(any(Long.class));
        ResponseEntity<Long> result = controller.deleteUser(id);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(id, result.getBody());
    }

    @Test
    void DeleteUserByIdBad() {
        Long id = 1L;
        UserLifetime bad = Mockito.mock(UserLifetime.class);
        UserLifetimeController controller = new UserLifetimeController(bad);
        Mockito.doThrow(IllegalArgumentException.class).when(bad).deleteById(any(Long.class));
        ResponseEntity<Long> result = controller.deleteUser(id);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }
}