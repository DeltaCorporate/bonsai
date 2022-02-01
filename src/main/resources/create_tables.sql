create table bonsai.bonsai (
    id id primary key,
    name varchar(100) not null,
    species varchar(100),
    acquisition_date date,
    age integer,
    status varchar(25)
);
