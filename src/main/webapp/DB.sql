
drop table User_table;
create table User_table(
	u_id varchar2(20 char) primary key,
	u_pw varchar2(20 char) not null,
	u_name varchar2(50 char) not null,
	u_phonenumber varchar2(15 char) not null,
	u_gender varchar2(30 char) not null
);

insert into User_table values('id','pw','가나다','01000000000','man');

select * from User_table;



create table teacher_table(
	t_id varchar2(20 char) primary key,
	t_pw varchar2(20 char) not null,
	t_name varchar2(50 char) not null,
	t_phonenumber varchar2(15 char) not null,
	t_gender varchar2(30 char) not null,
	t_text varchar2(50 char) not null
);

delete from teacher_table;

select * from teacher_table;



create table root_table(
	r_id varchar2(20 char) primary key,
	r_pw varchar2(20 char) not null
);

insert into root_table values('root','1234');

select * from root_table;

drop table apply_table;
create table apply_table(
    a_no number(5) primary key,
    a_id varchar2(20 char),
    a_name varchar2(50 char) not null,
    a_gender varchar2(30 char) not null,
    a_start date not null,
    a_end date not null,
    a_age number(3) not null,
    a_img varchar2(100 char)not null,
    a_tname varchar2(20 char)not null,
    a_agree number(3) not null
);

create sequence apply_table_seq;


insert into apply_table values(apply_table_seq.nextval,'테스트','테스트','남','2021-10-06','2021-10-25','15','이미지','선생님이름','1');

select * from apply_table;

select rn, n_no,n_id,n_title,n_txt,n_date 
from (select Rownum as rn,n_no,n_id,n_title,n_txt,n_date 
	  from (select n_no,n_id,n_title,n_txt,n_date
			from notice_table
			order by n_no desc))
where RN >=10 and RN <=19;


8. 알림장 테이블
create table mypet_table(
	mp_no number(3) primary key,
	mp_title varchar2(30 char) not null,
	mp_condition varchar2(30 char) not null,
	mp_meal number(3) not null,
	mp_defecate number(3) not null,
	mp_supplies  varchar2(30 char) not null,
	mp_txt varchar2 (200 char) not null,
	mp_tid varchar2(30 char) not null,
	mp_uid varchar2(30 char) not null,
	mp_uname varchar2(30 char) not null,
	mp_date date not null
);

9. 알림장 댓글 테이블 
create table comment_table(
	c_no number(3) primary key,
	c_mp_no number(3) not null,
	c_tid varchar2(30 char) not null,
	c_uid varchar2(30 char) not null,
	c_uname varchar2(30 char) not null,
	c_txt varchar2 (200 char) not null,
	c_writer varchar2 (200 char) not null,
	c_date date not null
);

10. 갤러리 테이블
create table gallery_table(
	g_no number(3) primary key,
	g_title varchar2(30 char) not null,
	g_img varchar2(100 char)not null,
	g_tid varchar2(30 char) not null,
	g_uid varchar2(30 char) not null,
	g_uname varchar2(30 char) not null,
	g_date date not null
);

create sequence comment_table_seq;
create sequence gallery_table_seq;
create sequence mypet_table_seq;
