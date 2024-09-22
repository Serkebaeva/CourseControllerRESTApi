CREATE TABLE COURSE (
    ID INT PRIMARY KEY,
    NAME VARCHAR(255),
    AUTHOR VARCHAR(255)
);
CREATE SEQUENCE COURSE_SEQ START WITH 1 INCREMENT BY 1;

INSERT INTO COURSE (ID, NAME, AUTHOR)
VALUES (101, 'Learn Microservices', 'in28minutes');

INSERT INTO COURSE (ID, NAME, AUTHOR)
VALUES (102, 'Learn FullStack with React and Angular ', 'in28minutes');

INSERT INTO COURSE (ID, NAME, AUTHOR)
VALUES (103, 'Learn AWS, GCP and Azure', 'in28minutes');
