    create table "SCOTT"."PERSON"(
        "PID" VARCHAR2(20) not null,
       "PNAME" VARCHAR2(20) not null,
       "AGE" NUMBER(3) not null,
       "SEX" VARCHAR2(4) default 'ÄÐ',
        primary key ("PID")
    );