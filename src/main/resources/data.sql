create table users (
  id bigint not null, 
  email varchar(50), 
  first_name varchar(50), 
  last_name varchar(50), 
  role varchar(50), 
  ssn varchar(50), 
  user_name varchar(50), 
  primary key (id)
);
insert into users values(101, 'kreddy@stacksimplify.com', 'Kalyan', 'Reddy', 'admin', 'ssn101', 'kreddy');
insert into users values(102, 'gwiser@stacksimplify.com', 'Greg', 'Wiser', 'admin', 'ssn102', 'gwiser');
insert into users values(103, 'dmark@stacksimplify.com', 'David', 'Mark', 'admin', 'ssn103', 'dmark');