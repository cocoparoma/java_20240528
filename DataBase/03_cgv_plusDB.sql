use cgv;

# 사용자가 아이디 abc123, 비번 abc123 으로 회원가입을 진행했을 때 사용하는 쿼리
# 권한은 관리자인 경우 'admin', 사용자인 경우 'user'

insert into member(me_id, me_pw, me_authority)
value('abc123','abc123','user');

# 관리자가 아이디 admin1, 비번 admin1 으로 회원가입을 진행했을 때 사용하는 쿼리

insert into member(me_id, me_pw, me_authority)
value('admin1','admin1','admin');

select * from member;

# 영화 정보를 추가하는 작업 (데드풀, 울버린)
# 1. 영화 정보 추가 : 제목, 내용, 시간, 연령대, 개봉일
insert into movie(mo_title,mo_content,mo_time,mo_age,mo_date)
values
(
'데드풀과 울버린',
'히어로 생활에서 은퇴한 후, 평범한 중고차 딜러로 살아가던 ‘데드풀’이 예상치 못한 거대한 위기를 맞아 모든 면에서 상극인 ‘울버린’을 찾아가게 되며 펼쳐지는 도파민 폭발 액션 블록버스터',
'128',
'청소년 관람 불가',
'2024-07-24'
);

# 2. 국가를 등록. 한국, 미국, 영국, 일본, 중국
insert into country(co_name)
values
('한국'),('미국'),('영국'),('일본'),('중국');

# 3. 영화 참여 국가를 추가 : 데드풀과 울버린 영화의 참여 국가
insert into movie_country
values(null,'미국',1);

# 4. 장르를 추가 : 액션, 코미디, 멜로, 공포, 스릴러
insert into genre
values('액션'),('코미디'),('멜로'),('공포'),('스릴러');

# 5. 영화 장르를 추가 : 데드풀과 울버린의 장르
insert into movie_genre values(null, '액션', 1), (null, '코미디', 1);

