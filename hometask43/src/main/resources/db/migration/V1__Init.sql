CREATE TABLE movies
(
    movie_id    UUID NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_movies PRIMARY KEY (movie_id)
);