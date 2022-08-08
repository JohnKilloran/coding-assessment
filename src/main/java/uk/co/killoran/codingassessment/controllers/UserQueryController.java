package uk.co.killoran.codingassessment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.killoran.codingassessment.data.UserQuery;
import uk.co.killoran.codingassessment.domain.User;

import java.util.List;

@RestController("query")
public class UserQueryController {

    private final UserQuery query;

    public UserQueryController(UserQuery query) {
        this.query = query;
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        try {
            return query.findByKey(id).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/users/{firstName}")
    public ResponseEntity<List<User>> findByFirstName(@PathVariable("firstName") String firstName) {
        try {
            return new ResponseEntity<>(query.findByFirstName(firstName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/users/{surname}")
    public ResponseEntity<List<User>> findBySurname(@PathVariable("surname") String surname) {
        try {
            return new ResponseEntity<>(query.findBySurname(surname), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
