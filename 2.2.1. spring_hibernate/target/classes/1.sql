 CREATE TABLE users(
     id int PRIMARY KEY,
     first_name varchar(100) NOT NULL,
     last_name varchar(100) NOT NULL,
     email varchar(100) NOT NULL
 );
    CREATE TABLE car(
    users_id int PRIMARY KEY REFERENCES users(id) ON DELETE CASCADE,
    model varchar(100) NOT NULL,
    series int NOT NULL
 );
--    select * from users;
--    select * from car;
