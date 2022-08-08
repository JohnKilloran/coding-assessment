package uk.co.killoran.codingassessment.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

@JsonDeserialize(as=UserDataImpl.class)
public interface UserData {
    String getTitle();
    String getFirstName();
    String getSurname();
    LocalDate getDob();
    String getJobTitle();
}
