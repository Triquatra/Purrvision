-- namn datatyp regler
CREATE TABLE IF NOT EXISTS bookings
(
    id               UUID    NOT NULL,
    name             VARCHAR(255),
    email            VARCHAR(255),
    movie_title      VARCHAR(255),
    date_time        TIMESTAMP,
    number_of_people INTEGER NOT NULL,
    status           VARCHAR(255) CHECK (status IN ('PENDING', 'CONFIRMED', 'CANCELLED')),
    PRIMARY KEY (id)
);