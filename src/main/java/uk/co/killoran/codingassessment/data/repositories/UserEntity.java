package uk.co.killoran.codingassessment.data.repositories;

import lombok.*;
import uk.co.killoran.codingassessment.domain.MutableUser;
import uk.co.killoran.codingassessment.domain.UserData;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity implements MutableUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String title;
    @Column()
    private String firstName;
    @Column()
    private String surname;
    @Column()
    private LocalDate dob;
    @Column()
    private String jobTitle;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createStamp;

    public UserEntity(UserData userData) {
        this(null,
                userData.getTitle(),
                userData.getFirstName(),
                userData.getSurname(),
                userData.getDob(),
                userData.getJobTitle(),
                null);
    }

    @PrePersist
    void createStamp() {
        this.createStamp = LocalDateTime.now(ZoneOffset.UTC);
    }
}
