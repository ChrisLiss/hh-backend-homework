CREATE TABLE if not exists area (
    area_id int primary key,
    name varchar(100)
);

CREATE TABLE if not exists salary (
    salary_id serial primary key,
    salary_from int,
    salary_to int,
    currency varchar(25),
    gross boolean
);

CREATE TABLE if not exists employer (
    employer_id int primary key,
    name varchar(100),
    description text,
    date_create timestamp,
    comment varchar(100),
    area_id int,
    views_count int default 0
);

CREATE TABLE if not exists vacancy (
    vacancy_id int primary key,
    name varchar(255),
    date_create timestamp,
    area_id int,
    employer_id int not null,
    salary_id int,
    created_at varchar(100),
    views_count int default 0,
    comment varchar(100),
    foreign key (employer_id) references employer(employer_id)
);



