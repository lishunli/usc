package com.usc.services.custom;

import com.usc.daos.Custom;
import com.usc.daos.Suggestion;

public interface IPersonManage {

public void changeCustomInfo(Custom custom,String realName,String sex,String address,String postCode,String mobile,String phone);

public void changeCustomPassword(Custom custom,String newPassword);

public void changeCustomEmail(Custom custom,String email);


public void UTransfor(Custom custom1,String custom2Name,float Unumber);

public void saveSuggestion(Suggestion suggestion);


public void BswapU(Custom custom,float number);

}
