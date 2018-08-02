CREATE DATABASE shop;

USE shop;

CREATE TABLE users
(
id INTEGER NOT NULL SERIAL PRIMARY KEY,
firstName VARCHAR(30) NOT NULL,
lastName VARCHAR(30) NOT NULL,
email VARCHAR(30) NOT NULL,
password VARCHAR(30) NOT NULL,
role VARCHAR(30) NOT NULL
);

CREATE TABLE products
(
id INTEGER NOT NULL SERIAL PRIMARY KEY,
name VARCHAR(30) NOT NULL,
price INT NOT NULL,
img VARCHAR(30) NOT NULL,
category_id INT NOT NULL,
manufacturer_id INTEGER NOT NULL
);

CREATE TABLE category
(
id INTEGER NOT NULL SERIAL PRIMARY KEY,
name VARCHAR(30) NOT NULL
);

CREATE TABLE manufacturer
(
  id INTEGER NOT NULL SERIAL PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

CREATE TABLE basket
(
basket_id INTEGER SERIAL,
user_id INTEGER NOT NULL
);

CREATE TABLE basketdeatils
(
  basketdeatils_id INTEGER SERIAL NOT NULL PRIMARY KEY,
  basket_id INTEGER NOT NULL,
  product_id INTEGER NOT NULL,
  quantity INTEGER NOT NULL
);

ALTER TABLE basketdeatils
ADD FOREIGN KEY (id_user) REFERENCES users(id);

ALTER TABLE basket
ADD FOREIGN KEY (id_product) REFERENCES products(id);

ALTER TABLE category
ADD FOREIGN KEY (id) REFERENCES products(category);



INSERT INTO category (name) VALUES ('Первая категория');
INSERT INTO category (name) VALUES ('Вторая категория');

INSERT INTO manufacturer (name) VALUES ('Производитель 1');
INSERT INTO manufacturer (name) VALUES ('Производитель 2');

INSERT INTO products (name, price, img, category_id, manufacturer_id) VALUES ('product1', 1, 'img\square.png', 1, 1);
INSERT INTO products (name, price, img, category_id, manufacturer_id) VALUES ('product2', 2, 'img\square.png', 1, 1);
INSERT INTO products (name, price, img, category_id, manufacturer_id) VALUES ('product3', 3, 'img\square.png', 1, 1);
INSERT INTO products (name, price, img, category_id, manufacturer_id) VALUES ('product4', 4, 'img\square.png', 1, 1);
INSERT INTO products (name, price, img, category_id, manufacturer_id) VALUES ('product5', 5, 'img\square.png', 2, 2);
INSERT INTO products (name, price, img, category_id, manufacturer_id) VALUES ('product6', 6, 'img\square.png', 2, 2);
INSERT INTO products (name, price, img, category_id, manufacturer_id) VALUES ('product7', 7, 'img\square.png', 2, 2);
INSERT INTO products (name, price, img, category_id, manufacturer_id) VALUES ('product8', 8, 'img\square.png', 2, 2);

INSERT INTO users ("firstName", "lastName", email, password, role) VALUES ('admin', 'admin', 'admin@mail.ru', 'qweqweqwe', 0);

INSERT INTO basket (user_id) VALUES (1);

INSERT INTO basketdetails (id_basket, id_product, quantity) VALUES (1, 1, 2);
INSERT INTO basketdetails (id_basket, id_product, quantity) VALUES (1, 3, 5);
INSERT INTO basketdetails (id_basket, id_product, quantity) VALUES (1, 5, 2);
INSERT INTO basketdetails (id_basket, id_product, quantity) VALUES (1, 8, 5);


SELECT p.name, b.quantity FROM basketdetails b JOIN products p ON b.product_id = p.id

