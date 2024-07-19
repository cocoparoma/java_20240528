# insert
# 한 행(레코드)의 데이터를 추가할 때 사용
# 문법
# insert into 테이블명(속성1, 속성2, ... , 속성 n) value(값1, 값2, ... , 값n);
# value는 한번에 한 행을 추가할 때 사용.
# 속성의 개수가 값의 개수와 같아야 함
# not null에 null을 넣으면 기본값이나 auto_increment가 있으면 +1 값
insert into student.student(studentNum, grade, class, num, name)
value(null, 1, 1, 1, '홍길동');

# insert into 테이블명(속성1, 속성2, ... , 속성 n) values(값1, 값2, ... , 값n), (값1, 값2, ... , 값n);
# value는 한번에 한개 이상의 행을 추가할 때 사용.
# 속성의 개수가 값의 개수와 같아야 함
insert into student.student(grade, class, num, name)
value(1, 1, 2, '엄준식'), (1, 1, 3, '임꺽정');

# insert into 테이블명 value(값1, 값2, ... , 값n);
# 테이블명 앞에 속성명을 생략한 경우 table 생성시 추가했던 속성 순서대로 값을 넣어주어야 함
# 전체 속성 개수만큼 값등르 넣어주어야 함
insert into student.student value(null ,1, 1, 4, '고경식');

# update
# 특정 행들의 값을 변경할 때 사용
# update 테이블명 set 속성명1 = 값1, ... , 속성명n = 값n where 조건
# = : 같다, != 다르다, <> : 다르다
# is null : null 이면, is not null : null이 아니면
# and : ~ 하고, or : ~이거나 (and와 or의 우선순위가 다르다. and가 더 높다.)
# 날짜는 'yyyy-MM-dd hh:mm:ss' 형태의 문자열과 비교 가능. =, >=, <=, != 를 활용할 수 있다.
# (ctrl + B = 자동정렬)
update student set name = '또치' where student.studentNum = 2;

# 워크벤치에서는 안전하게 수정/삭제할 수 있게 하기 위해 기본키가 아닌 조건으로 수정/삭제하려고 하면 수정/삭제 하지 못하도록 막음
# 해결방법 : Edit > Preferences ... > SQL Editor > Safe update check box click
UPDATE student.student 
SET 
    name = '엄준식'
WHERE
    student.grade = 1 and student.class = 1 and student.num = 2;

# delete 특정 행들을 삭제할 때 사용
# delete from 테이블명 where 조건;
delete from student.student where studentNum = 1;

DELETE FROM student.student 
WHERE
    grade = 1 and class = 1 and num = 3;

# delete 와 truncate의 차이
# delete는 데이터만 지우고 설정은 그대로 유지가 된다. - ex > auto_incerment 시작 숫자 유지
# truncate 은 데이터 뿐 아니라 설정도 추기로 돌린다. - auto_increment 숫자가 1에서 시작
# truncate 은 외래키가 있는 경우와 다른 테이블이 참조하고 있는 경우 초기화 되지 않음
delete from student.student;
insert into student.student value(null ,1, 1, 4, '고경식');

insert into student.student value(null, 1, 1, 1, '홍길동');
insert into student.subject value(null, 1, 1, '국어');

insert into student.score value(null, 100, 90, 90, 9, 1);
delete from student.score;
insert into student.score value(null, 100, 90, 90, 9, 1);
# 위 쿼리가 실행되어도 기본키는 초기화 되지않고 기존의 삭제된 마지막 키에서 +1 된 값을 가지게 됨
truncate table student.score;
insert into student.score value(null, 100, 90, 90, 9, 1);
# 위 쿼리가 실행되면 기본키가 1인 데이터가 추가 됨
















