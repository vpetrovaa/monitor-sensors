--liquibase formatted sql

--changeset vpetrovaa:003-create-tables

create table users (
    id bigserial primary key,
    email varchar(255) not null,
    password varchar(255) not null,
    role varchar(50) not null
);