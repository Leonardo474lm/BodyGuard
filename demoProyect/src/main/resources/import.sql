-- Insertar métodos de pago
INSERT INTO payments (id,methods) VALUES (1,'Yape');
INSERT INTO payments (id,methods) VALUES (2,'Plin');

-- Insertar especialidades
INSERT INTO specializations (id,description, name) VALUES (1,'Defensa personal', 'Defensa cuerpo a cuerpo');
INSERT INTO specializations (id,description, name) VALUES (2,'Manejo de armas', 'Manejo de armas');

-- Insertar usuarios
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (1,'Alonso', 'Martinez Cuellar', 30, '12345678', 'alonso@gmail.com', '1992-01-01', 'Masculino', '123', '123456789');
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (2,'Chicho', 'Peña Baltazar',    25, '87654321', 'chicho@gmail.com', '1997-05-15', 'Masculino', '123', '987654321');
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (3,'Bruno', 'Leon Perez',        35, '13579246', 'bruno@gmail.com', '1987-11-20', 'Masculino', '123', '456789123');
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (4,'Ariel', 'Mars',              30, '68345678', 'ariel@gmail.com', '1992-01-01', 'Masculino', '123', '123456750');
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (5,'Boris', 'Aguero',            25, '90654321', 'boris@gmail.com', '1997-05-15', 'Masculino', '123', '987654324');
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (6,'Carlos', 'Lujan',            35, '20579246', 'carlos@gmail.com', '1987-11-20', 'Masculino', '123', '456789122');
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (7,'Michael', 'Sura',            25, '90668321', 'michael@gmail.com', '1997-05-15', 'Masculino', '123', '987655324');
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (8,'Piero', 'Garcia Fernandez',  35, '13579247', 'piero@gmail.com', '1987-11-20', 'Masculino', '123', '456909123');
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (9,'Juan', 'Alvarez Gonza',      30, '70341643', 'juang@gmail.com', '1992-01-01', 'Masculino', '123', '123456880');
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (10,'Julian', 'Alvarez Garcia',  25, '90654349', 'jualiang@gmail.com', '1997-05-15', 'Masculino', '123', '987659024');
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (11,'Pedro', 'Chavez Flores',    35, '10379250', 'pedroc@gmail.com', '1987-11-20', 'Masculino', '123', '458787122');
INSERT INTO users (id,name, lastname, age, dni, email, fech_nac, gender, password, phone) VALUES (12,'Saul', 'Sanchez Rojas',     26, '40671341', 'sauls@gmail.com', '1996-05-15', 'Masculino', '123', '907654324');

-- Insertar roles
INSERT INTO roles (rol, user_id) VALUES ('Administrador',1);
INSERT INTO roles (rol, user_id) VALUES ('Cliente',      2);
INSERT INTO roles (rol, user_id) VALUES ('Bodyguard',    3);
INSERT INTO roles (rol, user_id) VALUES ('Bodyguard',    4);
INSERT INTO roles (rol, user_id) VALUES ('Bodyguard',    5);
INSERT INTO roles (rol, user_id) VALUES ('Bodyguard',    6);
INSERT INTO roles (rol, user_id) VALUES ('Cliente',      7);
INSERT INTO roles (rol, user_id) VALUES ('Bodyguard',    8);
INSERT INTO roles (rol, user_id) VALUES ('Bodyguard',    9);
INSERT INTO roles (rol, user_id) VALUES ('Bodyguard',    10);
INSERT INTO roles (rol, user_id) VALUES ('Bodyguard',    11);
INSERT INTO roles (rol, user_id) VALUES ('Bodyguard',    12);

-- Insertar bodyguards
INSERT INTO bodyguards (id,district, price_per_hour, st_activo, specializations, user_id) VALUES (1,'Miraflores', 50.00, true, 1, 3);
INSERT INTO bodyguards (id,district, price_per_hour, st_activo, specializations, user_id) VALUES (2,'San Isidro', 60.00, true, 2, 4);
INSERT INTO bodyguards (id,district, price_per_hour, st_activo, specializations, user_id) VALUES (3,'Barranco',   55.00, true, 1, 5);
INSERT INTO bodyguards (id,district, price_per_hour, st_activo, specializations, user_id) VALUES (4,'Miraflores', 50.00, true, 2, 6);
INSERT INTO bodyguards (id,district, price_per_hour, st_activo, specializations, user_id) VALUES (5,'Barranco',   50.00, true, 2, 8);
INSERT INTO bodyguards (id,district, price_per_hour, st_activo, specializations, user_id) VALUES (6,'Lima',       70.00, true, 2, 9);
INSERT INTO bodyguards (id,district, price_per_hour, st_activo, specializations, user_id) VALUES (7,'Barranco',   40.00, true, 2, 10);
INSERT INTO bodyguards (id,district, price_per_hour, st_activo, specializations, user_id) VALUES (8,'Rimac',      50.00, true, 1, 11);
INSERT INTO bodyguards (id,district, price_per_hour, st_activo, specializations, user_id) VALUES (9,'San Miguel', 40.00, true, 1, 12);
-- Insertar clientes
INSERT INTO clients (id,user_id) VALUES (1,2);
INSERT INTO clients (id,user_id) VALUES (2,7);

--insertar services
INSERT INTO services (date, hours, hours_start, location, review, st_aceptar, st_anulado, st_pagado, bodyguard_id, client_id, payment_id) VALUES ('2023-11-11', 2, 14, 'Av. La Marina 69'       , 5, true, false, true ,  1, 1, 2);
INSERT INTO services (date, hours, hours_start, location, review, st_aceptar, st_anulado, st_pagado, bodyguard_id, client_id, payment_id) VALUES ('2023-11-10', 3, 12, 'Av. Universitaria 1500' , 1, true, false, true,   2, 1, 1);
INSERT INTO services (date, hours, hours_start, location, review, st_aceptar, st_anulado, st_pagado, bodyguard_id, client_id, payment_id) VALUES ('2023-12-25', 4, 16, 'Av. Javier Prado 122'   , 0, false, false, true, 1, 1, 2);
INSERT INTO services (date, hours, hours_start, location, review, st_aceptar, st_anulado, st_pagado, bodyguard_id, client_id, payment_id) VALUES ('2023-12-20', 3, 12, 'Av. Los Rosales 96'     , 0, false, false, false, 4, 1, 1);

SELECT setval('payments_id_seq', (SELECT MAX(id) FROM payments));
SELECT setval('bodyguards_id_seq', (SELECT MAX(id) FROM specializations));
SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));
SELECT setval('roles_id_seq', (SELECT MAX(id) FROM roles));
SELECT setval('bodyguards_id_seq', (SELECT MAX(id) FROM bodyguards));
SELECT setval('clients_id_seq', (SELECT MAX(id) FROM clients));
SELECT setval('services_id_seq', (SELECT MAX(id) FROM services));
