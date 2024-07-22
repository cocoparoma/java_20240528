/*
기본 검색
- 테이블에 있는 모든 행(레코드)을 검색
- 단 워크벤치 설정에 따라 최대 갯수가 조절 될 수 있다.
select * from 테이블명
*/
# 모든 학생을 조회
SELECT * FROM student.student;
SELECT * FROM student.score;
SELECT * FROM student.subject;

/*
조건 검색
- 테이블에 있는 행 중에서 조건을 만족하는 행을 조회
select * from 테이블명 where 조건
*/
# 증간고사 성적이 90을 넘는 학생을 조회
SELECT * FROM student.score WHERE midTerm >= 90;

# 과목 중 한 과목이라도 중간 고사 성적이 90 점 이상인 학생들의 번호를 조회
# distinct : 중복 제거
SELECT distinct studentNum FROM student.score WHERE midTerm >= 90;

/*
비교 연산자
 = : 같다
 <> , != : 같지 않다
 between a and b : a 이상 b이하
 not between a and b : a 미만 , b 초과
 속성명 in (값1, ... , 값n) : 특정 값 목록에 속할 때 참
 => (속성 = 값1 or 속성2 = 값2 ... 속성n = 값n)
 속성명 not in (값1, ... , 값n) : 특정 값 목록에 속하지 않을 때 참
 like 'pattern' : 패턴과 일치하는 값을 조회할 때 사용
 - _ : 한 글자 ex> '___' : 3글자 의미
 - % : 0글자 이상 ex> '홍%' : 첫글자가 홍으로 시작되는 모든 문장들
 not like 'pattern' : 패턴과 일치하지 않는 값을 조회할 때 사용
 is null : null 이면 참
 is not null : null 이 아니면 참
*/

/*
속성명 between a and b : 속성의 값이 a ~ b 사이
속성명 in(a, b, ... ,z) : 속성의 값이 a 이거나 b 이거나 ... z 인 행을 조회
속성명 like 'pattern' : 속성의 값이 패턴과 일치하는 행을 조회
- ' _ ' : 한글자
- ' % ' : 0글자 이상
*/
# 성이 홍씨는 학생들을 조회
select * from student.student where name like '홍%';
# 이름이 외자 학생 조회
select * from student.student where name like '__';
# 1 ~ 2 학년을 조회
select * from student.student where grade >= 1 and grade <= 2;
select * from student.student where grade between 1 and 2;
select * from student.student where grade in (1, 2);
# 이름에 '길' 이 포함된 학생 조회 + concat = 문자열을 합해주는 함수
select * from student.student where name like '%길%';
select * from student.student where name like concat('%', '길', '%');

/*
select[distinct]
	속성명1, ... , 속성명n
from 테이블명
[where 조건]
[order by 속성명1[asc | desc],속성명2[asc | desc] ]
- asc : 내림차순
- desc : 오름차순
*/
select * from student.student order by grade desc, class, num asc;

/*
select[distinct]
	속성명1, ... , 속성명n
from 테이블명
[where 조건]
[order by 속성명1[asc | desc]]
[limit (시작번지), 개수]
*/
select * from student.student limit 2;

# 학생 조회 페이지가 있고, 학생, 학년, 반, 번호를 오름차순으로 정렬할 때 2명이 1페이지 일때
# page 1
select * from student.student order by grade , class , num  limit 0, 2;
# page 2
select * from student.student order by grade , class , num  limit 2, 2;
# page 3
select * from student.student order by grade, class, num limit 4, 2;

/*
select 그룹화 : 레코드를 그룹으로 묶어서 처리할 때 사용
# 예제 : https://gent.tistory.com/505
#
select (field-name) 
from (table-name)
where condition
group by 속성명[, 속성명2, ...] 
having condition
[order by ...]
[limit ...]

집계함수를 사용하기 위해선 having 절 에 넣어주어야 함
having : 그룹화 한 후 집계함수를 이용하여 조건을 걸 때 사용

# 집계함수 : ()괄호 안 속성명
count() : 개수를 계산할 때 사용
sum() : 합 계산
avg() : 평균을 계산
min() : 해당 속성 값중 최소값
max() : 해당 속성 값중 최대값
*/
select grade, count(grade) from student.student group by grade;

/*
as : 조회시 속성 이름수정하기 + 생략 가능
select column1, ... as column1-1, ... from (table-name);
select column1, ... column1-1, ... from (table-name);
# 특수문자가 들어가는 경우 따옴표가 요구됨
*/

select grade as 학년, count(grade) '수(명)' from student.student group by grade;

select grade as 학년, count(grade) '수(명)' from student.student group by grade having count(grade)>=2;

/*
join : 2개 이상의 테이블을 묶어서 하나의 결과 테이블을 만드는 것
inner join
- 두 집합의 교집합
- join () on ()
outer join
- 두 집합의 합집합
- left|right outer join ()
- () 기준으로 왼쪽, 오른쪽
- null 이 입력될 수 있음
self join
- 자기 자신과 join 
*/

SELECT 
    student.*,
    AVG(midTerm * 0.4 + finalTerm * 0.5 + preformance * 0.1) 성적
FROM
    student.score
join
	student.student
    on
		score.studentNum = student.studentNum
GROUP BY studentNum;

# 각 학생의 각 과목 성적을 조회 (성적이 등록된 학생만)

SELECT 
student.grade 학년, class 반, student.num 번호, student.name 이름,
subject.grade 학년, semester 학기, subject.name 과목명, 
midTerm 중간, finalTerm 기말, preformance 수행평가
from student.score
join student.student on score.studentNum = student.studentNum
join student.subject on score.studentNum = subject.num;

# 각 학생의 각 과목 성적을 조회 (성적되지 않은 학생까지)

SELECT 
student.grade 학년, class 반, student.num 번호, student.name 이름,
subject.grade 학년, semester 학기, subject.name 과목명, 
midTerm 중간, finalTerm 기말, preformance 수행평가
from student.score
right join student.student on score.studentNum = student.studentNum
left join student.subject on score.studentNum = subject.num;
# null 이 있어도 출력

/*
join using
 - on 속성을 대신할 수 있음 on tableA.attrAname = tableB.attrAname
 - from schema.tableA
 - join schema.tableB using (attrAname)
 - 테이블 속성명이 같은경우 사용 가능

*/

SELECT 
student.grade 학년, class 반, student.num 번호, student.name 이름,
subject.grade 학년, semester 학기, subject.name 과목명, 
midTerm 중간, finalTerm 기말, preformance 수행평가
from student.score
right join student.student using (studentNum) # 같은 속성명을 사용할때 묶어줌
left join student.subject on score.studentNum = subject.num;

# 등록된 전체 학생수를 조회
select count(student.student.name) '전체학생 수' from student.student;

# 학생들의 국어 성적을 조회
SELECT 
student.grade 학년, class 반, student.num 번호, student.name 이름,
subject.grade 학년, semester 학기, subject.name 과목명, 
midTerm 중간, finalTerm 기말, preformance 수행평가
from student.score
join student.student using (studentNum) # 같은 속성명을 사용할때 묶어줌
left join student.subject on score.studentNum = subject.num
where score.subjectNum = 1;









