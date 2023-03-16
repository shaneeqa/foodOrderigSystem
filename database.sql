create database food_order;

use food_order;

create table customer(
customer_id bigint not null,
customer_name varchar(50),
customer_address varchar(200),
customer_telephone int,
primary key(customer_id)
);

create table food_category(
category_id bigint not null,
category_name varchar(50),
availability boolean,
primary key(category_id)
);

create table food_item(
item_id bigint not null,
item_name varchar(50),
item_description varchar(1000),
category_id bigint,
item_price float,
availability boolean,
primary key(item_id),
foreign key(category_id) references food_category(category_id)
);


create table orders(
order_id bigint not null,
order_date date,
total_price float,
order_status ENUM('DELIVERED','PENDING', 'CANCELLED', 'PREPARING', 'READY') not null,
customer_id bigint,
primary key(order_id),
foreign key(customer_id) references customer(customer_id)
);

create table order_line(
line_number bigint not null,
quantity int,
order_id bigint,
customer_id bigint,
primary key(line_number),
foreign key(customer_id) references customer(customer_id),
foreign key(order_id) references orders(order_id)
);

drop table orders, order_line;

alter table customer
modify column customer_id int;
