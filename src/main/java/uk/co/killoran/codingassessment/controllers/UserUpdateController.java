package uk.co.killoran.codingassessment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.co.killoran.codingassessment.data.UserUpdate;
import uk.co.killoran.codingassessment.domain.User;

@RestController("/update")
public class UserUpdateController {

    private final UserUpdate userUpdate;

    public UserUpdateController(UserUpdate userUpdate) {
        this.userUpdate = userUpdate;
    }

    @PutMapping("/api/users/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try {
            User updated = userUpdate.update(user);
            return new ResponseEntity<>(user, updated == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
