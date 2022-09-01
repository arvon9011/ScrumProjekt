
create database Mars_travels;
use Mars_travels;

create table customers (
id int primary key auto_increment,
name varchar (20),
email varchar (40)
);

create table bookings (
	id int primary key auto_increment,
    customer_id int
);

create table trips (
id int primary key auto_increment,
booking_id int,
shipping_id int,
food ENUM ("lyx1", "fattig1", "medel1"),
sleep ENUM ("Spaceside", "luffare", "sleep capsule")
);

create table shipping (
id int primary key auto_increment,
to_mars boolean /* TRUE OM TILL*/,
departure DATE
);

insert into customers (name, email) values ("Gurra GG", "Gurras@gmail.com");
insert into bookings (customer_id) values ( 1);
insert into trips (booking_id, shipping_id, food, sleep) values (1, 1, "lyx1", "Spaceside");
insert into shipping (to_mars, departure) values (true, '2025:05:05');

insert into customers (name, email) values ("Walle Van", "dåligmail@gmail.com");
insert into bookings (customer_id) values ( 2);
insert into trips (booking_id, shipping_id, food, sleep) values (2, 2, "LYX1", "luffare");
insert into shipping (to_mars, departure) values (true, '2015:05:05');

insert into customers (name, email) values ("Gurra GG", "Gurras@gmail.com");
insert into bookings (customer_id) values ( 3);
insert into trips (booking_id, shipping_id, food, sleep) values (3, 3, "LYX1", "luffare");
insert into shipping (to_mars, departure) values (true, '2025:07:05');

insert into customers (name, email) values ("Gurra GG", "Gurras@gmail.com");
insert into bookings (customer_id) values ( 4);
insert into trips (booking_id, shipping_id, food, sleep) values (4, 4, "LYX1", "Spaceside");
insert into shipping (to_mars, departure) values (true, '2025:05:05');

insert into customers (name, email) values ("Walle Van", "dåligmail@gmail.com");
insert into bookings (customer_id) values ( 5);
insert into trips (booking_id, shipping_id, food, sleep) values (5, 5, "medel1", "Spaceside");
insert into shipping (to_mars, departure) values (true, '2025:05:05');



select * from trips;

DELIMITER //
CREATE PROCEDURE find_user(user int)
BEGIN
select name, email from customers as c
join bookings as b on c.id = b.customer_id
join trips as t on t.booking_id = b.id
WHERE c.id = user;
END //
DELIMITER ;

CALL find_user();


select * from bookings;
select * from trips;

DELIMITER //
CREATE PROCEDURE store_info(namnet varchar(20), mailen varchar(40))
BEGIN
DECLARE custom_id int default 0;
DECLARE book_id int default 0;
INSERT INTO customers (name, email) values (namnet, mailen);
SET custom_id = LAST_INSERT_ID();
INSERT INTO bookings (customer_id) values (custom_id);
SET book_id = LAST_INSERT_ID();
INSERT INTO trips (booking_id, shipping_id, food, sleep) values (custom_id, 1, "lyx1", "Spaceside");
END //
DELIMITER ;

CALL store_info("tjofräs", "test@mail");

select * from customers;