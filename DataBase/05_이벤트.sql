use product;

drop table if exists test;
create table if not exists test(
	num int primary key auto_increment,
	date datetime not null default current_timestamp

);
drop event if exists insert_event;
create event insert_event
on schedule every 30 second
starts '2024-07-25 12:35:00'
do insert into test() values();

select * from test;