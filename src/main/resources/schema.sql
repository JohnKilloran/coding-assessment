DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    id IDENTITY PRIMARY KEY,
    title VARCHAR(255),
    first_name VARCHAR(255),
    surname VARCHAR(255),
    dob DATE,
    job_title VARCHAR(255),
    create_stamp TIMESTAMP NOT NULL
);