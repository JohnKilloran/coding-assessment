package uk.co.killoran.codingassessment.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonDeserialize(as=UserImpl.class)
public interface MutableUser extends User {
    void setId(Long id);
    void setTitle(String title);
    void setFirstName(String firstName);
    void setSurname(String surname);
    void setDob(LocalDate dob);
    void setJobTitle(String jobTitle);
    void setCreateStamp(LocalDateTime createStamp);

    default MutableUser setUserData(UserData user) {
        this.setTitle(user.getTitle());
        this.setFirstName(user.getFirstName());
        this.setSurname(user.getSurname());
        this.setDob(user.getDob());
        this.setJobTitle(user.getJobTitle());
        return this;
    }
}
