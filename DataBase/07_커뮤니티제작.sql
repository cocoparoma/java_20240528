drop database if exists community;
create database if not exists community;
use community;
DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`			varchar(13) primary key	NOT NULL,
	`me_pw`			varchar(255) not NULL,
	`me_email`		varchar(50) unique	not NULL,
	`me_authority`	varchar(5) not	NULL default 'user',
	`me_fail`		int not	NULL default 0,
	`me_cookie`		varchar(255) NULL,
	`me_limit`		datetime NULL,
	`me_report`		int	not NULL default 0,
	`me_ms_name`	VARCHAR(10)	NULL,
	`me_stop`		datetime NULL
);

DROP TABLE IF EXISTS `community`;

CREATE TABLE `community` (
	`co_id`	int primary key auto_increment	NOT NULL,
	`co_name`	varchar(50) unique	NULL
);

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
	`po_id`			int primary key auto_increment	NOT NULL,
	`po_name`		varchar(50) not	NULL,
	`po_content`	longtext not NULL,
	`po_me_id`		varchar(13)	NOT NULL,
	`po_co_id`		int	NOT NULL,
	`po_date`		datetime not NULL default current_timestamp,
	`po_view`		int	not NULL default 0,
	`po_report`		int	not NULL default 0
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_id`			int 			primary key auto_increment	NOT NULL,
	`if_ori_name`	varchar(255)	not NULL,
	`if_name`		varchar(255)	not NULL,
	`fi_po_id`		int				NOT NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`cm_id`			int 			NOT NULL primary key,
	`cm_content`	varchar(255)	not NULL,
	`cm_po_id`		int				NOT NULL,
	`cm_ori_id`		int				not NULL,
	`cm_date`		datetime		not NULL default current_timestamp,
	`cm_me_id`		varchar(13)		NOT NULL,
	`cm_report`		int				not NULL default 0,
	`cm_state`		int				not NULL default 0 # 0 : 이상없음, 1 : 작성자가 삭제, 2 : 관리자에 의해 삭제
);

DROP TABLE IF EXISTS `recommend`;

CREATE TABLE `recommend` (
	`re_id`			int 			NOT NULL primary key auto_increment,
	`re_state`		int				not NULL,
	`re_po_id`		int				NOT NULL,
	`re_me_id`		varchar(13)		NOT NULL
);

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
	`rp_id`			int 			NOT NULL primary key auto_increment	,
	`rp_me_id`		varchar(13)		NOT NULL,
	`rp_table`		varchar(10)		not NULL,
	`rp_target`		int				not NULL,
	`rt_name`		varchar(15)		NOT NULL
);

DROP TABLE IF EXISTS `report_type`;

CREATE TABLE `report_type` (
	`rt_name`	varchar(15) primary key	NOT NULL
);

DROP TABLE IF EXISTS `member_state`;

CREATE TABLE `member_state` (
	`ms_name`	varchar(10) primary key	NOT NULL
);

ALTER TABLE `member` ADD CONSTRAINT `FK_member_state_TO_member_1` FOREIGN KEY (
	`me_ms_name`
)
REFERENCES `member_state` (
	`ms_name`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_member_TO_post_1` FOREIGN KEY (
	`po_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_community_TO_post_1` FOREIGN KEY (
	`po_co_id`
)
REFERENCES `community` (
	`co_id`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_post_TO_file_1` FOREIGN KEY (
	`fi_po_id`
)
REFERENCES `post` (
	`po_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_post_TO_comment_1` FOREIGN KEY (
	`cm_po_id`
)
REFERENCES `post` (
	`po_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`cm_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_post_TO_recommend_1` FOREIGN KEY (
	`re_po_id`
)
REFERENCES `post` (
	`po_id`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_member_TO_recommend_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_member_TO_report_1` FOREIGN KEY (
	`rp_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_report_type_TO_report_1` FOREIGN KEY (
	`rt_name`
)
REFERENCES `report_type` (
	`rt_name`
);

