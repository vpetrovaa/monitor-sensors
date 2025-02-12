--liquibase formatted sql

--changeset vpetrovaa:004-insert-data

insert into users (email, password, role) values
    ('admin@example.com', '$2a$10$0vyhQl/T9vDuJB3oVE970ugkaJe0YrDTZu3V/PSCr5hoSjsCSlj9q', 'ADMINISTRATOR'), -- admin_password
    ('user@example.com', '$2a$10$S4/gu9x/r5aRLhOrTD.K8OknZbTIAIG5CbsBnznUHGCpZdCfIgpfO', 'VIEWER'); -- user_password