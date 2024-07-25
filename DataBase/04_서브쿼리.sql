use product;
# any, some, in, all 은 서브쿼리와 함께 사용된다.
# 속성 비교 ANY(값1, 값2, ... 값n), 속성 비교 some(값1, 값2, ... 값n)

# 속성 비교 any(서브쿼리)
# 값들 중 하나 이상의 값들을 만족할 때 사용된다.

# 속성 in(값1, 값2, ... 값n)
# 속성 in(서브쿼리)
# in 은 = any 와 같음
# 속성값이 값1, 값2, ... , 값n 중에 있으면 참


# 속성 비교 all(값1, 값2, ... 값n)
# 속성 비교 all(서브쿼리)
# 속성 값이 모든 값들을 만족할 때 사용


# 가전 제품보다 비싼 제품을 조회
# 가장 비싼 가전 제품보다 가격이 비싼가? : all
# 가징 싼 가전 제품보다 가격이 비싼가? : any or in

select *
from product
where pr_price > any(select pr_price from product where pr_ca_code = 'AB');
# 10000원보다 비싼 제품들

select *
from product
where pr_price > all(select pr_price from product where pr_ca_code = 'AB');
# 100만 원 보다 비싼 제품들

select *
from product
where pr_price > any(select pr_price from product where pr_ca_code = 'CD') and pr_ca_code not in('CD') ;


# 10000원보다 비싼 제품들




