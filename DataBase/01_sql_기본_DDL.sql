# 데이터베이스 생성
# if not exists : 생성하려는 DB가 있는경우 건너뛰기
# if not exists가 없는데 생성하려는 DB가 있는경우 에러가 발생해서 이후 sql 문이 작동하지 않음
# mySQL 에서는 database == schema
# create database if not exists DBname
# 워크벤치에서 Schemas 아래 공백에 우클릭 후 Create Schema 클릭 후 DBname 입력 후 APPLY
# create database if not exists world;
# create database if not exists sakila;
# create database if not exists student;

# 데이터베이스 삭제
# drop database if exists DBname 있다면 삭제
# drop schema if exists DBname 있다면 삭제
# 워크 스페이스에서 DBname 우클릭 DROP schemas... 클릭 후 Drop Now 클릭

-- drop database if exists student;

# 데이터 베이스 수정 - 이름은 수정이 안됨. 문자 집합을 수정
# ALTER SCHEMA DBname 기본문자집합 바꿀문자집합 기본COLLATE 바꿀COLLATE;
# 워크스페이스에서 DBname 호버하고 2번째 아이콘 클릭 후 원하는 문자집합과 collate를 선택 후 apply

# 테이블 추가
/*
CREATE TABLE if NOT EXISTS 테이블 명(
	컬럼명 타입 [zerofill][unique][not null | null][default 기본값][promary key][auto_increment],
    컬럼명 타입 [zerofill][unique][not null | null][default 기본값][promary key][auto_increment],
    ...,
    제약조건,
    constraint 제약조건명 primary key(컬럼명),
    #< == primary key(컬럼명) 즉 제약조건명 생략 가능 >
    constraint 제약조건명 foreign key(컬럼명) references 참조테이블(기본키),
    #< == foreingn key(컬럼명) references 참조테이블(기본키) >
    constraint 제약조건명 check(논리식),
    #< == check(논리식) >
	)
*/
# 워크벤치에서 tables 우클릭 create table 클릭 후 속성과 옵션 선택후 적용
# auto_increment
use student;

drop table if exists student;
create table if not exists student(
	`studentNum` int primary key auto_increment,
    `grade` int not null,
    `class` int not null,
    `num` int not null,
    `name` varchar(20) not null,
    check(grade >= 1 and grade <= 3),
    check(class >= 1),
    check(num >= 1),
    check(char_length(`name`) >= 2));

drop table if exists student.subject;
CREATE TABLE if not exists `student`.`subject` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `grade` INT NOT NULL DEFAULT 1,
  `semester` INT NOT NULL DEFAULT 1,
  `name` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`num`));

drop table if exists student.score;
create table if not exists `student`.`score`(
	`num` int primary key auto_increment,
    `midTerm` int not null default 0,
    `finalTerm` int not null default 0,
    `preformance` int not null default 0,
    `studentNum` int not null,
    `subjectNum` int not null,
    foreign key(`studentNum`) references student(studentNum) on delete cascade,
    foreign key(`subjectNum`) references subject(num) on delete cascade);

# 테이블 삭제
# drop table if exists 테이블명;


# 테이블 수정 - 컬럼 추가
# alter table 테이블명 add 컬럼명 타입[zerofill][unique][not null | null][default 기본값][promary key][auto_increment];
alter table student.score add test int not null;

# 테이블 수정 - 컬럼 수정
# alter table 테이블명 change 컬럼명 타입[zerofill][unique][not null | null][default 기본값][promary key][auto_increment];
alter table student.score change test totalScore int not null default 0;

# 테이블 수정 - 컬럼 삭제
# alter table 테이블명 drop 컬럼명;
alter table student.score drop totalScore;

# 테이블 수정 - 제약조건 추가
# alter table 테이블명 add constraint 제약조건명 제약조건;
alter table student.score add constraint aa check(midTerm >= 0 and  midTerm <= 100);

# 테이블 수정 - 제약조건 삭제
# alter table 테이블명 drop constraint 제약조건명;
alter table student.score drop constraint aa;




























