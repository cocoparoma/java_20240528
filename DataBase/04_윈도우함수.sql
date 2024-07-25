# DB 생성
drop database if exists product;
create database if not exists product;
use product;

# category Table 생성
drop table if exists category;
create table if not exists category(
	ca_code char(2) primary key,
    ca_name varchar(10) not null
);

# product Table 생성
drop table if exists product;
create table if not exists product(
	pr_code char(3) primary key,
    pr_name varchar(10) not null,
    pr_price int not null default 0,
    pr_ca_code char(2),
    foreign key(pr_ca_code) references category(ca_code)
);

insert into category values ('AB', '가전'),('CD', '의류'),('EF', '식품');

insert into product values
('AB1', '컴퓨터', 1000000,'AB'),
('AB2', '마우스', 10000,'AB'),
('CD1', '셔츠', 15000, 'CD'),
('CD2', '청바지', 50000,'CD'),
('CD3', '양말', 1000,'CD'),
('EF1', '사과', 10000,'EF'),
('EF2', '복숭아', 6000,'EF');


# row_number : 값이 같더라도 순위를 다르게 부여한다.
select row_number() over(order by pr_price desc) 순위, pr_code 제품코드, pr_name 제품명, format(pr_price,0) 가격
from product;

# rank : 값이 같으면 순위가 같게, 다음 순위는 연속된 수가 아님
select rank() over(order by pr_price desc) 순위, pr_code 제품코드, pr_name 제품명, format(pr_price,0) 가격
from product;

# dense_rank : 값이 같으면 순위가 같게, 다음 순위는 연속된 수
select dense_rank() over(order by pr_price desc) 순위, pr_code 제품코드, pr_name 제품명, format(pr_price,0) 가격, pr_ca_code '분류명'
from product;

















