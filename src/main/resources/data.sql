INSERT INTO COUNTRY_MASTER (COUNTRY_ID,COUNTRY_NAME) VALUES(1,'INDIA');
INSERT INTO COUNTRY_MASTER (COUNTRY_ID,COUNTRY_NAME) VALUES(2,'USA');

INSERT INTO STATES_MASTER (STATE_ID,COUNTRY_ID,STATE_NAME) VALUES(1,1,'TAMIL NADU');
INSERT INTO STATES_MASTER (STATE_ID,COUNTRY_ID,STATE_NAME) VALUES(2,1,'ANDHRA PRADESH');
INSERT INTO STATES_MASTER (STATE_ID,COUNTRY_ID,STATE_NAME) VALUES(3,2,'NEW JERSY');
INSERT INTO STATES_MASTER (STATE_ID,COUNTRY_ID,STATE_NAME) VALUES(3,2,'OHIO');

INSERT INTO CITIES_MASTER (CITY_ID,CITY_NAME,STATE_ID) VALUES(1,'CHENNAI',1);
INSERT INTO CITIES_MASTER (CITY_ID,CITY_NAME,STATE_ID) VALUES(2,'TVM',1);
INSERT INTO CITIES_MASTER (CITY_ID,CITY_NAME,STATE_ID) VALUES(3,'VIZAG',2);
INSERT INTO CITIES_MASTER (CITY_ID,CITY_NAME,STATE_ID) VALUES(4,'GUNTUR',2);
INSERT INTO CITIES_MASTER (CITY_ID,CITY_NAME,STATE_ID) VALUES((5,'MAYWOOD',3);
INSERT INTO CITIES_MASTER (CITY_ID,CITY_NAME,STATE_ID) VALUES(6,'WESTWOOD',3);
INSERT INTO CITIES_MASTER (CITY_ID,CITY_NAME,STATE_ID) VALUES(7,'OAKWOOD',4);
INSERT INTO CITIES_MASTER (CITY_ID,CITY_NAME,STATE_ID) VALUES(8,'CUYAHOGA COUNTY',4);