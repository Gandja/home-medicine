create table user_info
(
    id        uuid primary key not null,
    name      varchar(250),
    last_name varchar(250),
    email     varchar(250) unique,
    phone     varchar(50),
    age       integer,
    gender    varchar(50),
    medicine  JSONB            NOT NULL
);




