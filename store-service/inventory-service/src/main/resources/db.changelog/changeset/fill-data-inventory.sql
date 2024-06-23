--liquibase formatted sql

--changeset fill-data-inventory:2

insert into inventory (id, product_id, stock, warehouse_address)
values (1, 1, 1000, 'Чертановская ул. д24 к2');
insert into inventory (id, product_id, stock, warehouse_address)
values (2, 2, 900, 'Чертановская ул. д24 к2');
insert into inventory (id, product_id, stock, warehouse_address)
values (3, 3, 800, 'Чертановская ул. д24 к2');
insert into inventory (id, product_id, stock, warehouse_address)
values (4, 4, 700, 'Чертановская ул. д24 к2');
insert into inventory (id, product_id, stock, warehouse_address)
values (5, 5, 600, 'Чертановская ул. д24 к2');
insert into inventory (id, product_id, stock, warehouse_address)
values (6, 6, 500, 'Чертановская ул. д24 к2');

