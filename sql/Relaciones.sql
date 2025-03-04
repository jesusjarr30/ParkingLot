#Create database
CREATE database parkingLot;

 use parkingLot;

#Tables
CREATE TABLE `parking` (
  `id` integer PRIMARY KEY,
  `name` varchar(100),
  `location` integer,
  `spaces` integer,
  `unavailable` integer,
  `idprices` integer,
  `softDelete` boolean,
  `created_at` timestamp
);

CREATE TABLE `userCategories` (
  `id` integer PRIMARY KEY,
  `role` varchar(255),
  `softDelete` varchar(255),
  `created_at` timestamp
);

CREATE TABLE `user` (
  `id` integer PRIMARY KEY,
  `name` varchar(100),
  `socialNumber` varchar(15),
  `RFC` varchar(15),
  `number` varchar(15),
  `idSupervisor` integer,
  `idCategories` integer,
  `password` varchar(100),
  `softDelete` boolean,
  `created_at` timestamp
);

CREATE TABLE `ticket` (
  `id` integer PRIMARY KEY,
  `idParking` integer,
  `active` boolean,
  `total` double,
  `details` varchar(250),
  `lost` boolean,
  `start` date,
  `finish` date,
  `extraCharge` double,
  `softDelete` boolean
);

CREATE TABLE `prices` (
  `id` integer PRIMARY KEY,
  `hourP` double,
  `minutesP` double,
  `longTerm` double,
  `softDelete` boolean
);

CREATE TABLE `longTermParking` (
  `id` integer PRIMARY KEY,
  `idcustomer` integer,
  `idParking` integer,
  `softDelete` boolean
);

CREATE TABLE `customer` (
  `id` integer PRIMARY KEY,
  `name` varchar(100),
  `idCompany` integer,
  `plateCar` varchar(15),
  `brand` varchar(50),
  `year` integer,
  `color` varchar(15),
  `active` boolean,
  `softDelete` boolean
);

CREATE TABLE `company` (
  `id` integer PRIMARY KEY,
  `name` varchar(100),
  `NumEmployes` integer,
  `discounts` double,
  `RFC` varchar(15)
);

CREATE TABLE `expenses` (
  `id` integer PRIMARY KEY,
  `idParking` integer,
  `idUser` integer,
  `reason` integer,
  `price` varchar(255),
  `autorization` boolean,
  `status` char,
  `softDelete` boolean
);

CREATE TABLE `invoices` (
  `id` integer PRIMARY KEY,
  `dateE` date,
  `total` double,
  `idCompany` integer,
  `softDelete` boolean
);

CREATE TABLE `crash` (
  `id` integer PRIMARY KEY,
  `idCutomer` integer,
  `idTicket` integer,
  `driverName` varchar(100),
  `plate` varchar(10),
  `licenseDriver` varchar(100),
  `details` varchar(1000),
  `cost` double,
  `status` char,
  `softDelete` boolean
);

CREATE TABLE `workingRelationship` (
  `id` integer PRIMARY KEY,
  `idUser` integer,
  `idParking` integer
);

#relations

ALTER TABLE parking MODIFY id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE userCategories MODIFY id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE ticket MODIFY id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE prices MODIFY id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE longTermParking MODIFY id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE customer MODIFY id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE company MODIFY id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE expenses MODIFY id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE invoices MODIFY id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE crash MODIFY id INT NOT NULL AUTO_INCREMENT;
ALTER TABLE workingRelationship MODIFY id INT NOT NULL AUTO_INCREMENT;




ALTER TABLE parking ADD CONSTRAINT fk_parking_prices FOREIGN KEY (idprices) REFERENCES prices(id); 
ALTER TABLE `user` ADD FOREIGN KEY (`idCategories`) REFERENCES `userCategories` (`id`);
ALTER TABLE `user` ADD FOREIGN KEY (`idSupervisor`) REFERENCES `user` (`id`);
ALTER TABLE `ticket` ADD FOREIGN KEY (`idParking`) REFERENCES `parking` (`id`);
ALTER TABLE `longTermParking` ADD FOREIGN KEY (`idcustomer`) REFERENCES `customer` (`id`);
ALTER TABLE `longTermParking` ADD FOREIGN KEY (`idParking`) REFERENCES `parking` (`id`);
ALTER TABLE `customer` ADD FOREIGN KEY (`idCompany`) REFERENCES `company` (`id`);
ALTER TABLE `expenses` ADD FOREIGN KEY (`idParking`) REFERENCES `parking` (`id`);
ALTER TABLE `expenses` ADD FOREIGN KEY (`idUser`) REFERENCES `user` (`id`);
ALTER TABLE `crash` ADD FOREIGN KEY (`idCutomer`) REFERENCES `customer` (`id`);
ALTER TABLE `crash` ADD FOREIGN KEY (`idTicket`) REFERENCES `ticket` (`id`);
ALTER TABLE `invoices` ADD FOREIGN KEY (`idCompany`) REFERENCES `company` (`id`);
ALTER TABLE `workingRelationship` ADD FOREIGN KEY (`idParking`) REFERENCES `parking` (`id`);
ALTER TABLE `workingRelationship` ADD FOREIGN KEY (`idUser`) REFERENCES `user` (`id`);


