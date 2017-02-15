drop table Order_Info_Item;
drop table Item;
drop table Shipment;
drop table Warehouse;
drop table Order_Info;
drop table Customer;

create table Customer (
	customer_id integer,
	customer_name varchar(40),
	city varchar(40),
	primary key (customer_id),
	check (customer_id is not null)
	);
	
create table Order_Info (
	order_number integer,
	order_date date,
	customer_id integer,
	Order_Info_amt integer,
	primary key (order_number),
	--I chose to cascade here because an order that no longer
	--belongs to a customer cannot be delivered, so the whole order should be deleted.
	foreign key (customer_id) references Customer(customer_id) on delete cascade,
	check (Order_Info_amt > 0)
	--date check doesn't work: check (order_date <= current_date)
	);
	
create table Item (
	item_number integer,
	unit_price float,
	primary key (item_number),
	check (item_number > 0),
	check (unit_price > 0)
	);
	
create table Order_Info_Item (
	order_number integer,
	item_number integer,
	qty integer,
	primary key (order_number, item_number),
	--I set null for both here because if the order or the item is deleted
	--then the customer should be notified that something went wrong with the order.
	foreign key (order_number) references Order_Info(order_number) on delete set null,
	foreign key (item_number) references Item(item_number) on delete set null,
	check (qty > 0)
	);
	
create table Warehouse (
	warehouse_number integer,
	city varchar(40),
	primary key (warehouse_number),
	check (warehouse_number is not null)
	);	
	
create table Shipment (
	order_number integer,
	warehouse_number integer,
	ship_date date,
	primary key (order_number, warehouse_number),
	--Similar to the Order_Info_Item table, if the shipment goes bad, and part of the data
	--is deleted, then we should set to null so that we can notify the customer that something
	--has gone wrong.
	foreign key (order_number) references Order_Info(order_number) on delete set null,
	foreign key (warehouse_number) references Warehouse(warehouse_number) on delete set null
	);
	
--Table creation now working properly, add values
insert into Customer values (1, 'Mitch', 'Grand Rapids');
insert into Customer values (2, 'Ben', 'Ada');
insert into Customer values (3, 'Julie', 'South Lyon');
insert into Customer values (4, 'Chip', 'Novi');

insert into Order_Info values (1, '01-Jan-2015', 1, 1);
insert into Order_Info values (2, '14-Feb-2016', 2, 1);
insert into Order_Info values (3, '16-Jun-1996', 3, 4);
insert into Order_Info values (4, '23-Jul-1990', 3, 2);

insert into Item values (1, 1.99);
insert into Item values (2, 9.99);
insert into Item values (3, 0.99);
insert into Item values (4, 99.99);

insert into Order_Info_Item values (1, 1, 2);
insert into Order_Info_Item values (2, 1, 4);
insert into Order_Info_Item values (1, 2, 3);
insert into Order_Info_Item values (3, 3, 3);

insert into Warehouse values (1, 'Detroit');
insert into Warehouse values (2, 'Lansing');
insert into Warehouse values (3, 'Grand Rapids');

insert into Shipment values (1, 1, '02-Jan-2015');
insert into Shipment values (2, 1, null);
insert into Shipment values (3, 3, '14-Feb-2017');
insert into Shipment values (4, 2, null);


--Exercise 5.20.a
--One possibility would be making a student use a combination of data to create a new key.
--Using something like name, birthday, hometown, and parent's names would create an almost unique
--key, but however unlikely, this would still cause a possibility of two identical keys.
--Another natural possibility that seems more possible and unique would be if the school database carries
--infromation on the class rank. The school could use the Student_Year and Class_Rank combination as the
--primary key, with the caveat that there would not be allowed to have any ties as Class_Rank (it could default
--to whoever has taken more credits, and if that is equal, then default to whose name comes alphabetically first)
--to complete the uniqueness.

--Excercise 5.20.c
--One advantage of using generated keys is that assuming you implement it correctly, you are guarunteed to have
--uniqueness among each set of data that is stored. Another advantage to generated keys would be the uniformity
--Among all tables that use this key. For example, a table with keys '1', '2', '3' would make it very clear
--as to how these keys were generated. However, there are a few disadvantages as well. One disadvantage
--is that it is not entirely clear what you are referencing when creating a foreign key reference. When entering
--values into a table, it is a lot more clear to see a key as 'Mitch Stark' than it is to see a student_id '3241341235'.
--Another disadvantage of generated keys is that for an app developer querying against this database, the generated key
--is just extra information that is required to select from a table, but often this "id" will not be used in the app, causing
--large queries to be slightly less efficient than if the keys were the data that the app needed to use.