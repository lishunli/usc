<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'BenefitsHistory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#EEEEEE">
    <table width="95%" height="100px" border="3" cellspacing="1" cellpadding="1" align="center" >
           <tr><td class=tablebody2 valign=middle colspan=6 align=center><font color="blue"><b>积分历史</b></td></tr>
            <tr>
              <td width="6%" class="tablebody1" colspan=6>用户名：${uCurrencyDetail.current}</td>
            <tr>
              <td width="6%" class="tablebody1" colspan=6>会员级别：${uCurrencyDetail.current}</td>
           </tr> 
           <tr>
               <td width="6%" class="tablebody1">${benefitsDetail.benefitsID}</td>
               <td width="6%" class="tablebody1">${benefitsDetail.last}</td>
               <td width="6%" class="tablebody1">${benefitsDetail.current}</td>
               <td width="6%" class="tablebody1">${benefitsDetail.explanation}</td>
               <td width="6%" class="tablebody1">${benefitsDetail.type}</td> 
               <td width="6%" class="tablebody1">${benefitsDetail.benefitsDate}</td>
           </tr>
                   
            <tr>
              <td>2</td> <td>60</td> <td>80</td> <td>jim</td> <td>转入</td> <td>2008-10-25</td>
           </tr> 
           <tr>
              <td> 3</td> <td>80 </td> <td>40</td> <td> </td> <td>704245</td> <td>2009-1-25</td>
           </tr>
        </table><br>
  </body>
</html>
