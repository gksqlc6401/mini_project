drop table cinema;
create table cinema(
code number(4) primary key,
title varchar(30) not null,
mdate varchar(10) not null,
time varchar(10) not null,
price number(10) not null,
seat varchar(10) not null,
paydate varchar(10) not null
);

commit;
desc cinema;