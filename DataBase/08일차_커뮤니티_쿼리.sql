-- Active: 1722306683503@@127.0.0.1@3306@community
select * from post;
select * from member where me_id = 'abc123' and me_fail < 5;

insert into community(co_name) VALUEs ("운동");
delete FROM community where co_name = '운동';


update community set co_name = "프로그래밍" WHERE co_name = "운동"; 