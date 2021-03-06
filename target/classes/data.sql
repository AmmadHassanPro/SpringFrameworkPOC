/*
Due to Hibernate's DDL auto property, Hibernate would take any sql file placed on the root of the class paths 
and executes it on application startup if Spring Boot detects that we are using an embedded database, in this case H2.

This is for initializing the Category and Unit Of Measure Entities
*/

INSERT INTO CATEGORY (DESCRIPTION) VALUES ('American');
INSERT INTO CATEGORY (DESCRIPTION) VALUES ('Italian');
INSERT INTO CATEGORY (DESCRIPTION) VALUES ('Mexican');
INSERT INTO CATEGORY (DESCRIPTION) VALUES ('Fast Food');
INSERT INTO UNIT_OF_MEASURE (DESCRIPTION) VALUES ('Teaspoon');
INSERT INTO UNIT_OF_MEASURE (DESCRIPTION) VALUES ('Tablespoon');
INSERT INTO UNIT_OF_MEASURE (DESCRIPTION) VALUES ('Cup');
INSERT INTO UNIT_OF_MEASURE (DESCRIPTION) VALUES ('Pinch');
INSERT INTO UNIT_OF_MEASURE (DESCRIPTION) VALUES ('Clove');
INSERT INTO UNIT_OF_MEASURE (DESCRIPTION) VALUES ('Small');
INSERT INTO UNIT_OF_MEASURE (DESCRIPTION) VALUES ('Medium');
INSERT INTO UNIT_OF_MEASURE (DESCRIPTION) VALUES ('Pint');
INSERT INTO UNIT_OF_MEASURE (DESCRIPTION) VALUES ('Dash');
INSERT INTO UNIT_OF_MEASURE (DESCRIPTION) VALUES ('Unit');


