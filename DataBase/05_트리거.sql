# 트리거
use cgv;

# 상영시간에 예약 가능한 초기 좌석 수를 상영관 좌석수로 수정
update schedule join screen on sc_id = sd_sc_id
set sd_possible = sc_seat;

select * from schedule;

# 예약된 좌석만큼 상영시간에서 예약 가능한 좌석수를 빼서 수정하는 쿼리

# 1번 스케줄에 예매된 좌석 수 만큼 1번 스케줄의 좌석을 수정하는 쿼리
update schedule
set sd_possible = sd_possible - (select sum(ti_adult+ti_teenager) from ticketing where ti_sd_id)
where sd_id = 1;

# 예매가 발생하면 예매한 상영에서 예약 가능한 좌석수를 수정하는 트리거
drop trigger if exists update_sd_possible;
delimiter $$
	create trigger update_sd_possible
    after insert on ticketing
    for each row
begin
    
    update schedule
	set sd_possible = sd_possible - (new.ti_adult + new.ti_teenager)
    where sd_id = new.ti_st_id;

end $$
delimiter ;

	# 예매된 성인수와 청소년수만큼 좌석수를 수정 
    UPDATE 
		SCHEDULE
	SET
		SD_POSSIBLE = SD_POSSIBLE - (NEW.TI_ADULT + NEW.TI_TEENAGER)
	WHERE
		SD_NUM = NEW.TI_SD_NUM;
END //
DELIMITER ;

INSERT INTO TICKETING VALUES(NULL, 2, 2, 48000, 'abc123', 2);
INSERT INTO TICKETING_LIST VALUES(NULL, 2, 1),(NULL, 2, 2),(NULL, 2, 3),(NULL, 2, 4);

# 등록된 트리거 조회
SHOW TRIGGERS;









