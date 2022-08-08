package uk.co.killoran.codingassessment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.killoran.codingassessment.data.UserLifetime;
import uk.co.killoran.codingassessment.domain.User;
import uk.co.killoran.codingassessment.domain.UserData;

@RestController("/lifetime")
public class UserLifetimeController {
    private final UserLifetime userLifetime;

    public UserLifetimeController(UserLifetime userLifetime) {
        this.userLifetime = userLifetime;
    }

    @PostMapping("/api/users/")
    public ResponseEntity<User> createUser(@RequestBody UserData userData) {
        try {
            return new ResponseEntity<>(userLifetime.create(userData), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/api/users")
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        try {
            userLifetime.delete(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id) {
        try {
            userLifetime.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
