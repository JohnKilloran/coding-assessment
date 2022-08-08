package uk.co.killoran.codingassessment.data.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import uk.co.killoran.codingassessment.domain.MutableUser;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity implements MutableUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @CreationTimestamp
    private LocalDateTime createStamp;
}
