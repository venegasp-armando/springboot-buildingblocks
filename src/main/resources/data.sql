create table _user (
  id bigint auto_increment, 
  address varchar(50),
  email varchar(50), 
  first_name varchar(50), 
  last_name varchar(50), 
  role varchar(50), 
  ssn varchar(50), 
  user_name varchar(50), 
  primary key (id)
);
CREATE SEQUENCE _user_seq
  START WITH 1
  INCREMENT BY 1
  MINVALUE 1;
insert into _user values((select next value for _user_seq), 'New York', 'kreddy@stacksimplify.com', 'Kalyan', 'Reddy', 'admin', 'ssn101', 'kreddy');
insert into _user values((select next value for _user_seq), 'New Jersey', 'gwiser@stacksimplify.com', 'Greg', 'Wiser', 'admin', 'ssn102', 'gwiser');
insert into _user values((select next value for _user_seq), 'California', 'dmark@stacksimplify.com', 'David', 'Mark', 'admin', 'ssn103', 'dmark');

create table orders (
  orderid bigint auto_increment, 
  description varchar(50), 
  user_id bigint, 
  primary key (orderid)
);
CREATE SEQUENCE order_seq
  START WITH 1
  INCREMENT BY 1
  MINVALUE 1;
insert into orders values( (select next value for order_seq), 'order11', 1);        
insert into orders values( (select next value for order_seq), 'order12', 1);
insert into orders values( (select next value for order_seq), 'order13', 1);
insert into orders values( (select next value for order_seq), 'order21', 2);
insert into orders values( (select next value for order_seq), 'order22', 2);
insert into orders values( (select next value for order_seq), 'order31', 3);