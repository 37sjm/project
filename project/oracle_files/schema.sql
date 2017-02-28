drop table player;
drop table league_standings;
drop table league;
drop table tournament;
drop table game;
drop table team;
	
create table team (
	id integer primary key not null,
	name varchar(30) not null,
	wins integer,
	losses integer,
	ties integer
	);
	
create table player (
	id integer primary key not null,
	name varchar(60) not null,
	pos varchar(1) not null,
	num integer not null,
	age integer not null,
	gs integer,
	sub integer,
	goals integer,
	shots integer,
	assists integer,
	fs integer,
	fc integer,
	teamId integer,
	check (age > 0),
	foreign key (teamId) references team(id) on delete set null
	);
	
create table league (
	id integer primary key not null,
	name varchar(30),
	location varchar(30)
	);
	
create table league_standings (
	teamId integer not null,
	leagueId integer not null,
	standing integer,
	primary key (teamId, leagueId),
	foreign key (teamId) references team(id) on delete cascade,
	foreign key (leagueId) references league(id) on delete cascade,
	check (standing >= 1 and standing <= 20) --leagues only have 1-20 standing
	);
	
create table tournament (
	id integer primary key not null,
	name varchar(30) not null,
	location varchar(30)
	);
	
create table game (
	id integer primary key not null,
	team_one_id integer,
	team_two_id integer,
	game_date Date,
	team_one_score integer,
	team_two_score integer,
	predicted_winner integer
	);
