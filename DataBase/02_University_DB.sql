#DB delete(University)
drop database if exists university;
#DB create(University)
create database if not exists university;
use university;

#student table delete
drop table if exists student;
#student table create
create table if not exists student(
	st_id char(10) primary key,
    st_name varchar(20) not null,
    st_major varchar(15) not null,
    st_grade int not null default 1
    );

#professor table delete
drop table if exists professor;
#professor table create
create table if not exists professor(
	pf_id char(10) primary key,
    pf_name varchar(20) not null,
    pf_major varchar(15) not null,
    pf_room varchar(100)
    );

#lecture table delete
drop table if exists lecture;
#lecture table create
create table if not exists lecture(
	lc_id int primary key auto_increment,
    lc_title varchar(30) not null,
    lc_major varchar(5) not null,
    lc_room varchar(100),
    lc_schedule varchar(50),
    lc_point int,
    lc_time int,
    lc_pf_id char(20),
    foreign key (lc_pf_id) references professor(pf_id)
    );

#course table delete
drop table if exists course;
#course table create
create table if not exists course(
	cs_id int primary key auto_increment,
    cs_mid int default 0,
    cs_final int default 0,
    cs_perform int default 0,
    cs_homework int default 0,
	cs_total varchar(2)  default 'F',
    cs_attendance int default 0,
    cs_st_id char(10),
    cs_lc_id int,
    foreign key (cs_st_id) references student(st_id),
    foreign key (cs_lc_id) references lecture(lc_id)
);

#contact table delete
drop table if exists contact;
#contact table create
create table if not exists contact(
	ct_id int primary key auto_increment,
    ct_address varchar(100) not null,
    ct_detail_address varchar(100),
    ct_phone_number varchar(13) not null,
    ct_st_id char(10) not null,
    foreign key (ct_st_id) references student(st_id)
);








