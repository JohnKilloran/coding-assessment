package uk.co.killoran.codingassessment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataImpl implements UserData {
    private String title;
    private String firstName;
    private String surname;
    private LocalDate dob;
    private String jobTitle;
}
