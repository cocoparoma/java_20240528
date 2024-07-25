use CGV;
# 데드풀과 울버린 영화의 cgv 강남에서 7/27일에 상영하는 상영 시간표를 조회하는 쿼리
--  sd_time '시간', sd_date '날짜', mo_title '영화 제목', mo_content '설명'
select mo_title '영화 제목', th_name '영화관', sc_name '상영관', sd_date '상영일', sd_time '상영시간'
from schedule
join movie on sd_mo_id = mo_id
join screen on sd_sc_id = sc_id
join theater on sc_th_id = th_id
where sd_sc_id <= 4 and sd_sc_id >= 1 and mo_id = 1 and th_id = 1;

# cgv 강남 1관에 등록된 좌석을 조회하는 쿼리
select sc_name '상영관', se_name '좌석', th_name '극장명'
from screen
join seat on se_sc_id = sc_id
join theater on sc_th_id = th_id
where sc_id = 1 and th_id = 1;
-- mo_title '영화 제목', th_name '극장 이름', sc_name '상영관', sd_time '시간', se_name '좌석 번호' 
# abc123 회원이 예약한 예매 내역을 조회하는 쿼리 (영화제목, 극장이름, 상영관 이름, 시간, 좌석 번호)
select mo_title '영화 제목', th_name '극장 이름', sc_name '상영관', sd_time '시간', se_name '좌석 번호' 
from ticketing
join ticketing_list on ti_id = tl_ti_id
join schedule on sd_id = ti_sd_id
join movie on mo_id = sd_mo_id
join screen on sc_id = sd_sc_id
join theater on th_id = sc_th_id
join seat on sc_id = se_sc_id = tl_se_id
where ti_me_id = 'abc123' and tl_se_id = 1 and tl_ti_id = 1;

# 서브 쿼리를 이용
select * 
from schedule
join screen on sd_sc_id = sc_id
join (select * from theater where th_name = '강남 CGV') th on sc_th_id = th_id
join (select * from movie where mo_title = '데드풀과 울버린') mo on mo_id = sd_mo_id
where sd_date = '2024-07-27';


# 1번 스케줄에 예약된 좌석을 조회하는 쿼리
# join 이용
select se_name '예약된 좌석'
from ticketing_list
join ticketing on tl_ti_id = ti_id
join seat on tl_se_id = se_id
join schedule on sd_id = ti_sd_id
where sd_id = 1;

# sub쿼리 이용
select se_name '예약된 좌석' 
from (select * from ticketing where ti_sd_id = 1) tt
join ticketing_list on ti_id = tl_ti_id
join seat on tl_se_id = se_id;

#1번 상영관에 죄석들을 조회하는 쿼리
# join 이용
select sc_name '상영관', se_name '좌석'
from seat
join screen on sc_id = se_sc_id
where se_sc_id = 1;

# sub쿼리 이용
select sc_name '상영관', se_name '좌석'
from (select * from screen where sc_id = 1) sc
join seat on se_sc_id = sc_id;

# 데드풀과 울버린 cgv강남점 1관 7/27 10:00에 예약 가능한 좌석을 조회하려는 쿼리
# 1번 스케줄에 예약 가능한 1번 상영관 좌석을 조회
# 1번 스케줄에 예약된 스케줄 삭제
select sc_name '상영관', se_name '예약 가능한 좌석'
from seat
join screen on sc_id = se_sc_id
where se_sc_id = 1 and
se_name not in (
select se_name
from (select * from ticketing where ti_sd_id = 1) tt
join ticketing_list on ti_id = tl_ti_id
join seat on tl_se_id = se_id
);

# 1번 스케줄에서 예약 가능한 좌석 수
select count(se_name) '예약 가능한 좌석 개수'
from seat
join screen on sc_id = se_sc_id
where se_sc_id = 1 and
se_name not in (
select se_name
from (select * from ticketing where ti_sd_id = 1) tt
join ticketing_list on ti_id = tl_ti_id
join seat on tl_se_id = se_id
);

select * from movie;

# 장르별 등록된 영화 개수를 조회하려는 쿼리
select ge_name 장르, count(mg_id) '영화 수'
from movie_genre
right join genre on ge_name = mg_ge_name
group by ge_name;

# 개봉한 영화를 조회하는 쿼리
select mo_title '영화 제목', mo_date '개봉 일자'
from movie
where mo_date <= now();

# 한달전 부터 개봉한 영화를 조회하는 쿼리
select mo_title '영화 제목', mo_date '개봉 일자'
from movie
where date_sub(now(), interval 1 month) <= mo_date and mo_date <= now();
-- between 도 가능 

