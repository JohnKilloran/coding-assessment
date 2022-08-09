package uk.co.killoran.codingassessment.data.repositories;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.co.killoran.codingassessment.domain.User;
import uk.co.killoran.codingassessment.domain.UserData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserRepositoryTest {

    @Test
    void findByKeyFound() {
        Long id = 1L;
        UserEntity entity = new UserEntity(id, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserRepository repository = Mockito.mock(UserRepository.class);
        Mockito.doCallRealMethod().when(repository).findByKey(any(Long.class));
        Mockito.doReturn(Optional.of(entity)).when(repository).findById(any(Long.class));
        Optional<User> result = repository.findByKey(id);
        assertTrue(result.isPresent());
        assertTrue(result.filter(entity::equals).isPresent());
    }

    @Test
    void findByKeyNotFound() {
        Long id = 1L;
        UserRepository repository = Mockito.mock(UserRepository.class);
        Mockito.doCallRealMethod().when(repository).findByKey(any(Long.class));
        Mockito.doReturn(Optional.empty()).when(repository).findById(any(Long.class));
        Optional<User> result = repository.findByKey(id);
        assertFalse(result.isPresent());
    }

    @Test
    void create() {
        Long id = 1L;
        UserEntity entity = new UserEntity(id, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserRepository repository = Mockito.mock(UserRepository.class);
        Mockito.doCallRealMethod().when(repository).create(any(UserData.class));
        Mockito.doReturn(entity).when(repository).save(any(UserEntity.class));
        assertEquals(entity, repository.create(entity));
    }

    @Test
    void updateFound() {
        Long id = 1L;
        UserEntity entity = new UserEntity(id, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserRepository repository = Mockito.mock(UserRepository.class);
        Mockito.doCallRealMethod().when(repository).update(any(User.class));
        Mockito.doReturn(Optional.of(entity)).when(repository).findById(any(Long.class));
        Mockito.doAnswer(iv -> iv.getArgument(0)).when(repository).save(any(UserEntity.class));
        assertEquals(entity, repository.update(entity));
    }

    @Test
    void updateNotFound() {
        Long id = 1L;
        UserEntity entity = new UserEntity(id, "Mr", "John", "Killoran",
                LocalDate.of(1970,1,1),
                "Developer", LocalDateTime.now(ZoneOffset.UTC));
        UserRepository repository = Mockito.mock(UserRepository.class);
        Mockito.doCallRealMethod().when(repository).update(any(User.class));
        Mockito.doReturn(Optional.empty()).when(repository).findById(any(Long.class));
        assertNull(repository.update(entity));
    }

    @Test
    void delete() {
    }
}