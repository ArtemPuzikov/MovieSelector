
DROP TABLE IF EXISTS MOVIE_TABLE;

CREATE TABLE MOVIE_TABLE(
                           id bigint auto_increment primary key ,
                           name varchar(250) not null ,
                           year int not null ,
                           rate int not null ,
                           genre varchar(20) not null ,
                           description varchar(2055) not null
);