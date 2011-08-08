FAQ

不好意识各位，由于每个人的版本不同，会出现一些不可预计的问题，请大家原谅
1.MySQL版本问题：有可能导致一些执行不能运行；
2.MySQL密码问题：请大家修改程序中的MySQL密码为自己设置的密码；
3.MyEclipse版本问题：导致一些Jar包丢失，请大家下载最新版的Jar加进去；
4.字符编码问题：本人采用UTF-8格式的字符编码，如果您不是此种编码格式有可能会代码出现乱码现象，请自己设置。

------------------------------------------------------------------
Import the Sql File into Mysql


顺利（QQ：506817493）告诉你如何把sql文件导入到Mysql数据库中
1.进入Mysql的的命令行；
2.输入密码进入；
3.判断数据库是否存在，是则删除
	drop database XXX;
4.创建数据库
	create database XXX;
5.使用数据库
	use XXX;
（注：上面的XXX为数据库名，可以在sql文件的头部注释中找到）
6.导入数据库
	source sql文件完整路径;
	例： source D:/test.sql;
7.关闭命令行。


给个详细的例子
进入Mysql的命令行并输入密码进入
drop database test;
create database test;
use test;
source D:/test.sql;
这样会创建一个数据库test，并且里面会执行D:/test.sql文件里的sql语句

顺利（QQ：506817493）写于2010年1月24日
