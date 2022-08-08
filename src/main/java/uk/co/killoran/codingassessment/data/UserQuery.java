package uk.co.killoran.codingassessment.data;

import uk.co.killoran.codingassessment.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserQuery {
    Optional<User> findByKey(Long id);
    List<User> findByFirstName(String firstName);
    List<User> findBySurname(String surname);
}
