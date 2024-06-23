--liquibase formatted sql

--changeset fill-data-product:1

insert into product (id, description, name, price)
values (1, 'Новый айфон 15', 'Iphone 15', 1000.00);
insert into product (id, description, name, price)
values (2, 'Айфон 14', 'Iphone 14', 950.00);
insert into product (id, description, name, price)
values (3, 'Айфон 13', 'Iphone 13', 900.00);
insert into product (id, description, name, price)
values (4, 'Айфон 12', 'Iphone 12', 850.00);
insert into product (id, description, name, price)
values (5, 'Айфон 11', 'Iphone 11', 800.00);
insert into product (id, description, name, price)
values (6, 'Устаревший айфон 10', 'Iphone 10', 500.00);
