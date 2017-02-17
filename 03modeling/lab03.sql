-- Starter code for lab 3.
--
-- CS 342, Spring, 2017
-- kvlinden
drop table Mentorship;
drop table Person_Team;
drop table Request;
drop table Person;
drop table Homegroup;
drop table Team;
drop table HouseHold;


create table HouseHold(
	ID integer PRIMARY KEY,
	street varchar(30),
	city varchar(30),
	state varchar(2),
	zipcode char(5),
	phoneNumber char(12)
	);

create table Homegroup (
	id integer primary key,
	name varchar(60),
	description varchar(140),
	location_id integer,
	foreign key (location_id) references HouseHold(id) on delete set null
	);	
	
create table Person (
	ID integer PRIMARY KEY,
	title varchar(4),
	firstName varchar(15),
	lastName varchar(15),
	householdRole varchar(15),
	householdID integer,
	homegroupID integer,
	membershipStatus char(1) CHECK (membershipStatus IN ('m', 'a', 'c')),
	foreign key (householdID) references HouseHold(ID) on delete set null
	);
	
create table Mentorship (
	mentee_id integer,
	mentor_id integer,
	--Mentee_id alone is the primary key because each  mentee can have
	--at most one mentor. Thus, using the mentee_id as the primary key
	--creates a constraint that a person can be a mentee to someone at most 1 time.
	primary key (mentee_id),
	foreign key (mentor_id) references person(id) on delete cascade,
	foreign key (mentee_id) references person(id) on delete cascade
	);
	
create table Team (
	id integer primary key,
	name varchar(60),
	description varchar(140)
	);
	
create table Person_Team (
	person_id integer,
	team_id integer,
	person_role varchar(30),
	primary key (person_id, team_id),
	foreign key (person_id) references person(id) on delete cascade,
	foreign key (team_id) references team(id) on delete cascade
	);

INSERT INTO Household VALUES (0,'2347 Oxford Dr. SE','Grand Rapids','MI','49506','616-243-5680');
insert into household values (1, '2433 Woodcliff Ave', 'Grand Rapids', 'MI', '49506', '2423532');

--no way of making this a check constraint, so db admin must only allow
--for the household in each homegroup to be one that is a group member's house.
insert into Homegroup values (0, 'bible study', 'study the bible', 0);
insert into Homegroup values (1, 'worship group', 'worship', 1);

INSERT INTO Person VALUES (0,'mr.','Keith','VanderLinden', 'husband', 0, null, 'm');
INSERT INTO Person VALUES (1,'ms.','Brenda','VanderLinden', 'wife', 0, 0, 'm');
insert into person values (2, 'mr.', 'mitch', 'stark', 'owner', 1, null, 'm');

insert into Mentorship values (1, 0);
insert into Mentorship values (0, 2);

insert into team values (0, 'Worship', 'This team is responsible for the worship music each Sunday');
insert into team values (1, 'Tech', 'This team is responsible for the technology used each Sunday');
insert into team values (2, 'Youth Ministry', 'This team is responsible for all things middle school through high school');

insert into Person_Team values (0, 0, 'Singer');
insert into Person_Team values (1, 0, 'Pianist');
insert into Person_Team values (2, 1, 'Video');

--Test queries
select * from team;
select * from person_team;
select * from homegroup;

select homegroup.name, person.firstName from person, homegroup where person.homegroupID = Homegroup.id;

select team.name, person.firstName from person, team, person_team where person.id = person_team.person_id and team.id = person_team.team_id;
