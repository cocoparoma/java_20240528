DROP DATABASE IF EXISTS CGV;

CREATE DATABASE if not exists CGV;

USE CGV;

DROP TABLE IF EXISTS `person`;

CREATE TABLE IF NOT EXISTS `person` (
	`ps_id`	int primary key auto_increment	NOT NULL,
	`ps_name`	varchar(30) NOT NULL,
	`ps_birth`	date		NOT NULL,
	`ps_detail`	longtext	NOT NULL,
	`ps_contry`	varchar(30)	NOT NULL
);

DROP TABLE IF EXISTS `characher`;

CREATE TABLE IF NOT EXISTS `characher` (
	`ch_id`	int primary key auto_increment	NOT NULL,
	`ch_role`	char(2)	NOT NULL default '배우',
	`ch_pic`	varchar(255)	NULL,
	`ch_ps_id`	int	NOT NULL
);

DROP TABLE IF EXISTS `movie`;

CREATE TABLE IF NOT EXISTS `movie` (
	`mo_id`	int primary key auto_increment	NOT NULL,
	`mo_title`	varchar(255) NOT NULL,
	`mo_content`	longtext	NOT NULL,
	`mo_time`	int	NOT NULL,
	`mo_age`	varchar(20)	NOT NULL,#전체, 12세 이상, 15세 이상 관람가, 청소년 관람 불가
	`mo_date`	date	NOT NULL
);

DROP TABLE IF EXISTS `genre`;

CREATE TABLE IF NOT EXISTS `genre` (
	`ge_name`	varchar(20) primary key	NOT NULL
);

DROP TABLE IF EXISTS `movie_genre`;

CREATE TABLE IF NOT EXISTS `movie_genre` (
	`mg_id`	int primary key auto_increment	NOT NULL,
	`mg_ge_name`	varchar(20)	NOT NULL,
	`mg_mo_id`	int	NOT NULL
);

DROP TABLE IF EXISTS `country`;

CREATE TABLE IF NOT EXISTS `country` (
	`co_name`	varchar(20) primary key	NOT NULL
);

DROP TABLE IF EXISTS `movie_country`;

CREATE TABLE IF NOT EXISTS `movie_country` (
	`mc_id`	int primary key auto_increment	NOT NULL,
	`mc_co_name`	varchar(20)	NOT NULL,
	`mc_mo_id`	int	NOT NULL
);

DROP TABLE IF EXISTS `casting`;

