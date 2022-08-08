package uk.co.killoran.codingassessment.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import uk.co.killoran.codingassessment.data.UserUpdate;
import uk.co.killoran.codingassessment.data.repositories.UserEntity;
import uk.co.killoran.codingassessment.domain.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;

public class UserUpdateControllerTest {
    @Test
    void updateUserFound() {
        User user = new UserEntity(1L, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserUpdate found = Mockito.mock(UserUpdate.class);
        UserUpdateController controller = new UserUpdateController(found);
        Mockito.doReturn(user).when(found).update(any(User.class));
        ResponseEntity<User> result = controller.updateUser(user);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(user, result.getBody());
    }

    @Test
    void updateUserNotFound() {
        User user = new UserEntity(1L, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserUpdate found = Mockito.mock(UserUpdate.class);
        UserUpdateController controller = new UserUpdateController(found);
        Mockito.doReturn(null).when(found).update(any(User.class));
        ResponseEntity<User> result = controller.updateUser(user);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
    }

    @Test
    void updateUserFailed() {
        User user = new UserEntity(1L, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserUpdate failed = Mockito.mock(UserUpdate.class);
        UserUpdateController controller = new UserUpdateController(failed);
        Mockito.doThrow(IllegalArgumentException.class).when(failed).update(any(User.class));
        ResponseEntity<User> result = controller.updateUser(user);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }
}
