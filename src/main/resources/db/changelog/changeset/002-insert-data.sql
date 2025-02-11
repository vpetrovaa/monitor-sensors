--liquibase formatted sql

--changeset vpetrovaa:002-insert-data

insert into monitor_types (name) values
    ('Pressure'),
    ('Voltage'),
    ('Temperature'),
    ('Humidity');

insert into monitor_units (name) values
    ('bar'),
    ('voltage'),
    ('°C'),
    ('%');

insert into monitor_sensors (name, model, range_from, range_to, type_id, unit_id, location, description) values
    ('Barometer', 'AC-23', 22, 45, 1, 1, 'Kitchen', 'Pressure sensor for kitchen'),
    ('Thermometer', 'T-100', 10, 50, 3, 3, 'Living room', 'Measures temperature in the living room'),
    ('Hygrometer', 'H-75', 30, 90, 4, 4, 'Bedroom', 'Humidity sensor for bedroom');
