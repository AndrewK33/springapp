create table products
(
    id bigserial primary key,
    title varchar(256),
    price int
);
insert into products (title, price)
values ('Bread', 25),
       ('Milk', 80),
       ('Meat', 100),
       ('Juice', 30),
       ('Egg', 50),
       ('Pasta', 40),
       ('Banana', 30),
       ('Cheese', 230),
       ('Rice', 100),
       ('Yoghurt', 60),
       ('Fish', 300),
       ('Nuts', 10),
       ('Chips', 40),
       ('Biscuits', 500),
       ('Ice cream', 55),
       ('Rolls', 335),
       ('Cordial', 255),
       ('Mineral Water', 155),
       ('Pancake', 100),
       ('Butter', 20);