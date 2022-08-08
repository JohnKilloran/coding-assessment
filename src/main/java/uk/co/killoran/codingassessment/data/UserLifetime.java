package uk.co.killoran.codingassessment.data;

import uk.co.killoran.codingassessment.domain.User;
import uk.co.killoran.codingassessment.domain.UserData;

public interface UserLifetime {
    User create(UserData userData);
    void delete(User user);
    void deleteById(long id);
}
