package com.usc.services.back;

import java.util.List;

import com.usc.daos.Operator;

/**
 * 后台管理员公共部分接口
 * @author MZ
 *
 */
public interface IManger
{
	boolean checkManger(Operator operator);//检查管理员登录用户
	boolean updatePass(Operator operator,String newPass);//修改密码
	boolean checkIsbnIsExist(String  isbn);//对图书表进行ISBN唯一性验证
	boolean checkBarCodeIsExist(String barcode);//对数码表进行条形码唯一性验证
}
