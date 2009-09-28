package cn.itcast.struts.util.validator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

public class IdCardCheck {
    public static boolean validateIdCard(Object bean,
            ValidatorAction va, Field field,
            ActionMessages errors,
            Validator validator,
            HttpServletRequest request) {

    	String value = null;

		value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		if (value.length()!=18 || !isAllNumber(value)){
			errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));			
			return false;
		} else {
			return true;
		}

}

	private static boolean isAllNumber(String value) {
		// TODO Auto-generated method stub
		int len = value.length();
		for(int i=0;i<len;i++)
		{   
			if(!Character.isDigit(value.charAt(i)))
			return false;
		}
		return true;
	}
 
}
