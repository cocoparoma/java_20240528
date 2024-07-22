# 1학년 1반 2번 둘리 학생 추가
insert into student.student(studentNum, grade, class, num, name) value(null, 1, 1, 2, '김춘식');
# 1학년 1학기 영어 과목 추가
insert into student.subject(num, grade, semester, name)value(null, 1, 1, '영어');
# 1학년 1학기 수학 과목 추가
insert into student.subject(num, grade, semester, name)value(null, 1, 1, '수학');
# 2개 합쳐서
# insert into student.subject(grade, semester, name)values(1, 1, '영어'), (1, 1, '수학'); --도 가능하다
#num, midTerm, finalTerm, preformance, studentNum, subjectNum
# 1학년 1반 1번 학생의 영어 성적 추가(중간 : 80, 기말 : 100, 수행 : 100)
insert into student.score(midTerm, finalTerm, preformance, studentNum, subjectNum)
values(80,100,100,1,2);
# 1학년 1반 1번 학생의 수학 성적 추가(중간 : 100, 기말 : 100, 수행 : 80)
insert into student.score(midTerm, finalTerm, preformance, studentNum, subjectNum)
values(100,100,80,1,3);
##

# 1학년 1반 2번 학생의 국어 성적 추가(중간 : 50, 기말 : 100, 수행 : 80)
insert into student.score(midTerm, finalTerm, preformance, studentNum, subjectNum)
values(50,100,80,2,1);
# 1학년 1반 2번 학생의 영어 성적 추가(중간 : 100, 기말 : 100, 수행 : 100)
insert into student.score(midTerm, finalTerm, preformance, studentNum, subjectNum)
values(100,100,100,2,2);
# 1학년 1반 2번 학생의 수학 성적 추가(중간 : 50, 기말 : 50, 수행 : 50)
insert into student.score(midTerm, finalTerm, preformance, studentNum, subjectNum)
values(50,50,50,2,3);

# 2학년 1반 1번 고길동 추가
# 3학년 1반 1번 나둘리 추가
insert into student.student(studentNum, grade, class, num, name)
values (3, 2, 1, 1, '고길동'), (4, 3, 1, 1, '나둘리');
# 1학년 1반 1번 나둘리 추가
insert into student.student(studentNum, grade, class, num, name)
value (5, 1, 2, 1, '유제석');


