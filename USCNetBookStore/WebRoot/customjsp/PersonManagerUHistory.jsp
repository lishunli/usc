<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head> 
  <body bgcolor="#EEEEEE">
        <table width="60%" height="60%" border="3" cellspacing="1" cellpadding="1">
           <tr><td class=tablebody2 valign=middle colspan=6 align=center><font color="blue"><b>U币历史清单</b></td></tr>
           <tr>
               <td width="6%" class="tablebody1">${uCurrencyDetail.uCurrencyID}</td>
               <td width="6%" class="tablebody1">${uCurrencyDetail.last}</td>
               <td width="6%" class="tablebody1">${uCurrencyDetail.current}</td>
               <td width="6%" class="tablebody1">${uCurrencyDetail.source}</td>
               <td width="6%" class="tablebody1">${uCurrencyDetail.destination}</td> 
               <td width="6%" class="tablebody1">${uCurrencyDetail.uCurrencyDate}</td>
           </tr>
          <tr>
              <td>2</td> <td>60</td> <td>80</td> <td>jim</td> <td>转入</td> <td>2008-10-25</td>
           </tr> <tr>
              <td> 3</td> <td>80 </td> <td>40</td> <td> </td> <td>704245</td> <td>2009-1-25</td>
           </tr>
        </table><br>
  </body>
</html>
