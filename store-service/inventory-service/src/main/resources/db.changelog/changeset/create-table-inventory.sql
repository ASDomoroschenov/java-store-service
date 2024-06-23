--liquibase formatted sql

--changeset create-table-inventory:1

create table if not exists inventory
(
    id                bigserial primary key,
    product_id        bigint      not null,
    stock             numeric(5)  not null,
    warehouse_address varchar(30) not null
);