# 6. 영화인 등록 : 데드풀과 울버린에 나오는 모든 영화인
insert into person
values
(null,'숀 레비','1968-07-28','','캐나다'),
(null,'라이언 레이놀즈','1976-10-23','캐나다 브리티시 컬럼비아 주 밴쿠버에서 식품 도매 상인이었던 아버지와 소매상인이었던 어머니 사이에서 4형제 중 막내로 태어났다. 그중 2명의 형은 경찰인데 한 명은 기마경찰이었다. 가계는 아일랜드 혈통이고 종교는 로마 가톨릭이다. 1994년에 고등학교를 졸업하고, 콴틀란 폴리텍 대학교에 진학하였다가 중퇴하였다.','캐나다'),
(null,'휴 마이클 잭맨','1968-10-12',
'호주의 배우, 가수, 프로듀서.
한국에서는 맨 중의 맨이라는 별명이 있으며, 미국의 피플 매거진에서 2008년 제일 섹시한 남자로 선정됐다. 한국을 자주 찾는 할리우드 배우로 한국 내에서 이미지도 좋은 편이다.
장신, 롱다리, 조각같은 몸매, 미남, 연기 실력, 노래 실력까지 한 몸에 갖추고 있는 완전체이다. 외모의 우월함을 떠나서 자연스럽게 소화할 수 있는 비주얼의 폭이 엄청나게 넓다.
수염을 아무렇게나 기르면 그야말로 한 마리의 야수, 면도하고 차려입으면 점잖은 귀족이 될 수 있는 팔방미인 같은 배우이다. 물론 분장의 힘도 있고 연기력도 한 몫 하겠지만 그러한 요소들이 자연스럽게 어우러지게 만들 수 있는 생김새는 정말 보기 드물다.
인성과 스캔들 논란이 일상인 할리우드에선 찾아보기 힘들 정도로 가정적이며 좋은 인성의 배우로서 평판도 좋다.','호주'),
(null,'엠마루이즈 코린','1995-12-13','영국의 배우.','영국'),
(null,'모레나 시우바 지바스 세타 바카링','1979-06-02','브라질 출신의 미국 여배우. 이국적인 미모로 꽤 인상깊다는 평을 받는다.','브라질'),
(null,'롭 딜레이니','1977-01-19','미국의 남성 코미디언 , 배우 , 작가이다.','미국'),
(null,'레슬리 어검스', '1943-05-25','미국의 여배우.','미국'),
(null,'카란 소니','1989-01-18','인도계 미국인 배우이자 코미디언.','인도'),
(null,'매튜 맥퍼딘','1974-10-17','영국의 배우. 2018년 이후 미국에서도 활동을 시작하였다.','영국');	

# 7. 캐릴터를 등록 : 데드풀과 울버린에 나오는 역할 등록
insert into characher values
(null, '감독', null, '1'),
(null, '배우', null, '2'),
(null, '배우', null, '3'),
(null, '배우', null, '4'),
(null, '배우', null, '5'),
(null, '배우', null, '6'),
(null, '배우', null, '7'),
(null, '배우', null, '8'),
(null, '배우', null, '9');

# 8. 캐스팅을 등록 : 데드풀과 울버린에 나오는 캐릭터들의 캐스팅 이름을 등록. 감독은 감독으로
insert into casting values
(null, '감독', 1, 1),
(null, '데드풀', 2, 1),
(null, '울버린', 3, 1),
(null, '카산드라 노바', 4, 1),
(null, '바네사 칼라일', 5, 1),
(null, '피터', 6, 1),
(null, '플라인드 앨', 7, 1),
(null, '도핀더', 8, 1),
(null, '패러독스', 9, 1);

# 강남 cgv를 등록. 상영관 : 3, 좌석 : 30, 
# 1관 : A1 ~ A3, B1 ~ B3, C1 ~ C4
# 2관 : A1 ~ A4, B1 ~ B4
# 3관 : A1 ~ A2, B1 ~ B2, C1 ~ C2, D1 ~ D2, E1 ~ E2
insert into theater values
(null,'강남 CGV', 3, 30, '서울특별시 강남구 역삼동 814-6 스타플렉스', '서울'),
(null,'영등포 CGV', 4, 44, '영등포', '영등포');

insert into screen values
-- 강남
(null, '1관', 10, 1),
(null, '2관', 10, 1),
(null, '3관', 10, 1),
-- 영등포
(null, '1관', 10, 2),
(null, '2관', 10, 2),
(null, '3관', 12, 2),
(null, '4관', 12, 2);

insert into seat values
(null, 'A1', 1), (null, 'A2', 1), (null, 'A3', 1),
(null, 'B1', 1), (null, 'B2', 1), (null, 'B3', 1),
(null, 'C1', 1), (null, 'C2', 1), (null, 'C3', 1), (null, 'C4', 1);
insert into seat values
(null, 'A1', 2), (null, 'A2', 2), (null, 'A3', 2), (null, 'A4', 2),
(null, 'B1', 2), (null, 'B2', 2), (null, 'B3', 2), (null, 'B4', 2),
(null, 'C1', 2), (null, 'C2', 2);-- ?????  
insert into seat values
(null, 'A1', 3), (null, 'A2', 3),
(null, 'B1', 3), (null, 'B2', 3),
(null, 'C1', 3), (null, 'C2', 3),
(null, 'D1', 3), (null, 'D2', 3),
(null, 'E1', 3), (null, 'E2', 3);


# 영등포 cgv를 등록. 상영관 : 4, 좌석 : 44
# 1관 : A1 ~ A3, B1 ~ B3, C1 ~ C4
# 2관 : A1 ~ A4, B1 ~ B4
# 3관 : A1 ~ A3, B1 ~ B3, C1 ~ C3, D1 ~ D4
# 4관 : A1 ~ A6, B1 ~ B6

insert into seat values
(null, 'A1', 4), (null, 'A2', 4), (null, 'A3', 4),
(null, 'B1', 4), (null, 'B2', 4), (null, 'B3', 4),
(null, 'C1', 4), (null, 'C2', 4), (null, 'C3', 4), (null, 'C4', 4);
insert into seat values
(null, 'A1', 5), (null, 'A2', 5), (null, 'A3', 5), (null, 'A4', 5),
(null, 'B1', 5), (null, 'B2', 5), (null, 'B3', 5), (null, 'B4', 5),
(null, 'C1', 5), (null, 'C2', 5);
insert into seat values
(null, 'A1', 6), (null, 'A2', 6), (null, 'A3', 6),
(null, 'B1', 6), (null, 'B2', 6), (null, 'B3', 6),
(null, 'C1', 6), (null, 'C2', 6), (null, 'C3', 6),
(null, 'D1', 6), (null, 'D2', 6), (null, 'D3', 6);
insert into seat values
(null, 'A1', 7), (null, 'A2', 7), (null, 'A3', 7),
(null, 'A4', 7), (null, 'A5', 7), (null, 'A6', 7),
(null, 'B1', 7), (null, 'B2', 7), (null, 'B3', 7),
(null, 'B4', 7), (null, 'B5', 7), (null, 'B6', 7);
