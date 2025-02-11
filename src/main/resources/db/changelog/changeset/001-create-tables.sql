--liquibase formatted sql

--changeset vpetrovaa:001-create-tables

create table monitor_types (
    id bigserial primary key,
    name varchar(20) not null unique
);

create table monitor_units (
    id bigserial primary key,
    name varchar(10) not null unique
);

create table monitor_sensors (
    id bigserial primary key,
    name varchar(30) not null,
    model varchar(15) not null,
    range_from int not null check (range_from > 0),
    range_to int not null check (range_to > range_from),
    type_id bigint,
    unit_id bigint,
    location varchar(40),
    description varchar(200),
    foreign key (type_id) references monitor_types (id) on update cascade on delete set null,
    foreign key (unit_id) references monitor_units (id) on update cascade on delete set null
);