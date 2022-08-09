package uk.co.killoran.codingassessment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserImpl implements User, MutableUser {
    private Long id;
    private String title;
    private String firstName;
    private String surname;
    private LocalDate dob;
    private String jobTitle;
    private LocalDateTime createStamp;

    public UserImpl setUserData(UserData user) {
        this.setTitle(user.getTitle());
        this.setFirstName(user.getFirstName());
        this.setSurname(user.getSurname());
        this.setDob(user.getDob());
        this.setJobTitle(user.getJobTitle());
        return this;
    }
}
