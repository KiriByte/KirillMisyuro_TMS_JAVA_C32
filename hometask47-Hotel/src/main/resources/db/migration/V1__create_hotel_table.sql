CREATE TABLE hotels
(
    id           UUID PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    is_available BOOLEAN      NOT NULL DEFAULT TRUE
);