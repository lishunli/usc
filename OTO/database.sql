create table `test`.`person`(
        `personid` int not null auto_increment,
       `PersonName` varchar(20)  not null,
       `sex` int   not null,
       `age` int   not null,
       `birthday` varchar(50)   not null,
        primary key (`personid`)
    );
    
  create table `test`.`idcard`(
        `id` int not null auto_increment,
       `cardno` varchar(32)   not null,
       `Person_ID` int  not null,
        primary key (`id`),
        constraint sdf foreign key(Person_ID) references person(personid)
    );

   
    