-- CREATE DATABASE app_props_example_dev WITH ENCODING='utf-8';
-- CREATE DATABASE app_props_example_test WITH ENCODING='utf-8';

DROP TABLE IF EXISTS movie;


CREATE TABLE movie (
  id   BIGSERIAL PRIMARY KEY,
  title TEXT,
  director TEXT,
  year INTEGER
);

INSERT INTO movie (title, director, year) VALUES
  ('Wedding Crashers', 'David Dobkin', 2005),
  ('Starsky & Hutch', 'Todd Phillips', 2004),
  ('Shanghai Knights', 'David Dobkin', 2003),
  ('I-Spy', 'Betty Thomas', 2002),
  ('The Royal Tenenbaums', 'Wes Anderson', 2001),
  ('Zoolander', 'Ben Stiller', 2001),
  ('Shanghai Noon', 'Tom Dey', 2000);
