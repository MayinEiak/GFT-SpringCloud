/*Carga catálogo género*/
INSERT INTO CTL_GENDER (gender_id, gender) VALUES (1, 'Masculino');
INSERT INTO CTL_GENDER (gender_id, gender) VALUES (2, 'Femenino');

/*Carga catálogo tipo de producto*/
INSERT INTO CTL_PRODUCT_TYPE (product_type_id, name) VALUES (1, 'Tarjeta de Débito');
INSERT INTO CTL_PRODUCT_TYPE (product_type_id, name) VALUES (2, 'Tarjeta de Crédito');

/*Carga clientes prueba*/
INSERT INTO TBL_CLIENT (client_id, name, last_names, birth_date, gender_id) VALUES (1, 'Mario', 'Camacho Silva', '2000-10-11', 1);
INSERT INTO TBL_CLIENT (client_id, name, last_names, birth_date, gender_id) VALUES (2, 'Juan', 'Gonzáles López', '1990-05-11', 1);
INSERT INTO TBL_CLIENT (client_id, name, last_names, birth_date, gender_id) VALUES (3, 'Rosa', 'Gutierrez Sánchez', '1995-02-18', 2);
INSERT INTO TBL_CLIENT (client_id, name, last_names, birth_date, gender_id) VALUES (4, 'Elena', 'Sánchez García', '1980-02-18', 2);

/*Carga cuentas prueba*/
INSERT INTO TBL_ACCOUNT (account_number, balance, product_type_id, client_id) VALUES (123456, 150.50, 1, 1);
INSERT INTO TBL_ACCOUNT (account_number, balance, product_type_id, client_id) VALUES (123457, 1500.50, 2, 1);
INSERT INTO TBL_ACCOUNT (account_number, balance, product_type_id, client_id) VALUES (123458, 250.50, 2, 1);
INSERT INTO TBL_ACCOUNT (account_number, balance, product_type_id, client_id) VALUES (123459, 150.50, 1, 2);
INSERT INTO TBL_ACCOUNT (account_number, balance, product_type_id, client_id) VALUES (123410, 150.50, 1, 3);
INSERT INTO TBL_ACCOUNT (account_number, balance, product_type_id, client_id) VALUES (123411, 150.50, 2, 3);
INSERT INTO TBL_ACCOUNT (account_number, balance, product_type_id, client_id) VALUES (123412, 150.50, 1, 4);

INSERT INTO TASK (id, description, priority) VALUES (1, 'Hola', 1);
INSERT INTO TASK (id, description, priority) VALUES (2, 'Hol2', 4);


