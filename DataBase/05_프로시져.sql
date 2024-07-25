use university;
# 학과 코드, 이름, 전공이 주어졌을 때 신입생을 등록하는 프로시저

drop procedure if exists insert_freshman;
delimiter //
create procedure insert_freshman(
	in _major_code char(3),
	in _major varchar(15),
    in _name varchar(30)
)
begin
	declare _year int;
    declare _num char(3);
    declare _st_num char(10);
    
    set _year = (select year(now()));
    set _num = (select lpad(count(*)+1,3,'0' ) from student where st_major = _major);
    set _st_num = (select concat(_year, _major_code, _num));
    # 학번을 생성 year + 학과 코드 + 순서
    # 프로시저가 실행될 때 년도를 가져옴
    # declare 변수명 = 변수선언
    insert into student values (_st_num, _name, _major, 1);
    
end //
delimiter ;

select year(now());
select count(*)+1 from student where st_major = '컴퓨터공학';
select lpad(6,3,'0');

select * from student;
call insert_freshman('160', '컴퓨터공학', '우콩');

 # *** *** *** *** ***

drop procedure if exists update_point;
delimiter //
create procedure update_point(
	in _co_st_num char(10),
	in _co_le_num int,
    in _co_mid int,
    in _co_final int,
    in _co_homework int,
    in _co_attendance int
)
begin
	declare _point varchar(2);
	declare _co_total int;
    
    set _co_total = _co_mid * 0.4 + _co_final*0.4 + _co_homework*0.1 + _co_attendance * 0.1;

	if _co_total >= 95 then
		set _point = 'A+';
	elseif _co_total >= 90 then
		set _point = 'A';
	elseif _co_total >= 85 then
		set _point = 'B+';
	elseif _co_total >= 80 then
		set _point = 'B';
	elseif _co_total >= 75 then
		set _point = 'C+';
	elseif _co_total >= 70 then
		set _point = 'C';
	elseif _co_total >= 65 then
		set _point = 'D+';
	elseif _co_total >= 60 then
		set _point = 'D';
	else set _point = 'F';
    end if;

	update course
    set
		co_mid = _co_mid,
        co_final = _co_final,
        co_homework = _co_homework,
        co_attendance = _co_attendance,
		co_total = _point
	where
		co_st_num = _co_st_num and co_le_num = _co_le_num;
    
end //
delimiter ;

call update_point('2024160005', 1, 100, 100, 100, 100);
call update_point('2024160005', 2, 90, 80, 70, 50);

# 프로시저 확인
show procedure status;

# 프로시저 스크립트 확인
show create procedure insert_freshman;

-- 강사님버전 
USE CGV;
# 예매자 아이디, 예매 상영시간번호, 성인수, 청소년수가 주어지면 티켓을 예매하는 프로시저를 생성하고 테스트 
DROP PROCEDURE IF EXISTS TICKETING;

DELIMITER //
CREATE PROCEDURE TICKETING(
	IN _ID VARCHAR(15), 
    IN _SD_NUM INT,
    IN _ADULT INT,
    IN _TEENAGER INT
)
BEGIN
	DECLARE _ADULT_PRICE INT;
    DECLARE _TEENAGER_PRICE INT;
    DECLARE _MORNING INT;
    
    # 조조영화여부를 가져옴(1:조조, 0:아님)
    SET _MORNING = (SELECT SD_EARYLY FROM SCHEDULE WHERE SD_NUM = _SD_NUM);
    CASE _MORNING 
		WHEN 1 THEN
			SET _ADULT_PRICE = (SELECT PR_PRICE * _ADULT FROM PRICE WHERE PR_TYPE = '조조 성인');
            SET _TEENAGER_PRICE = (SELECT PR_PRICE * _TEENAGER FROM PRICE WHERE PR_TYPE = '조조 청소년');
        ELSE
			SET _ADULT_PRICE = (SELECT PR_PRICE * _ADULT FROM PRICE WHERE PR_TYPE = '성인');
            SET _TEENAGER_PRICE = (SELECT PR_PRICE * _TEENAGER FROM PRICE WHERE PR_TYPE = '청소년');
	END CASE;
	INSERT INTO TICKETING 
    VALUES(NULL, _ADULT, _TEENAGER, _ADULT_PRICE + _TEENAGER_PRICE, _ID, _SD_NUM);
END //
DELIMITER ;

CALL TICKETING('abc123', 3, 3, 0);