#Data


INSERT INTO parkingLot.prices
(hourp, id, long_term, soft_delete)
VALUES(15, 2, 160, 0);

INSERT INTO parkingLot.prices
(hourp, id, long_term, soft_delete)
VALUES(16, 3, 165, 0);

INSERT INTO parkingLot.prices
(hourp, id, long_term, soft_delete)
VALUES(18, 4, 150, 0);

INSERT INTO parkingLot.prices
(hourp, id, long_term, soft_delete)
VALUES(12, 5, 170, 0);

INSERT INTO parkingLot.prices
(hourp, id, long_term, soft_delete)
VALUES(19, 6, 150, 0);



INSERT INTO parkingLot.parking
(id, id_prices, soft_delete, spaces, unavailable, created_at, location, name)
VALUES (1, 1, 0, 20, 1, NOW(), 'Av california', 'park Jesus');


INSERT INTO parkingLot.parking
(id, id_prices, soft_delete, spaces, unavailable, created_at, location, name)
VALUES (2, 2, 0, 68, 1, NOW(), 'Av lopez Mateos', 'New parking');

INSERT INTO parkingLot.parking
(id, id_prices, soft_delete, spaces, unavailable, created_at, location, name)
VALUES (3, 3, 0, 79, 1, NOW(), 'Garibaldi', 'Mario parking');

INSERT INTO parkingLot.parking
(id, id_prices, soft_delete, spaces, unavailable, created_at, location, name)
VALUES (4, 4, 0, 79, 1, NOW(), 'del sur', 'Casino parking');

INSERT INTO parkingLot.parking
(id, id_prices, soft_delete, spaces, unavailable, created_at, location, name)
VALUES (5, 5, 0, 120, 1, NOW(), 'la perla', 'Company sa de cv');


INSERT INTO parkingLot.parking
(id, id_prices, soft_delete, spaces, unavailable, created_at, location, name)
VALUES (6, 6, 0, 90, 1, NOW(), 'Arboledas', 'Lopez company');


//Generar tickets que esten activos 



INSERT INTO parkingLot.ticket
(id,active, id_parking, idltp, soft_delete, finish, `start`)
VALUES(1,true, 1, NULL, 0, 0, '2025-03-03 14:30', NULL);

INSERT INTO parkingLot.ticket 
(id, active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES (5, true, 2, NULL, false, '2025-03-03 14:30:00', NULL);

INSERT INTO parkingLot.ticket 
( active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES ( true, 2, NULL, false, '2025-03-03 13:30:00', NULL);


INSERT INTO parkingLot.ticket 
( active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES ( true, 2, NULL, false, '2025-03-03 16:30:00', NULL);

INSERT INTO parkingLot.ticket 
( active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES ( true, 3, NULL, false, '2025-03-03 16:30:00', NULL);

INSERT INTO parkingLot.ticket 
( active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES ( true, 3, NULL, false, '2025-03-03 13:30:00', NULL);


INSERT INTO parkingLot.ticket 
( active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES ( true, 3, NULL, false, '2025-03-03 16:30:00', NULL);

INSERT INTO parkingLot.ticket 
( active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES ( true, 4, NULL, false, '2025-03-03 13:30:00', NULL);


INSERT INTO parkingLot.ticket 
( active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES ( true, 4, NULL, false, '2025-03-03 16:30:00', NULL);

INSERT INTO parkingLot.ticket 
( active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES ( true, 5, NULL, false, '2025-03-03 13:30:00', NULL);


INSERT INTO parkingLot.ticket 
( active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES ( true, 5, NULL, false, '2025-03-03 16:30:00', NULL);

INSERT INTO parkingLot.ticket 
( active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES ( true, 6, NULL, false, '2025-03-03 13:30:00', NULL);


INSERT INTO parkingLot.ticket 
( active, id_parking, idltp, soft_delete, finish, `start`) 
VALUES ( true, 6, NULL, false, '2025-03-03 16:30:00', NULL);

#creacion de los tipos de usuarios que pueden existir 

INSERT INTO parkingLot.user_categories (soft_delete, created_at, `role`)
VALUES (false, NOW(), 'Administrator');

INSERT INTO parkingLot.user_categories (soft_delete, created_at, `role`)
VALUES (false, NOW(), 'Supervisor');

INSERT INTO parkingLot.user_categories (soft_delete, created_at, `role`)
VALUES (false, NOW(), 'Cashier');

INSERT INTO parkingLot.user_categories (soft_delete, created_at, `role`)
VALUES (false, NOW(), 'Maintenance');



















