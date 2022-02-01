CREATE TABLE products(id int auto_increment primary key,
product_id varchar(7),
seller_id varchar(7),
product_name varchar(50),
product_description varchar(100),
price float,
quantity int,
status bool);

CREATE TABLE sellers(id int auto_increment primary key,
seller_id varchar(7),
seller_name varchar(50),
password varchar(30)) ;

CREATE TABLE customers(id int auto_increment primary key,
customer_id varchar(7),
customer_name varchar(50),
password varchar(30)) ;

CREATE TABLE reviews(id int auto_increment primary key,
product_id varchar(7),
customer_id varchar(7),
review_description varchar(100)) ;

CREATE TABLE carts(id int auto_increment primary key,
product_id varchar(7),
customer_id varchar(7),
bought bool);

CREATE TABLE sales(id int auto_increment primary key,
product_id varchar(7),
customer_id varchar(7));