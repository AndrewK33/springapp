create table categories
(
    id    bigserial primary key,
    title varchar(256)
);
insert into categories (title)
values ('Food');

create table products
(
    id          bigserial primary key,
    title       varchar(256),
    price       int,
    category_id bigint REFERENCES categories (id)
);
insert into products (title, price, category_id)
values ('Bread', 25, 1),
       ('Milk', 80, 1),
       ('Meat', 100, 1),
       ('Juice', 30, 1),
       ('Egg', 50, 1),
       ('Pasta', 40, 1),
       ('Banana', 30, 1),
       ('Cheese', 230, 1),
       ('Rice', 100, 1),
       ('Yoghurt', 60, 1),
       ('Fish', 300, 1),
       ('Nuts', 10, 1),
       ('Chips', 40, 1),
       ('Biscuits', 500, 1),
       ('Ice cream', 55, 1),
       ('Rolls', 335, 1),
       ('Cordial', 255, 1),
       ('Mineral Water', 155, 1),
       ('Pancake', 100, 1),
       ('Butter', 20, 1);


create table users
(
    id       bigserial,
    username varchar(30) not null unique,
    password varchar(80) not null,
    primary key (id)
);


create table roles
(
    id   serial,
    name varchar(50) not null,
    primary key (id)
);

CREATE TABLE users_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);



insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password)
values ('John', '$2a$12$q5Md4RhypYpk80GCyluqQ.VISKSyydg9iJsxe4x7m4PXQqcwolqi6'),
       ('Bob', '$2a$12$q5Md4RhypYpk80GCyluqQ.VISKSyydg9iJsxe4x7m4PXQqcwolqi6');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);



create table orders
(
    id      bigserial primary key,
    user_id bigint references users (id),
    address varchar(255),
    phone   varchar(255),
    price   integer

);

create table order_items
(
    id                bigserial primary key,
    order_id          bigint references orders (id),
    product_id        bigint references products (id),
    quantity          integer,
    price_per_product integer,
    price             integer

);

insert into orders(user_id, address, phone, price)
values (1, '1111', '111', 100);

insert into order_items (order_id, product_id, quantity, price_per_product, price)
values (1, 1, 4, 25, 100);


