drop database if exists shoppingmall;

create database if not exists shoppingmall;

use shoppingmall;

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`ca_id`	int	NOT NULL primary key auto_increment,
	`ca_name`	varchar(30)	NOT NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`pr_id`	varchar(10) primary key	NOT NULL,
	`pr_name`	varchar(50)	NOT NULL,
	`pr_detail`	longtext	NULL,
	`pr_price`	int	NOT NULL,
	`pr_ca_id`	int	NOT NULL
);

DROP TABLE IF EXISTS `product_img`;

CREATE TABLE `product_img` (
	`pi_id`	int primary key auto_increment	NOT NULL,
	`pi_name`	varchar(150)	NULL,
	`pr_id`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(13) primary key	NOT NULL,
	`me_pw`	varchar(20)	NOT NULL,
	`me_email`	varchar(50)	NOT NULL,
	`me_phone`	varchar(15),
	`me_authority`	varchar(5)	NOT NULL DEFAULT 'user',
	`me_fail`	int	NOT NULL	DEFAULT 0
);

DROP TABLE IF EXISTS `code`;

CREATE TABLE `code` (
	`co_me_id`	varchar(13) primary key	NOT NULL,
	`co_code`	char(6)	NOT NULL,
	`co_time`	datetime	NOT NULL
);

DROP TABLE IF EXISTS `basket`;

CREATE TABLE `basket` (
	`ba_id`	int primary key auto_increment	NOT NULL,
	`ba_pr_id`	varchar(10)	NOT NULL,
	`ba_me_id`	varchar(13)	NOT NULL,
	`ba_acunt`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `buy`;

CREATE TABLE `buy` (
	`bu_id`	int primary key auto_increment	NOT NULL,
	`bu_pr_id`	varchar(10)	NOT NULL,
	`bu_me_id`	varchar(13)	NOT NULL,
	`bu_amonut`	int	NOT NULL	DEFAULT 1,
	`bu_state`	varchar(10)	NOT NULL,
	`bu_date`	datetime	NOT NULL
);

ALTER TABLE `product` ADD CONSTRAINT `FK_category_TO_product_1` FOREIGN KEY (
	`pr_ca_id`
)
REFERENCES `category` (
	`ca_id`
);

ALTER TABLE `product_img` ADD CONSTRAINT `FK_product_TO_product_img_1` FOREIGN KEY (
	`pr_id`
)
REFERENCES `product` (
	`pr_id`
);

ALTER TABLE `code` ADD CONSTRAINT `FK_member_TO_code_1` FOREIGN KEY (
	`co_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_product_TO_basket_1` FOREIGN KEY (
	`ba_pr_id`
)
REFERENCES `product` (
	`pr_id`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_member_TO_basket_1` FOREIGN KEY (
	`ba_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_product_TO_buy_1` FOREIGN KEY (
	`bu_pr_id`
)
REFERENCES `product` (
	`pr_id`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_member_TO_buy_1` FOREIGN KEY (
	`bu_me_id`
)
REFERENCES `member` (
	`me_id`
);

