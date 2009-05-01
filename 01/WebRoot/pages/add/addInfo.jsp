<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!--<%@ taglib prefix="s2" uri="struts2" %>-->
<%@taglib uri="/struts-tags" prefix="s2" %>

<html>
<head>
    <title>发布信息</title>
    <script type="text/javascript" src="<s2:url value='js/InputCheck.js'/>"></script>
</head>
<body>
    <center>
    <table border="0" cellpadding="0" cellspacing="0" width="688" height="100%">
        <tr height="20"><td><img src="images/default_t.jpg"></td></tr>
        <tr>
            <td background="images/default_m.jpg" valign="top" align="center">
                <br><br><s2:form action="info_Add.action" theme="simple">
                <input type="hidden" name="addType" value="add"/>
                <table border="0" width="650" height="300" rules="all" cellspacing="0">
                    <tr height="30"><td style="text-indent:10"><font color="#004790"><b>■发布信息</b></font><br><br></td></tr>
                    <tr>
                        <td align="center">
                            <table border="0" width="650" rules="all" cellspacing="8">                    
                                <tr>
                                    <td width="20%" style="text-indent:10">信息类别：<br><br></td>
                                    <td>
                                                                   
                                    <br><br></td>
                                    <td align="right"><font color="#7F7F7F">[信息标题最多不得超过 40 个字符]&nbsp;&nbsp;</font><br><br></td>
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>
                                <tr>
                                    <td style="text-indent:10">信息标题：<br><br></td>
                                    <td colspan="2"><br><br></td>                        
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>
                                <tr>
                                    <td style="text-indent:10">信息内容：<br><br></td> 
                                    <td>
                                        <font color="#7F7F7F">
                                            已用：<input type="text" name="ContentUse" value="0" size="4" disabled style="text-align:center;border:0;"> 个&nbsp;&nbsp;
                                            剩余：<input type="text" name="ContentRem" value="500" size="4" disabled style="text-align:center;border:0;"> 个 
                                        </font>
                                    <br><br></td>
                                    <td align="right"><font color="#7F7F7F">[信息内容最多不得超过 500 个字符]&nbsp;&nbsp;</font><br><br></td>
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>
                                <tr><td colspan="3" align="center"><br><br></td></tr>
                                <tr>
                                    <td style="text-indent:10">联系电话：<br><br></td>
                                    <td colspan="2"><font color="gray">&nbsp;[多个电话以逗号分隔！]</font><br><br></td>
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>
                                <tr>
                                    <td style="text-indent:10">联 系 人：<br><br></td>
                                    <td colspan="2"><br><br></td>
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>
                                <tr>
                                    <td style="text-indent:10">E - mail：<br><br></td>
                                    <td colspan="2"><br><br></td>                    
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>                        
                            </table>                
                        <br><br></td>
                    </tr>
                    <tr align="center" height="50">
                        <td>&quot;&quot;
                            <s2:submit value="发布"/>
                            <s2:reset value="重填"/>
                        </td>
                    </tr>
                </table>
                </s2:form>            
            </td>
        </tr>
        <tr height="26"><td><img src="images/default_e.jpg"></td></tr>        
    </table>
    </center>
</body>
</html>