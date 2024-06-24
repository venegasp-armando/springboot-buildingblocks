create table _user (
  id bigint auto_increment, 
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
insert into _user values((select next value for _user_seq), 'kreddy@stacksimplify.com', 'Kalyan', 'Reddy', 'admin', 'ssn101', 'kreddy');
insert into _user values((select next value for _user_seq), 'gwiser@stacksimplify.com', 'Greg', 'Wiser', 'admin', 'ssn102', 'gwiser');
insert into _user values((select next value for _user_seq), 'dmark@stacksimplify.com', 'David', 'Mark', 'admin', 'ssn103', 'dmark');