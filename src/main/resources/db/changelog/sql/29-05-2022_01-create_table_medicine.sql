create table medicine
(
    id              uuid primary key not null,
    name            varchar(250)     not null,
    count           integer,
    description     varchar,
    expiration_date date,
    user_info_id    uuid references user_info(id)
);