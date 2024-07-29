# 분류별 등록된 제품수를 조회하는 쿼리
use shoppingmall;
select
count(case when pr_ca_id = 1 then 1 end) 옷,
count(case when pr_ca_id = 2 then 1 end) 모자,
count(case when pr_ca_id = 3 then 1 end) 신발,
count(case when pr_ca_id = 4 then 1 end) 악세사리,
count(case when pr_ca_id = 5 then 1 end) 기타
from product;

select ca_name 분류명, count(pr_code) 제품수
from product
right join category on ca_id = pr_ca_id
group by ca_id;

select * from product;