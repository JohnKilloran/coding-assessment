package uk.co.killoran.codingassessment.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

/**
 * Basic user record type.
 *
 * NOTE: String was chosen for id's type as it was not clear from the requirements
 * if it was a simple DB id (i.e. key) or an actual piece of user data. LocalDate
 * was chosen for dob (date of birth) type as a concept it is essentially timezone
 * independent. Finally, it was assumed that createStamp field implied "creation
 * timestamp", and thus since UTC will be used for all timestamp logging in order
 * to make comparison of timestamps easier it was reasonable to use LocalDateTime
 * as its type.
 */
@JsonDeserialize(as=UserImpl.class)
public interface User extends UserData {
    Long getId();
    LocalDateTime getCreateStamp();
}
