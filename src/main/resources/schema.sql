-- INSERT INTO TEST_TABLE(first_name, last_name) VALUES
--     ('Artem', 'Puzikov'),
--     ('Kate', 'Shatalova'),
--     ('User', 'Userovich');

DROP TABLE IF EXISTS TEST_TABLE;

CREATE TABLE TEST_TABLE(
                           id int auto_increment primary key ,
                           first_name varchar(250) not null ,
                           last_name varchar(250) not null
);