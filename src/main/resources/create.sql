create table Users (
    id bigint not null,
    title varchar(255),
    firstName varchar(255),
    surname varchar(255),
    dob date,
    jobTitle varchar(255)
    createStamp timestamp not null,

    primary key (id)
)