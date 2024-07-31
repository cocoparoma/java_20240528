-- Active: 1722306683503@@127.0.0.1@3306@community
use community;
insert into member_state VALUES ('기간 정지'),('영구 정지'),('사용');
insert into report_type VALUES ('욕설'),('허위사실유포'),('광고'),('음란'),('커뮤니티에 맞지 않음'),('기타');
insert into community VALUES (null, '공지');
# 회원 가입 => id : abc123, pw:abc123 email : abc123@naver.com
insert INTO member(me_id, me_pw, me_email, me_ms_name) VALUES('abc123', 'abc123', 'abc123@naver.com', '사용');
# 회원 가입 => id : qwe123, pw:qwe123 email : qwe123@naver.com
insert INTO member(me_id, me_pw, me_email, me_ms_name) VALUES('qwe123', 'qwe123', 'qwe123@naver.com', '사용');
# 회원 가입 => id : zxc000, pw:zxc000 email : zxc000@naver.com
insert INTO member(me_id, me_pw, me_email, me_ms_name) VALUES('zxc000', 'zxc000', 'zxc000@naver.com', '사용');
# 회원 가입 => id : admin123, pw:admin123 email : admin123@naver.com
insert INTO member(me_id, me_pw, me_email, me_ms_name, me_authority) VALUES('admin123', 'admin123', 'admin123@naver.com', '사용', 'ADMIN');

# 관리자가 축구, 야구, 배구, 올림픽 커뮤니티를 추가했을 때 필요한 쿼리
insert into community VALUES(null, '축구'),(null, '야구'),(null, '배구'),(null, '올림픽');

# abc123 회원이 축구 커뮤니티에 개시글 2개 작성(제목과 내용은 알아서)
insert into post(po_name, po_content, po_co_id, po_me_id) VALUE ('해체해', '해체해',  2 , 'abc123');
insert into post(po_name, po_content, po_co_id, po_me_id) VALUE ('전국 해체해 커뮤니티', 'ㅇㅇ',2,'abc123');

# abc123 회원이 야구 커뮤니티에 개시글 1개 작성(제목과 내용은 알아서)
# abc123 회원이 배구 커뮤니티에 개시글 1개 작성(제목과 내용은 알아서)
# abc123 회원이 올림픽 커뮤니티에 개시글 3개 작성(제목과 내용은 알아서)
# qwe123 회원이 축구 커뮤니티에 개시글 2개 작성(제목과 내용은 알아서)
# qwe123 회원이 올림픽 커뮤니티에 개시글 1개 작성(제목과 내용은 알아서)
insert into post(po_name, po_content, po_co_id, po_me_id) VALUE ('요즘야구 재미있나요', '재미있어보여요',3,'abc123');
insert into post(po_name, po_content, po_co_id, po_me_id) VALUE ('요즘배구 재미있나요', '재미있어보여요',4,'abc123');
insert into post(po_name, po_content, po_co_id, po_me_id) VALUE ('29점 으로 1등 못하는 이유', '30점의 한국이 있어서',5,'abc123');
insert into post(po_name, po_content, po_co_id, po_me_id) VALUE ('팬싱 1등 ㅊㅊ', '축하드립니다.',5,'abc123');
insert into post(po_name, po_content, po_co_id, po_me_id) VALUE ('남자양궁 3연패', '궁수의민족',5,'abc123');

insert into post(po_name, po_content, po_co_id, po_me_id) VALUE ('축구입문', '박지성 화이팅',2,'qwe123');
insert into post(po_name, po_content, po_co_id, po_me_id) VALUE ('홀란드씨 잘생긴거같아요', 'ㅇㅇ',2,'qwe123');
insert into post(po_name, po_content, po_co_id, po_me_id) VALUE ('대한민국 5등', '다들 축하드립니다.',5,'qwe123');

# 1번 개시글에 qwe123 회원이 클릭해서 상세 확인을 했을 때 쿼리
update post set po_view = po_view + 1 where po_id = 1;
select po_name, po_content,po_me_id, po_view FROM post where po_id = 1;