CREATE TABLE IF NOT EXISTS `casting` (
	`ca_id`	int primary key auto_increment	NOT NULL,
	`ca_name`	varchar(20)	NOT NULL,
	`ca_ch_id`	int	NOT NULL,
	`ca_mo_id`	int	NOT NULL
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE IF NOT EXISTS `file` (
	`fi_id`	int primary key auto_increment	NOT NULL,
	`fi_name`	varchar(255)	NOT NULL,
	`fi_type`	varchar(10)	NOT NULL, # 트레일러, 썸네일
	`fi_mo_id`	int	NOT NULL
);

DROP TABLE IF EXISTS `theater`;

CREATE TABLE IF NOT EXISTS `theater` (
	`th_id`	int primary key auto_increment	NOT NULL,
	`th_name`	varchar(30) NOT NULL,
	`th_screen`	int	NOT NULL,
	`th_seat`	int	NOT NULL,
	`th_address`	varchar(255)	NOT NULL,
	`th_region`	varchar(10) NOT	NULL
);

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE IF NOT EXISTS `schedule` (
	`sd_id`	int primary key auto_increment	NOT NULL,
	`sd_time`	time	NOT NULL,
	`sd_date`	date	NOT NULL,
	`sd_early`	int	NOT NULL,
	`sd_mo_id`	int	NOT NULL,
	`sd_sc_id`	int	NOT NULL
);

DROP TABLE IF EXISTS `screen`;

CREATE TABLE IF NOT EXISTS `screen` (
	`sc_id`	int primary key auto_increment	NOT NULL,
	`sc_name`	varchar(30)	NOT NULL,
	`sc_seat`	int	NOT NULL,
	`sc_th_id`	int	NOT NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE IF NOT EXISTS `seat` (
	`se_id`	int primary key auto_increment	NOT NULL,
	`se_name`	varchar(3)	NOT NULL,
	`se_sc_id`	int	NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE IF NOT EXISTS `member` (
	`me_id`	varchar(15) primary key	NOT NULL,
	`me_pw`	varchar(255)	NOT NULL,
	`me_authority`	varchar(5)	NOT NULL
);

DROP TABLE IF EXISTS `ticketing`;

CREATE TABLE IF NOT EXISTS `ticketing` (
	`ti_id`	int primary key auto_increment	NOT NULL,
	`ti_adult`	int	NULL,
	`ti_teenager`	int	NULL,
	`ti_total`	int	NULL,
	`ti_me_id`	varchar(15)	NOT NULL,
	`ti_sd_id`	int	NOT NULL
);

DROP TABLE IF EXISTS `price`;

CREATE TABLE IF NOT EXISTS `price` (
	`pr_id`	int primary key auto_increment	NOT NULL,
	`pr_type`	varchar(10)	NOT NULL,
	`pr_price`	int	NOT NULL
);

ALTER TABLE `characher` ADD CONSTRAINT `FK_person_TO_characher_1` FOREIGN KEY (
	`ch_ps_id`
)
REFERENCES `person` (
	`ps_id`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_genre_TO_movie_genre_1` FOREIGN KEY (
	`mg_ge_name`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_movie_TO_movie_genre_1` FOREIGN KEY (
	`mg_mo_id`
)
REFERENCES `movie` (
	`mo_id`
);

ALTER TABLE `movie_country` ADD CONSTRAINT `FK_country_TO_movie_country_1` FOREIGN KEY (
	`mc_co_name`
)
REFERENCES `country` (
	`co_name`
);

ALTER TABLE `movie_country` ADD CONSTRAINT `FK_movie_TO_movie_country_1` FOREIGN KEY (
	`mc_mo_id`
)
REFERENCES `movie` (
	`mo_id`
);

ALTER TABLE `casting` ADD CONSTRAINT `FK_characher_TO_casting_1` FOREIGN KEY (
	`ca_ch_id`
)
REFERENCES `characher` (
	`ch_id`
);

ALTER TABLE `casting` ADD CONSTRAINT `FK_movie_TO_casting_1` FOREIGN KEY (
	`ca_mo_id`
)
REFERENCES `movie` (
	`mo_id`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_movie_TO_file_1` FOREIGN KEY (
	`fi_mo_id`
)
REFERENCES `movie` (
	`mo_id`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_movie_TO_schedule_1` FOREIGN KEY (
	`sd_mo_id`
)
REFERENCES `movie` (
	`mo_id`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_screen_TO_schedule_1` FOREIGN KEY (
	`sd_sc_id`
)
REFERENCES `screen` (
	`sc_id`
);

ALTER TABLE `screen` ADD CONSTRAINT `FK_theater_TO_screen_1` FOREIGN KEY (
	`sc_th_id`
)
REFERENCES `theater` (
	`th_id`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_screen_TO_seat_1` FOREIGN KEY (
	`se_sc_id`
)
REFERENCES `screen` (
	`sc_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_member_TO_ticketing_1` FOREIGN KEY (
	`ti_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_schedule_TO_ticketing_1` FOREIGN KEY (
	`ti_sd_id`
)
REFERENCES `schedule` (
	`sd_id`
);



-- 04 



DROP TABLE IF EXISTS `ticketing_list`;

CREATE TABLE `ticketing_list` (
	`tl_id`	int primary key auto_increment	NOT NULL,
	`tl_ti_id`	int	NOT NULL,
	`tl_se_id`	int	NOT NULL
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_ticketing_TO_ticketing_list_1` FOREIGN KEY (
	`tl_ti_id`
)
REFERENCES `ticketing` (
	`ti_id`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_seat_TO_ticketing_list_1` FOREIGN KEY (
	`tl_se_id`
)
REFERENCES `seat` (
	`se_id`
);

ALTER TABLE `cgv`.`schedule` 
ADD COLUMN `sd_possible` INT NOT NULL AFTER `sd_sc_id`;





