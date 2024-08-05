use community;

select * from post;
# 게시글을 조회하는 쿼리(번호 내림차순, 3개 ,1 page)
select * from post order by po_id desc limit 0, 3;

# 게시글 제목에 '구' 가 들어가는 게시글을 조회하는 쿼리 작성(번호 내림차순, 3개 ,1 page)
select * from post where po_name like concat('%','구','%') order by po_id desc limit 0, 3;

# 축구 커뮤니티 글을 조회하는 게시글
select * from post
join community on po_co_id = co_id
where co_name = '축구';

# 댓글, 대댓글 보기
select if(cm_state > 1, concat(' - ',cm_content), concat(cm_content)) 댓글 from comment
where cm_po_id = 1;
select * from comment where cm_po_id = 1 order by cm_ori_id, cm_id;
select * from comment where cm_po_id = 1 order by cm_ori_id, cm_id limit 0, 5;

# 게시글 조회(조회수가 많은 순)
select * from post order by po_view desc;
# 게식르을 조회(많은 순), 조회수 순위 3위까지
select rank() over (order by po_view desc) as ranking, post.* from post limit 0, 3;
# 또는 + 윈도우함수 where 직접 사용 불가 // 테이블로 만들어주자
select * from (select rank() over (order by po_view desc) as ranking, post.* from post) as po
where ranking <= 3;







