use shoppingmall;

# 모든제품을 조회하는 쿼리
select * from product;

# 금액이 1만원 이상인 제품을 조회하는 쿼리
select * from product where pr_price >= 10000;

# 제품에 시원한이들어간 제품을 조회하는 쿼리
select * from product where pr_name like concat( '%' ,'시원한' ,'%' );

# 카테고리가 옷인 제품을 조회하는 쿼리
select * from product
join category on pr_ca_id = ca_id
where ca_name = "옷";

# 금액과 제품명을 이용해서 검색하는 쿼리를 일반화 해서 만들어 보세요 // 일반화
select * from product 
where pr_name like concat( '%' ,'모자' ,'%' ) and pr_price >= 20000;

# 추가적으로 카테고리도 고려해야 할 경우
select * from product 
where pr_name like concat( '%' ,'시원한' ,'%' ) and pr_price >= 20000 and pr_ca_id = 1;

# 카테고리별 제품의 평균가격을 조회하는 쿼리
select ca_name 카테고리, sum(pr_price) 총합, count(pr_price) 개수 , avg(pr_price) 평균  from product 
join category on pr_ca_id = ca_id group by ca_name;
# 또는
select ca_name, format(ifnull(avg(pr_price), 0), 0) 평균가 from category
left join product on pr_ca_id = ca_id
group by ca_id;

# 카테고리별 제품의 평균 가격이 3만원 이상인 카테고리를 조회
select ca_name, format(ifnull(avg(pr_price), 0), 0) 평균가 from category
left join product on pr_ca_id = ca_id
where (select avg(pr_price) from category) >= 30000
group by ca_id;
# 또는
select ca_name, format(ifnull(avg(pr_price), 0), 0) 평균가 from category
left join product on pr_ca_id = ca_id
group by ca_id
having ifnull(avg(pr_price),0) >= 30000;

# 카테고리별 등록된 제품 개수를 조회
select ca_name 제품명 , ifnull(count(pr_ca_id), 0) 개수 from category
left join product on pr_ca_id = ca_id
group by ca_id;

# 'abc123' 회원이 구매한 제품 정보를 조회
select product.* from member
join buy on me_id = bu_me_id
join product on pr_id = bu_pr_id
where me_id = 'abc123' and bu_state in('구매', '구매 확정');


# 'abc123' 회원의 누적 구매 금액을 조회
select format(sum(bu_amonut * pr_price) , 0) '누적 구매 액' from member
join buy on me_id = bu_me_id
join product on pr_id = bu_pr_id
where me_id = 'abc123' and bu_state in('구매', '구매 확정');

# 'abc123' 회원이 장바구니에 1번 제품 3개를 담았을 때 쿼리
insert into basket(ba_pr_id, ba_me_id, ba_acunt) values ('CL001', 'abc123',3);
# 'abc123' 회원이 장바구니에 1번 제품 2개를 담았을 때 쿼리
update basket set ba_acunt = 2 where ba_me_id = 'abc123' and ba_pr_id = 'CL001';

#  'abc123' 회원이 장바구니 제품을 구매하였을 때 쿼리
insert into buy(bu_pr_id, bu_me_id, bu_amonut, bu_state)
select ba_pr_id, ba_me_id, ba_acunt from basket where ba_id = 5;
# 또는 
insert into buy(bu_pr_id, bu_me_id, bu_amonut, bu_state, bu_date) values('CL001','abc123',2,'구매', now());
delete from basket where ba_pr_id = 'CL001' and ba_me_id = 'abc123';

select * from basket;
select * from buy;
