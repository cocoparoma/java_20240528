use cgv;
select * from genre;
# cgv 등록된 모든 영화를 조회하는 쿼리
select * from movie;
# cgv 등록된 모든 영화를 조회하는 쿼리 + 장르도 함께
select * from movie_genre
join genre on ge_name = mg_ge_name
join movie on mg_mo_id = mo_id;

# 장르가 액션인 영화를 조회하는 쿼리
select * from movie_genre
join genre on ge_name = mg_ge_name
join movie on mg_mo_id = mo_id
where mg_ge_name = "액션";
# 또는
select * from movie where mo_id in (select mg_mo_id from movie_genre where mg_ge_name = "액션");

# 장르가 액션으로 등록된 영화 수를 조회하는 쿼리
select count(*) "액션인 영화 수" from movie
join movie_genre on mg_mo_id = mo_id
where mg_ge_name = "액션";
# 또는 
select mg_ge_name, count(mg_mo_id) from movie_genre where mg_ge_name = "액션" group by mg_ge_name;

# 모든 장르에 등록된 영화 수를 조회하는 쿼리(단, 영화가 등록되지 않은 장르들은 조회가 x)
select mg_ge_name, count(mg_mo_id) from movie_genre group by mg_ge_name;

# 모든 장르에 등록된 영화 수를 조회하는 쿼리(단, 영화가 등록되지 않은 장르들은 조회가 o)
select ge_name, count(mg_mo_id) from movie_genre 
right join genre on mg_ge_name = ge_name
group by ge_name;

# 등록된 영화를 이름순으로 6개 조회하는 쿼리 (내림차순, 1페이지)
select * from movie order by mo_title desc limit 0, 6;
# 등록된 영화를 이름순으로 6개 조회하는 쿼리 (내림차순, 2페이지)
select * from movie order by mo_title desc limit 6, 6;

# 데드풀과 울버린을 관람한 관객 수를 조회하는 쿼리
select '데드풀과 울버린' 영화제목, sum(ti_adult + ti_teenager) from ticketing join schedule on ti_sd_id = sd_id
where sd_mo_id = (select mo_id from movie where mo_title = '데드풀과 울버린') group by sd_mo_id;

# 영화별 관객수를 조회하는 쿼리
select mo_title 영화제목, sum(ti_adult + ti_teenager) 관객수 from ticketing
right join schedule on ti_sd_id = sd_id
right join movie on sd_mo_id = mo_id
group by mo_id;

# 데드풀과 울버린 영화 상영기간을 조회하는 쿼리
select * from schedule
where sd_mo_id in(select mo_id from movie where mo_title = "데드풀과 울버린");

# 데드풀과 울버린 영화 상영 기간을 조회하는 (7/27 오후를 기준)
select * from schedule
where sd_mo_id in(select mo_id from movie where mo_title = "데드풀과 울버린")
and sd_date = '2024-07-27' and sd_time > '12:00:00';

# 2번 상영시간에 예약된 좌석을 조회하는 쿼리
	select se_name from ticketing_list
    join ticketing on tl_ti_id = ti_id
    join seat on tl_se_id = se_id
    where ti_sd_id = 2;

# 2번 상영시간에 예약 가능한 좌석을 조회하는 쿼리
select se_name from schedule
join screen on sd_sc_id = sc_id
join seat on sc_id = se_sc_id
where sd_id = 2 and se_name not in(
	select se_name from ticketing_list
    join ticketing on tl_ti_id = ti_id
    join seat on tl_se_id = se_id
    where ti_sd_id = 2
);

# 휴잭맨이 참여한 영화 목록을 조회하는 쿼리
select mo_title ,ps_name from movie
join casting on ca_mo_id = mo_id
join characher on ch_id = ca_ch_id
join person on ch_ps_id = ps_id
where ps_name = '휴 마이클 잭맨';


# cgv 강남에서 상영 했거나, 상영중, 상영 에정인 영화들을 조회하는 쿼리
select distinct mo_title from movie
join schedule on sd_mo_id = mo_id
join (select * from screen where sc_th_id = (select th_id from theater where th_name = '강남 CGV')) sc on sd_sc_id = sc_id;







