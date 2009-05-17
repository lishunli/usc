<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<html>
  <head>
 
  </head>
  
  <body>
    <center>
    	<form action="GetSum" method="post">
    请输入第一个加数:<input name="num1" value= "${n1}"><br>
    请输入第二个加数:<input name="num2" value= "${n2}"><br>
    	<input  type="submit" value="  =  "> ${sum}
    </form>		
    </center>
  </body>
</html>
