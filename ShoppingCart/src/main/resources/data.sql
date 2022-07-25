create table Role(roleId int primary key auto_increment, role varchar(255));
insert into Role(role) values ('CONSUMER');
insert into Role(role) values ('SELLER');

create table Categories(categoryId int primary key auto_increment, categoryName varchar(255));
insert into Categories(categoryName) values ('Fashion');
insert into Categories (categoryName) values('Electronics');
insert into Categories (categoryName) values ('Books');
insert into Categories(categoryName) values ('Groceries');
insert into Categories (categoryName) values ('Medicines');

create table Users(username varchar(255), password varchar(255));
insert into Users(username, password) values ('jack','pass_word');
insert into Users(username, password) values('bob','pass_word');
insert into Users(username, password) values ('apple','pass_word');
insert into Users(username, password) values('glaxo','pass_word');

create table if not exists Cart(totalAmount double, userId int);
insert into Cart(totalAmount, userId) values (28,1);
insert into Cart(totalAmount, userId) values (0,2);

create table if not exists UserRole(userId int, role varchar(255));
insert into UserRole(userId, role) values (1,1);
insert into UserRole(userId, role) values (2,1);
insert into UserRole(userId, role) values (3,2);
insert into UserRole (userId, role) values (4,2);

create table if not exists Product(price double, productName varchar(255), categoryId int, sellerId int);
insert into Product (price, productName, categoryId, sellerId) values (29190, 'Apple iPad 10.2 8th Gen WiFi 105 Tablet', 2, 3);
insert into Product (price, productName, categoryId, sellerId) values (10, 'Crocin pain relief tablet', 5, 4);

create table if not exists CartProduct(cartId int, productId int, quantity int);
insert into CartProduct(cartId, productId, quantity) values (1,2,2);