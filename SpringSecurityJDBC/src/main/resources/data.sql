create table myusers(
    username varchar2(20) primary key,
    password varchar2(20) not null,
    enabled varchar2(5)
);

create table myuserauthorities(
    authority_id number(20) primary key,
    username varchar2(20),
    authority varchar2(10),
    FOREIGN KEY(username) REFERENCES myusers(username)
);