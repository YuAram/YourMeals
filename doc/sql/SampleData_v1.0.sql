-- 회원 
insert into oi_user(uno, name, nick, email, password, point, photo, utype) values (1, 'admin', 'admin', 'admin@test.com', password(1111), 0, '84432c3d-a245-4196-8d02-c91bbd274274', 1);
insert into oi_user(uno, name, nick, email, password, point, photo, utype) values (2, 'eunchae-Cho', 'ec', 'ec@test.com', password(1111), 0, 'edda442c-5a56-4427-8c5e-5b052ca055ef', 0);
insert into oi_user(uno, name, nick, email, password, point, photo, utype) values (3, 'aramYu', 'ar', 'ar@test.com', password(1111), 0, 'edda442c-5a56-4427-8c5e-5b052ca055ef', 0);
insert into oi_user(uno, name, nick, email, password, point, photo, utype) values (4, 'seunghyuck', 'sh', 'sh@test.com', password(1111), 0, 'edda442c-5a56-4427-8c5e-5b052ca055ef', 0);
insert into oi_user(uno, name, nick, email, password, point, photo, utype) values (5, 'dragonmin', 'ym', 'ym@test.com', password(1111), 0, 'edda442c-5a56-4427-8c5e-5b052ca055ef', 0);
insert into oi_user(uno, name, nick, email, password, point, photo, utype) values (6, 'somi-Shin', 'sm', 'sm@test.com', password(1111), 0, 'edda442c-5a56-4427-8c5e-5b052ca055ef', 0);
insert into oi_user(uno, name, nick, email, password, point, photo, utype) values (7, 'jinyoungChoi', 'jy', 'jy@test.com', password(1111), 0, 'edda442c-5a56-4427-8c5e-5b052ca055ef', 0);
insert into oi_user(uno, name, nick, email, password, point, photo, utype) values (8, 'EomTeacher', 'et', 'et@test.com', password(1111), 0, 'edda442c-5a56-4427-8c5e-5b052ca055ef', 0);
insert into oi_user(uno, name, nick, email, password, point, photo, utype) values (9, 'youngjinEom', 'yj', 'yj@test.com', password(1111), 0, 'edda442c-5a56-4427-8c5e-5b052ca055ef', 0);
insert into oi_user(uno, name, nick, email, password, point, photo, utype) values (10, 'lilboi', 'st', 'st@test.com', password(1111), 0, 'edda442c-5a56-4427-8c5e-5b052ca055ef', 0);
-- 팔로잉
insert into oi_follow(follower, following) values (2 ,1);
insert into oi_follow(follower, following) values (3 ,1);
insert into oi_follow(follower, following) values (4 ,1);
insert into oi_follow(follower, following) values (5 ,1);
insert into oi_follow(follower, following) values (6 ,1);
insert into oi_follow(follower, following) values (7 ,1);
insert into oi_follow(follower, following) values (8 ,1);
insert into oi_follow(follower, following) values (9 ,1);
insert into oi_follow(follower, following) values (10 ,1);
insert into oi_follow(follower, following) values (1 ,2);
insert into oi_follow(follower, following) values (3 ,2);
insert into oi_follow(follower, following) values (4 ,2);
insert into oi_follow(follower, following) values (5 ,2);
insert into oi_follow(follower, following) values (6 ,2);
insert into oi_follow(follower, following) values (2 ,3);
insert into oi_follow(follower, following) values (5 ,3);
insert into oi_follow(follower, following) values (6 ,3);
insert into oi_follow(follower, following) values (8 ,3);
insert into oi_follow(follower, following) values (10 ,3);
insert into oi_follow(follower, following) values (7 ,4);
insert into oi_follow(follower, following) values (8 ,4);
insert into oi_follow(follower, following) values (9 ,4);
insert into oi_follow(follower, following) values (1 ,5);
insert into oi_follow(follower, following) values (10 ,6);
insert into oi_follow(follower, following) values (2 ,7);
insert into oi_follow(follower, following) values (3 ,7);
insert into oi_follow(follower, following) values (4 ,7);
insert into oi_follow(follower, following) values (3 ,8);
insert into oi_follow(follower, following) values (7 ,8);
insert into oi_follow(follower, following) values (9 ,8);
insert into oi_follow(follower, following) values (1 ,9);
insert into oi_follow(follower, following) values (10 ,9);
insert into oi_follow(follower, following) values (1 ,10);
insert into oi_follow(follower, following) values (2 ,10);
insert into oi_follow(follower, following) values (3 ,10);
insert into oi_follow(follower, following) values (4 ,10);
insert into oi_follow(follower, following) values (5 ,10);
insert into oi_follow(follower, following) values (6 ,10);
insert into oi_follow(follower, following) values (7 ,10);
insert into oi_follow(follower, following) values (8 ,10);
insert into oi_follow(follower, following) values (9 ,10);

-- 공지사항분류
insert into oi_notice_type(ntno, name) values (1, '필독');
insert into oi_notice_type(ntno, name) values (2, '공지');

-- 요리유형
insert into oi_category(cno, name) values (1, '메인요리');
insert into oi_category(cno, name) values (2, '밑반찬');
insert into oi_category(cno, name) values (3, '국/찌개');
insert into oi_category(cno, name) values (4, '면/만두');
insert into oi_category(cno, name) values (5, '밥/죽/떡');
insert into oi_category(cno, name) values (6, '김치/젓갈');
insert into oi_category(cno, name) values (7, '양념/소스');
insert into oi_category(cno, name) values (8, '디저트');
insert into oi_category(cno, name) values (9, '빵/과자');
insert into oi_category(cno, name) values (10, '스프');
insert into oi_category(cno, name) values (11, '샐러드');
insert into oi_category(cno, name) values (12, '기타');

-- 난이도번호
insert into oi_level(lno, lv) values (1, 1);
insert into oi_level(lno, lv) values (2, 2);
insert into oi_level(lno, lv) values (3, 3);
insert into oi_level(lno, lv) values (4, 4);
insert into oi_level(lno, lv) values (5, 5);

-- 결제방법
insert into oi_payment(pno, name) values (1, 'accoTransfer');
insert into oi_payment(pno, name) values (2, 'kakaopay');

-- 배송사 
insert into oi_delivery_company(dcno, name) values (1, 'postOffice');
insert into oi_delivery_company(dcno, name) values (2, 'hanjin');
insert into oi_delivery_company(dcno, name) values (3, 'CJ');
insert into oi_delivery_company(dcno, name) values (4, 'postOffice');

-- 전체조회(25)
select * from oi_qna;
select * from oi_payment;
select * from oi_delivery_company;
select * from oi_order;
select * from oi_account_transfer;
select * from oi_refund;
select * from oi_material;
select * from oi_product;
select * from oi_order_list;
select * from oi_user;
select * from oi_level;
select * from oi_recipe;
select * from oi_recipe_step;
select * from oi_comment;
select * from oi_follow;
select * from oi_category;
select * from oi_recipe_category;
select * from oi_recipe_material;
select * from oi_kakaopay;
select * from oi_basket;
select * from oi_board_like;
select * from oi_report_type;
select * from oi_report;
select * from oi_notice_type;
select * from oi_notice;
select * from oi_food;