create table activity (
	activity_id INT NOT NULL,
	person_id INT NOT NULL,
	value VARCHAR(20) NOT NULL,
	activity_date DATETIME,
	PRIMARY KEY (activity_id)
) ;


create table vitals (
	vitals_id int not null,
	person_id int not null,
	vitals_date DATETIME,
	systolic int,
	diatolic int,
	pulse int,
	comment text,
	primary key(vitals_id)
);