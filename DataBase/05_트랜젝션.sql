use product;

# 트랜젝션을 시작 : commit 할때까지 최종 적용이 안됨.
start transaction;

update product
set pr_price = 1200000
where pr_code = 'AB1';

savepoint A1;

update product
set pr_price = 2200000
where pr_code = 'AB1';

savepoint A2;

update product
set pr_price = 3200000
where pr_code = 'AB1';

# 트렌젝션 전으로 돌아가기, 롤백시 savepoint제거됨
# rollback A2; # A2 위치로 돌아갈 수 있음
rollback;
# 반영
commit;

select * from product;


