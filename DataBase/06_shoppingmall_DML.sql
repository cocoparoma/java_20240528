use shoppingmall;
# 제품 분류를 등록하는 쿼리
insert into category 
values
	(null, '옷'),
	(null, '모자'),
	(null, '신발'),
	(null, '악세사리'),
	(null, '기타');

# 회원가입하는 쿼리
# id : abc123, pw : abc123, email : abc123@naver.com 번호 : 011-1234-5678
# id : qwe123, pw : qwe123, email : qwe123@naver.com 번호 : 011-1111-2222

insert into member(me_id, me_pw, me_email, me_phone)
values
	('abc123', 'abc123', 'abc123@naver.com', '011-1234-5678'),
	('qwe123', 'qwe123', 'qwe123@naver.com', '011-1111-2222');
    
    
# 제품등록하는 코드
# 분류 : 옷, 코드 CL001, 상품명 : 시원한 티셔츠, 가격 : 20000, 내용 : 시원한 여름용 티셔츠
# 분류 : 옷, 코드 CL002, 상품명 : 시원한 반바지, 가격 : 15000, 내용 : 무더위 여름용 시원한 반바지
# 분류 : 옷, 코드 CL003, 상품명 : 시원한 양말, 가격 : 20000, 내용 : 특수기술의 총합 시원한 양말
insert into product select'CL001', '시원한 티셔츠', '시원한 여름용 티셔츠', 20000, ca_id from category where ca_name = '옷';
insert into product select'CL002', '시원한 반바지', '무더위 여름용 시원한 반바지', 15000, ca_id from category where ca_name = '옷';
insert into product select'CL003', '시원한 양말', '특수기술의 총합 시원한 양말', 20000, ca_id from category where ca_name = '옷';
# 분류 : 모자, 코드 CAP001, 상품명 : 여름 모자, 가격 : 30000, 내용 : 밝은 태양 아래 나만의 파라솔
insert into product select'CAP001', '여름 모자', '밝은 태양 아래 나만의 파라솔', 30000, ca_id from category where ca_name = '모자';
# 분류 : 신발, 코드 SHO001, 상품명 : 썬 크룩스, 가격 : 19999, 내용 : 초 경량화된 요즘 잘나가는 인기짱 신발
insert into product select'SHO001', '썬 크룩스', '초 경량화된 요즘 잘나가는 인기짱 신발', 19999, ca_id from category where ca_name = '신발';
# 분류 : 악세사리, 코드 ACC001, 상품명 : 금 목거리, 가격 : 100000, 내용 : GOLD 그 자체 밝은 빛 아래 찬란이 빛나는 황금
insert into product select'ACC001', '금 목거리', 'GOLD 그 자체 밝은 빛 아래 찬란이 빛나는 황금', 100000, ca_id from category where ca_name = '악세사리';


select * from product;

