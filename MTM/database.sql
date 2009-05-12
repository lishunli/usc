create table student(studentid int not null primary key auto_increment,
					 studentName varchar(32) not null);
create table teacher(teacherid int not null primary key auto_increment,
					 teacherName varchar(32) not null);
create table teacher_student(Student_ID int not null,
							  Teacher_ID int not null
							  );
ALTER TABLE teacher_student
	ADD CONSTRAINT `tid` FOREIGN KEY (`Teacher_ID`) REFERENCES `teacher` (`teacherid`) ,
	ADD CONSTRAINT `sid` FOREIGN KEY (`Student_ID`) REFERENCES `student` (`studentid`) ;
