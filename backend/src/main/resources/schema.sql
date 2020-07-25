CREATE TABLE appointment
(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(100),
    description VARCHAR
);

CREATE TABLE doctor
(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(100),
    specialization VARCHAR(100)
);