INSERT INTO AIRPORT (ID, NAME, COUNTRY, CITY)
VALUES (1, 'Санкт-Петербург Пулково', 'Россия', 'Санкт-Петербург');
INSERT INTO AIRPORT (ID, NAME, COUNTRY, CITY)
VALUES (2, 'Москва Шереметьево', 'Россия', 'Москва');


INSERT INTO FLIGHT (ID, FLIGHT_NUMBER, DATE_TIME, PRICE, FROM_AIRPORT_ID, TO_AIRPORT_ID)
VALUES (1, 'AFL031', '2021-10-08 20:00', 1500, 1, 2);

INSERT INTO FLIGHT (ID, FLIGHT_NUMBER, DATE_TIME, PRICE, FROM_AIRPORT_ID, TO_AIRPORT_ID)
VALUES (2, 'AFL032', '2021-10-08 20:00', 1500, 2, 1);
