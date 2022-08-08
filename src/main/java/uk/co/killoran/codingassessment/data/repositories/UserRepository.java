package uk.co.killoran.codingassessment.data.repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.co.killoran.codingassessment.data.UserLifetime;
import uk.co.killoran.codingassessment.data.UserQuery;
import uk.co.killoran.codingassessment.data.UserUpdate;
import uk.co.killoran.codingassessment.domain.User;
import uk.co.killoran.codingassessment.domain.UserData;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * User repository to provide support for retrieving User records from a
 * data store.
 *
 * NOTE: Consider making extend PagingAndSortingRepository if requirements
 * extended to need managed bulk retrieval/sorting of users.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserLifetime, UserQuery, UserUpdate {

    default Optional<User> findByKey(Long id) {
        return findById(id).map(User.class::cast);
    }

    @Transactional
    @Override
    default User create(UserData userData) {
        return this.save(new UserEntity(null,
                                        userData.getTitle(),
                                        userData.getFirstName(),
                                        userData.getSurname(),
                                        userData.getDob(),
                                        userData.getJobTitle(),
                                        null));
    }

    @Transactional
    @Override
    default User update(User user) {
        return this.findById(user.getId()).map(usr -> {
            usr.setTitle(user.getTitle());
            usr.setFirstName(user.getFirstName());
            usr.setSurname(user.getSurname());
            usr.setDob(user.getDob());
            usr.setJobTitle(user.getJobTitle());
            return usr;
        }).orElse(null);
    }

    @Transactional
    default void delete(User user) {
        this.deleteById(user.getId());
    }
}
