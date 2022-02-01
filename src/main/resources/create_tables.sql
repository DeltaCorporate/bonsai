create table bonsai.bonsai (
    id uuid primary key,
    name varchar(100) not null,
    species varchar(100),
    acquisition_date date,
    acquisition_age integer,
    status varchar(25)
);
