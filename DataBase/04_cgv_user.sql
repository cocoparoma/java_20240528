# create user 'ID'@'HostName' identified by 'pw';
# 호스트명
# - localhost - 내부에서만 사용 가능 (다른 pc 에서 해당 DB 에 접근 불가)
# - % : 외부에서도 사용 가능(다른 pc에서도 아이디와 비번이 맞으면 접근 가능)
# cgv DB 관리를 위한 cgv_admin 계정 추가 (비번 : admin123)

# 계정 생성
create user 'cgv_admin'@'%' identified by 'admin123';

# 계정 조회
select user, host from MYSQL.user;

# 계정 수정
# set password for 'id'@'hostname' = 'new pw'
set password for 'cgv_admin'@'%' = 'admin1234';

# 계정 삭제
# drop user 'id'@'hostname';
drop user 'cgv_admin'@'%';

# 권한 부여
# 사용자에게 DB에 대한 권한을 부여. 데이터 추가, 수정, 삭제, 테이블 추가, 수정, 삭제 ... 등등
# select / insert / update / delete / create / alter / drop / references / all privileges(모든 권한)
# grant 권한 on DB명.테이블명 to 'id'@'hostname';
grant all privileges on cgv.* to 'cgv_admin'@'%';
grant select on product.* to 'cgv_admin'@'%';
grant select on student.* to 'cgv_admin'@'%';
grant select on university.* to 'cgv_admin'@'%';

# 권한 제거
# 부여했던 권한을 제거한다.
# revoke 권한 on DB명.table명 from 'cgv_admin'@'%';
revoke select on product.* from 'cgv_admin'@'%';












