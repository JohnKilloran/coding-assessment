package uk.co.killoran.codingassessment.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import uk.co.killoran.codingassessment.data.UserQuery;
import uk.co.killoran.codingassessment.data.repositories.UserEntity;
import uk.co.killoran.codingassessment.domain.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class UserQueryControllerTest {
    @Test
    void findByIdFound() {
        Long id = 1L;
        User user = new UserEntity(id, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserQuery found = Mockito.mock(UserQuery.class);
        UserQueryController controller = new UserQueryController(found);
        Mockito.doReturn(Optional.of(user)).when(found).findByKey(any(Long.class));
        ResponseEntity<User> result = controller.findById(id);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(user, result.getBody());
    }

    @Test
    void findByIdNotFound() {
        Long id = 1L;
        UserQuery found = Mockito.mock(UserQuery.class);
        UserQueryController controller = new UserQueryController(found);
        Mockito.doReturn(Optional.empty()).when(found).findByKey(any(Long.class));
        ResponseEntity<User> result = controller.findById(id);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertNull(result.getBody());
    }

    @Test
    void findByIdFailed() {
        Long id = 1L;
        UserQuery found = Mockito.mock(UserQuery.class);
        UserQueryController controller = new UserQueryController(found);
        Mockito.doThrow(IllegalArgumentException.class).when(found).findByKey(any(Long.class));
        ResponseEntity<User> result = controller.findById(id);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertNull(result.getBody());
    }

    @Test
    void findByFirstNameFound() {
        String firstName = "John";
        User user = new UserEntity(1L, "Mr", firstName, "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserQuery found = Mockito.mock(UserQuery.class);
        UserQueryController controller = new UserQueryController(found);
        Mockito.doReturn(Collections.singletonList(user)).when(found).findByFirstName(any(String.class));
        ResponseEntity<List<User>> result = controller.findByFirstName(firstName);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(Collections.singletonList(user), result.getBody());
    }

    @Test
    void findByFirstNameNotFound() {
        String firstName = "John";
        UserQuery found = Mockito.mock(UserQuery.class);
        UserQueryController controller = new UserQueryController(found);
        Mockito.doReturn(Collections.emptyList()).when(found).findByFirstName(any(String.class));
        ResponseEntity<List<User>> result = controller.findByFirstName(firstName);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertTrue(result.getBody().isEmpty());
    }

    @Test
    void findByFirstNameFailed() {
        String firstName = "John";
        UserQuery found = Mockito.mock(UserQuery.class);
        UserQueryController controller = new UserQueryController(found);
        Mockito.doThrow(IllegalArgumentException.class).when(found).findByFirstName(any(String.class));
        ResponseEntity<List<User>> result = controller.findByFirstName(firstName);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertNull(result.getBody());
    }

    @Test
    void findBySurnameFound() {
        String surname = "Killoran";
        User user = new UserEntity(1L, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserQuery found = Mockito.mock(UserQuery.class);
        UserQueryController controller = new UserQueryController(found);
        Mockito.doReturn(Collections.singletonList(user)).when(found).findBySurname(any(String.class));
        ResponseEntity<List<User>> result = controller.findBySurname(surname);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(Collections.singletonList(user), result.getBody());
    }

    @Test
    void findBySurnameNotFound() {
        String surname = "Killoran";
        UserQuery found = Mockito.mock(UserQuery.class);
        UserQueryController controller = new UserQueryController(found);
        Mockito.doReturn(Collections.emptyList()).when(found).findBySurname(any(String.class));
        ResponseEntity<List<User>> result = controller.findBySurname(surname);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertTrue(result.getBody().isEmpty());
    }

    @Test
    void findBySurnameFailed() {
        String surname = "Killoran";
        UserQuery found = Mockito.mock(UserQuery.class);
        UserQueryController controller = new UserQueryController(found);
        Mockito.doThrow(IllegalArgumentException.class).when(found).findBySurname(any(String.class));
        ResponseEntity<List<User>> result = controller.findBySurname(surname);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertNull(result.getBody());
    }
}
