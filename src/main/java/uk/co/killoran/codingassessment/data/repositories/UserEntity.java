package uk.co.killoran.codingassessment.data.repositories;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import uk.co.killoran.codingassessment.domain.MutableUser;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@AllArgsConstructor
@ToString
@Setter
@Getter
@EqualsAndHashCode
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

    @PrePersist
    void createStamp() {
        this.createStamp = LocalDateTime.now(ZoneOffset.UTC);
    }
}
