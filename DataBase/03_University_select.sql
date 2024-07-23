use university;
select * from student;
select * from contact;
select * from course;
select * from lecture;
select * from professor;

# 컴퓨터공학 고길동 학생이 수강 신청한 강의의 개수를 조회하는 쿼리
select st_name, st_major, count(*) "수강 개수" 
from course 
join student on st_id = cs_st_id
where st_id = "고길동" and st_major = "컴퓨터공학";

# 신입생을 조회하는 쿼리
select * from student where st_id like '2024%' and st_grade = 1;

# 각 전공별 학생수를 조회하는 쿼리
select st_major '전공', count(*) '학생수' from student group by st_major;

# 컴퓨터공학 고길동 학생이 수강 신청한 학점을 조회하는 쿼리
select st_name, st_major, sum(lc_point) '학점'
from course 
join student on st_id = cs_st_id
join lecture on cs_lc_id =lc_id
where st_id = "고길동" and st_major = "컴퓨터공학";

# 강의별 수강 신청한 학생수를 조회하는 쿼리
select lc_title, count(cs_st_id) 학생수
from course
join lecture on cs_lc_id = lc_id
group by lc_title;

# 학생이 있는 학과를 조회하는 쿼리
select distinct st_major '학과' from student;
select st_major '학과' from student group by st_major;

# 고길동 학생이 수강하는 강의 목록을 조회하는 쿼리
select st_name '이름', lc_title '과목명'
from course
join student on st_id = cs_st_id
join lecture on lc_id = cs_lc_id
where st_name = '홍길동';

# 김교수가 강의하는 강의명을 조회하는 쿼리
select pf_name '강의자', lc_title '강의명'
from professor
join lecture on lc_pf_id = pf_id
where pf_name = '김교수';




