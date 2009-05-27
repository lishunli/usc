
    create table "SCOTT"."PERSON"(
        "PID" VARCHAR2(20) not null,
       "PNAME" VARCHAR2(20) not null,
       "AGE" NUMBER(3) not null,
       "SEX" VARCHAR2(4) default 'ÄÐ',
        constraint "SYS_C009654" primary key ("PID")
    );

    create unique index "SCOTT"."SYS_C009654" on "SCOTT"."PERSON"("PID");