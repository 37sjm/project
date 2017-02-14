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
	foreign key (order_number) references Order_Info(order_number) on delete cascade,
	foreign key (item_number) references Item(item_number) on delete cascade,
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
	foreign key (order_number) references Order_Info(order_number) on delete cascade,
	foreign key (warehouse_number) references Warehouse(warehouse_number) on delete cascade
	);
	
--Table creation now working properly, add values
insert into Customer values (1, 'Mitch', 'Grand Rapids');
insert into Customer values (2, 'Ben', 'Ada');
insert into Customer values (3, 'Julie', 'South Lyon');
insert into Customer values (4, 'Chip', 'Novi');

insert into Order_Info values (1, '01-Jan-2015', 1, 1);

insert into Item values (1, 1.99);

insert into Order_Info_Item values (1, 1, 2);

insert into Warehouse values (1, 'Detroit');

insert into Shipment values (1, 1, '02-Jan-2015');