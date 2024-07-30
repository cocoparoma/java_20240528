# 분류별 등록된 제품수를 조회하는 쿼리
use shoppingmall;
select
count(case when pr_ca_id = 1 then 1 end) 옷,
count(case when pr_ca_id = 2 then 1 end) 모자,
count(case when pr_ca_id = 3 then 1 end) 신발,
count(case when pr_ca_id = 4 then 1 end) 악세사리,
count(case when pr_ca_id = 5 then 1 end) 기타
from product;

select ca_name 분류명, count(pr_id) 제품수
from product
right join category on ca_id = pr_ca_id
group by ca_id;

select *
from product
join category on ca_id = pr_ca_id
where ca_name = '옷';

# 시원한 이 들어간 제품을 검색
select * from product where pr_name like concat('%', '시원한','%');

# 판매량이 가장 많은 제품들을 조회하는 쿼리 pr_name 제품명
select pr_name 제품명, sum(bu_amonut) 판매량
from buy
left join product on pr_id = bu_pr_id
where bu_state = '구매'
group by pr_name;

select dense_rank() over(order by sum(bu_amonut) desc) 판매순위, product.* ,sum(bu_amonut) 판매량
from product
left join (select * from buy where bu_state in('구매', '구매확정')) B on bu_pr_id = pr_id
group by pr_id;

# 옷 제품 중에서 가격이 높은 순으로 제품을 조회하는 쿼리
select dense_rank() over (order by pr_price desc) as 순위, pr_name 제품명, pr_price 가격
from product
join category on pr_ca_id = ca_id
where ca_name = '옷';

# abc123 회원의 구매 목록 조회
select distinct bu_pr_id
from buy
where bu_me_id = 'abc123' and bu_state in('구매', '구매확정');


# abc1232 회원의 누적 구매 금액 조회
select bu_me_id, format(sum(pr_price * bu_amonut),0) '누적 금액'
from buy
join product on bu_pr_id = pr_id
where bu_me_id = 'abc123' and bu_state in('구매', '구매확정')
group by bu_me_id;

# 회원별 누적 금액 조회
select me_id 회원, ifnull(format(sum(pr_price * bu_amonut),0), 0) '누적 금액'
from member
left join (select * from buy where bu_state in('구매', '구매확정')) b on me_id = bu_me_id
left join product on bu_pr_id = pr_id
group by me_id;

select * from buy
right join member on me_id = bu_me_id;
select * from product;





