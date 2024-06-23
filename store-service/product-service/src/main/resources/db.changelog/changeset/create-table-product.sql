--liquibase formatted sql

--changeset create-table-product:1

create table if not exists product
(
    id          bigserial primary key,
    name        varchar(15) not null,
    description varchar(50) not null,
    price       numeric(15, 2)
);