use ApiRestLF;

create table userOne (
id_user int primary key identity (1,1),
name_user varchar(50),
age_user int)


select * from userOne;
select * from userOne where id_user=5 or id_user=2;

insert into userOne(name_user, age_user) values ('Luis Florez', 18);

update userOne set name_user = 'Luis Angel Florez Palacio' where id_user=1

delete from userOne;
delete from userOne where id_user=2;