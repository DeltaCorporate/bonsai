create table bonsai (
    id id primary key,
    name varchar(100) not null,
    species varchar(100),
    acquisition_date date,
    age integer,
    status varchar(25)
);
create table owner(id uuid primary key, name varchar(100));
alter table bonsai add column owner_id uuid, add constraint fk_bonsai_owner foreign key (owner_id) references owner(id);

CREATE  table care_event(
    id uuid primary key,
    bonsai_id uuid,
    care_date timestamp ,
    care_type varchar(100),
    care_owner_id uuid,
    constraint fk_care_bonsai foreign key (bonsai_id) references bonsai(id),
    constraint fk_care_owner foreign key (care_owner_id) references owner(id)
)