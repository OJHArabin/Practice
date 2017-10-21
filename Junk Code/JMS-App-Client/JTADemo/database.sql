create table user_table
(
    user_id int(10) not null auto_increment,
    username varchar(40) not null,
    password char(32) not null,
    primary key	(user_id)
    
    );

create table group_table
(
    group_id int(10) not null,
    group_name varchar(40) not null,
    group_desc varchar(40) default null,
    primary key(group_id)
    
    );
create table user_group_table
(
    user_id int(10) not null ,
 group_id int(10) not null,
primary key(user_id,group_id)
);

create view view_user_role AS
select u.username, u.password, g.group_name
from user_group_table ug
	inner join user_table u on u.user_id=ug.user_id
	inner join group_table g on g.group_id=ug.group_id;