# 1번 개시글에 qwe123 회원이 추천을 눌렀을 때 쿼리
insert into recommend VALUES(null, 1, 1, 'qwe123');
# 1번 게시글에 qwe123 회원이 추천을 다시 눌렀을 때(on/off 방식 > 추천 해제 버전)
update recommend set re_state = 0 where re_po_id = 1 and re_me_id = 'qwe123';
# 1번 게시글에 qwe123 회원이 추천을 다시 눌렀을 때(삭제 버전)
delete FROM recommend where re_po_id = 1 and re_me_id = 'qwe123';


 

# 1번 게시글에 recommend(추천 table)가 삭제되었다는 가정하에 추천을 생성하는 버전(추천 > 취소 > 추천)
insert into recommend VALUEs (null, 1,1,'qwe123');
# 1번 게시글에 recommend(추천 table)가 있다는 가정하에 추천을 수정하는 버전(추천 > 취소 > 추천)
update recommend set re_state = 1 where re_po_id = 1 and re_me_id = 'qwe123';



# qwe123 회원이 1,2,3 게시글은 추천 4,5,6 게시글은 비추천을 누름 
insert into recommend VALUES
(null, 1, 1, 'qwe123'),
(null, 1, 2, 'qwe123'),
(null, 1, 3, 'qwe123'),
(null, -1, 4, 'qwe123'),
(null, -1, 5, 'qwe123'),
(null, -1, 6, 'qwe123');

# zxc000 이 3,4,5 번 게시글을 추천 7,8 게시글을 비추천을 누름
insert into recommend VALUES
(null, 1, 3, 'zxc000'),
(null, 1, 4, 'zxc000'),
(null, 1, 5, 'zxc000'),
(null, -1, 7, 'zxc000'),
(null, -1, 8, 'zxc000');

# abc123 이 1~8 번 게시글의 추천을 누름
insert into recommend VALUES
(null, 1, 1, 'abc123'),
(null, 1, 2, 'abc123'),
(null, 1, 3, 'abc123'),
(null, 1, 4, 'abc123'),
(null, 1, 5, 'abc123'),
(null, 1, 6, 'abc123'),
(null, 1, 7, 'abc123'),
(null, 1, 8, 'abc123');



insert into comment(cm_id, cm_content, cm_po_id, cm_ori_id, cm_me_id) SELECT
IFNULL(max(cm_id), 0)+1, '작성자 입니다.', 1, IFNULL(max(cm_id), 0)+1 , 'abc123'  from comment;
insert into comment(cm_id, cm_content, cm_po_id, cm_ori_id, cm_me_id) SELECT
IFNULL(max(cm_id), 0)+1, '반가워요', 1, 1 , 'qwe123'  from comment;
insert into comment(cm_id, cm_content, cm_po_id, cm_ori_id, cm_me_id) SELECT
IFNULL(max(cm_id), 0)+1, '저도 반가워요', 1, 1 , 'zxc000'  from comment;

insert into comment(cm_id, cm_content, cm_po_id, cm_ori_id, cm_me_id) SELECT
IFNULL(max(cm_id), 0)+1, '어케 활성화 할까용', 1, IFNULL(max(cm_id), 0)+1 , 'qwe123'  from comment;
insert into comment(cm_id, cm_content, cm_po_id, cm_ori_id, cm_me_id) SELECT
IFNULL(max(cm_id), 0)+1, '모르겠네용', 1, IFNULL(max(cm_id), 0)+1 , 'zxc000'  from comment;
insert into comment(cm_id, cm_content, cm_po_id, cm_ori_id, cm_me_id) SELECT
IFNULL(max(cm_id), 0)+1, '노력해봐용', 1, IFNULL(max(cm_id), 0)+1 , 'abc123'  from comment;

# 1번 게시글에서 6번 댓글을 기타로 qwe123회원이 신고함
insert into report VALUES(null, 'qwe123','comment', 6, '기타')

# 2번 게시글을 zxc000회원이 기타로 신고함
insert into report VALUES(null, 'zxc000','post', 2, '기타')

select * from post;
select * from report;