create sequence hibernate_sequence start with 1 increment by 1;

    create table users (
       id bigint not null,
        create_stamp timestamp not null,
        dob date,
        first_name varchar(255),
        job_title varchar(255),
        surname varchar(255),
        title varchar(255),
        primary key (id)
    );
create sequence hibernate_sequence start with 1 increment by 1;

    create table users (
       id bigint not null,
        create_stamp timestamp not null,
        dob date,
        first_name varchar(255),
        job_title varchar(255),
        surname varchar(255),
        title varchar(255),
        primary key (id)
    );
