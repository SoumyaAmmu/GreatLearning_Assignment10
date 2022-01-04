
-- Items available in ManuCard
insert into Menu_Card values(1,'Butter Naan',50);
insert into Menu_Card values(2,'Garlic Naan',60);
insert into menu_Card values(3,'Paneer Butter Masala',250);
insert into Menu_Card values(4,'Kadai Paneer',250);
insert into Menu_Card values(5,'Mix Veg',200);
insert into Menu_Card values(6,'Daal Makhani',200);
insert into Menu_Card values(7,'Jeera Rice',180);
insert into Menu_Card values(8,'Veg Palao',200);
insert into Menu_Card values(9,'Kashmiri Palao',250);
insert into Menu_Card values(10,'Paneer Tikka',250);
insert into Menu_Card values(11,'Mix Veg Platter',150);
insert into Menu_Card values(12,'Sweet Lemon',30);
insert into Menu_Card values(13,'Cold Drink/200 ml',30);
insert into Menu_Card values(14,'2 Scoop Ice Cream',120);
insert into Menu_Card values(15,'Water Bottle/1L',20);


-- Insert in Monthly Sales Table

insert into Monthly_Sales_Report values('June2021', 200000);
insert into Monthly_Sales_Report values('July2021', 300000);
insert into Monthly_Sales_Report values('August2021', 340000);
insert into Monthly_Sales_Report values('September2021', 290000);

-- insert into user

insert into USER(userid,password,fullname,mobilenumber,emailid,enabled) values(1234,'psdeew123','Rajesh B',1234567891,'abx@gm.com',1);
insert into USER(userid,password,fullname,mobilenumber,emailid,enabled) values(34,'psdeew3','Vivek B',1239965691,'abx1@gm.com',1);
insert into USER(userid,password,fullname,mobilenumber,emailid,enabled) values(1,'Admin','Ram Mishra',9108679861,'nrain1@gm.com',1);


-- insert into Authorities

insert into Authorities values(3,'ADMIN_ROLE',1234);
insert into Authorities values(2,'USER_ROLE',34);
insert into Authorities values(1,'ADMIN_ROLE',1);
