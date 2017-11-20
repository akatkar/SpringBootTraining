DROP TABLE IF EXISTS PERSON;
create table person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)    
);

INSERT INTO PERSON VALUES(1001, 'Ali', 'Istanbul', sysdate());
INSERT INTO PERSON VALUES(1002, 'Veli', 'Istanbul', sysdate());
INSERT INTO PERSON VALUES(1003, 'Hasan', 'Istanbul', sysdate());
INSERT INTO PERSON VALUES(1004, 'Deniz', 'Istanbul', sysdate());
