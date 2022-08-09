package uk.co.killoran.codingassessment.data.repositories;

import org.junit.jupiter.api.Test;
import uk.co.killoran.codingassessment.domain.User;
import uk.co.killoran.codingassessment.domain.UserData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {
    @Test
    void userDataConstructorTest() {
        UserData userData = new UserEntity(1L, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        User user = new UserEntity(userData);
        assertNull(user.getId());
        assertNull(user.getCreateStamp());
        assertEquals(userData.getTitle(), user.getTitle());
        assertEquals(userData.getFirstName(), user.getFirstName());
        assertEquals(userData.getSurname(), user.getSurname());
        assertEquals(userData.getDob(), user.getDob());
        assertEquals(userData.getJobTitle(), user.getJobTitle());
    }

    @Test
    void userDataCreateStamp() {
        UserEntity entity = new UserEntity(null, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", null);
        assertNull(entity.getCreateStamp());
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        entity.createStamp();
        assertTrue(now.isBefore(entity.getCreateStamp()) || now.isEqual(entity.getCreateStamp()));
    }
}