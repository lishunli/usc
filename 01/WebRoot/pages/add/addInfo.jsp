<%@ page language="java" contentType="text/html; charset=gb2312"%>
<!--<%@ taglib prefix="s2" uri="struts2" %>-->
<%@taglib uri="/struts-tags" prefix="s2" %>

<html>
<head>
    <title>������Ϣ</title>
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
                    <tr height="30"><td style="text-indent:10"><font color="#004790"><b>��������Ϣ</b></font><br><br></td></tr>
                    <tr>
                        <td align="center">
                            <table border="0" width="650" rules="all" cellspacing="8">                    
                                <tr>
                                    <td width="20%" style="text-indent:10">��Ϣ���<br><br></td>
                                    <td>
                                                                   
                                    <br><br></td>
                                    <td align="right"><font color="#7F7F7F">[��Ϣ������಻�ó��� 40 ���ַ�]&nbsp;&nbsp;</font><br><br></td>
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>
                                <tr>
                                    <td style="text-indent:10">��Ϣ���⣺<br><br></td>
                                    <td colspan="2"><br><br></td>                        
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>
                                <tr>
                                    <td style="text-indent:10">��Ϣ���ݣ�<br><br></td> 
                                    <td>
                                        <font color="#7F7F7F">
                                            ���ã�<input type="text" name="ContentUse" value="0" size="4" disabled style="text-align:center;border:0;"> ��&nbsp;&nbsp;
                                            ʣ�ࣺ<input type="text" name="ContentRem" value="500" size="4" disabled style="text-align:center;border:0;"> �� 
                                        </font>
                                    <br><br></td>
                                    <td align="right"><font color="#7F7F7F">[��Ϣ������಻�ó��� 500 ���ַ�]&nbsp;&nbsp;</font><br><br></td>
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>
                                <tr><td colspan="3" align="center"><br><br></td></tr>
                                <tr>
                                    <td style="text-indent:10">��ϵ�绰��<br><br></td>
                                    <td colspan="2"><font color="gray">&nbsp;[����绰�Զ��ŷָ���]</font><br><br></td>
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>
                                <tr>
                                    <td style="text-indent:10">�� ϵ �ˣ�<br><br></td>
                                    <td colspan="2"><br><br></td>
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>
                                <tr>
                                    <td style="text-indent:10">E - mail��<br><br></td>
                                    <td colspan="2"><br><br></td>                    
                                </tr>
                                <tr><td colspan="3"><br><br></td></tr>                        
                            </table>                
                        <br><br></td>
                    </tr>
                    <tr align="center" height="50">
                        <td>&quot;&quot;
                            <s2:submit value="����"/>
                            <s2:reset value="����"/>
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