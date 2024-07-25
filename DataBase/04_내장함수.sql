# 문자열 함수
# 길이 관련 함수
# length(문자열) : 문자열의 바이트 수를 반환한다.
select length('안녕'); # 6 바이트
select length('12'); # 2 바이트

# char_length(문자열) : 문자열의 길이를 반환한다
select char_length('안녕'); # 길이 2
select char_length('12'); # 길이 2

# concat(문자열1, ... ,문자열n) : 문자열들을 이어서 하나의 문자열로 만든다
select concat('안녕','하','세요');

# field(찾을 문자열, 문자열 1, 문자열 2, ...) : 문자열들에서 찾을 문자열이 몇번째 있는지 반환한다.
# 1부터 시작하며 없으면 0을 반환한다
select field('안녕', '안녕하세요', '안녕1');

# instr(문자열1, 문자열2) : 문자열 1에서 문자열 2가 몇번째 부터 시작하는지 반환한다. 없으면 0을 반환한다
select instr('안녕하세요', '안녕');
select instr('안녕하세요', '안녕1');

# locate(문자열2, 문자열1) : 문자열 1에서 문자열 2가 몇번째 부터 시작하는지 반환한다. 없으면 0을 반환한다
select locate( '안녕','안녕하세요');
select locate( '안녕1','안녕하세요');


# format(숫자, 소수점 자리 수 ) : 숫자를 소수점 자리수까지 표현한다. 3 자리마다 , 를 축라한다.
select format(12345678.12345678,2);

# bin(숫자) : 2진수, oct (숫자) : 8진수, hex(숫자) : 16진수
select bin(31), oct(31), hex(31);

# lpad(문자열, 자리, 채울 문자열) : 문자열이 자리수보다 작으면 왼쪽에 채울 문자열을 추가하여 자리수를 맞춘다.
select lpad(hex(3),2,0);

# rpad(문자열, 자리, 채울 문자열) : 문자열이 자리수보다 작으면 오른쪽에 채울 문자열을 추가하여 자리수를 맞춘다.
select rpad();

#rgb(255,20,30)
select hex(255), hex(20), hex(3);
select concat('#', lpad(hex(255),2,0),  lpad(hex(20),2,0),  lpad(hex(3),2,0)) 'rgb (255,20,3)';

# insert(문자열, 위치, 길이, 대체문자열) : 문자열에서부터 위치까지 길이만큼 문자열을 제거 후 대체 문자열을 추가한다.
select insert('누구나 하는 C', 8, 1, 'java');
# replace(문자열, 교체할 문자열, 대체할 문자열)
select replace('c의 정석', 'c', 'JAVA');
# upper(), lower() : 대문자로, 소문자로 교체한다.
select upper('hi'), lower ('HI');
#reverse(문자열) : 문자열을 역순으로 배치한다
select reverse('abcdefg');
#repeat(문자열, 횟수) : 문자열을 횟수만큼 반복
select repeat('hi!', 3);


# 부분 문자열 추출
# left(문자열, 숫자) : 믄지열에서 왼쪽부터 숫자만큼 문자열을 반환 한다.
# right(문자열, 숫자) : 문자열에서 오른쪽부터 숫자만큼 문자열을 반환 한다.
select left('test.jpg', 4), right ('test.jpg', 3);

# substring(문자열, 시작위치, 길이) : 문자열에서 시작위치 부터 길이만큼 문자열을 반환한다.
select substring('test.jpg',1,4), substring('test.jpg',6,3);

# 시간함수
# now()/sysdate()/current_timestamp() : 현재 시간을 반환한다.
# current_timestamp() 는 속성의 타입이 datetime인 경우, 기본값으로 현재시간을 추가하도록 설정할 수 있다.
select now(),sysdate(),current_timestamp();

# adddate(시간, 차이)/subdate(시간, 차이) : 시간에서 차이만큼 더한/뺀 값을 계산한다.
select adddate(now(), 2), subdate(now(),2);

# addtime(시간, 차이)/sumtime(시간, 차이) : 시간에서 차이만큼 시간(시, 분, 초)을 더한/뺀 값을 계산한다.
select addtime(now(), '2:00:00'), subtime(now(),'2:00:00');

# year(시간) : 시간에서 년을 추출한다.
# month(시간) : 시간에서 월을 추출한다.
# day(시간) : 시간에서 일을 추출한다.
select year(now()), month(now()), day(now());

# hour() : 시간에서 시을 추출한다.
# minute() : 시간에서 분을 추출한다.
# second() : 시간에서 초을 추출한다.
# microsecond() : 시간에서 미리미초를 추출한다.
select hour(now()), minute(now()), second(now());
select microsecond('2018-07-15 14:10:10.123');

# date(시간) : 년-월-일 형태를 추출한다.
# time(시간) : 시:분:초 형태를 추출한다.
select date(now()), time(now());

# datediff(시간1, 시간2) : 시간1에서 시간2의 차이를 일로 반환한다. 시간1 - 시간2
# timediff(시간1, 시간2) : 시간1에서 시간2의 차이를 시:분:초로 변환한다. 시간1 - 시간2
select datediff(now(), '2024-07-27 10:00:00');
select timediff('11:00', '09:00');
select timediff(now(), '2024-07-27 10:00:00');

# date_add(시간, interval) : 시간에서 in ter val 만큼 더한 시간.
# date_sub(시간, interval) : 시간에서 in ter val 만큼 뺀 시간.
/*
interval 의 종류
- 단일 시간 유형 : 한 종류의 단위를 나타냄
- year, month, day, hour, second, microsecond, quater(분기), week(주)
- 복합 시간 유형 : 여러 종류의 단위를 한번에 나타냄
- year_month : 년 월
- day_hour : 일 시간
- day_minute : 일 시간 : 분
- day_microsecond : 일 시간 : 분 :초 . 마이크로 초
*/
select date_add(now(), interval 1 month);
select date_sub(now(), interval '1 1' year_month);

# 수학 함수
# floor(숫자) : 소수점 첫번째 자리 내림.
# ceil(숫자) : 소수점 첫번째 자리 올림.
# round(숫자) : 소수점 첫번째 자리 반올림.
# abs(숫자) : 절대값
select floor(1.23), ceil(1.23), round(1.23), abs(-2);

# 윈도우 함수 (대체적으로 순위를 표기하기 위해 사용된다.)







