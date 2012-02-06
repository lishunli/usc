package org.usc.demo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ShunLi
 */
public class Test2 {
    public static void main(String[] args) {
//        System.out.println(getCodeFromMonthAndType("1","STKOPS_P"));;

        System.out.println(String.format("not foud %d market", 1L));

        Map<String,String> test = new HashMap<String, String>(1);
//        Map<String,String> value = new HashMap<String, String>();
//        value.put("1", "1");
//        test.putAll(value);
        test.put("2", "2");
        test.put("1", "1");
        System.out.println(test);

    }

    public static String getCodeFromMonthAndType(String month,String instrumentTypeCode){
        String code = "";
        int A = 65-1;
        int M = 77-1;
        int monthIntValue = Integer.valueOf(month);
        String instrumentTypeCall = "STKOPS_C";
        String instrumentTypePut = "STKOPS_P";
        for(int i = 1; i <= 12; i++ ){
            if(monthIntValue == i && instrumentTypeCode.equals(instrumentTypeCall)){
                code = String.valueOf((char)(A+i));
                break;
            }
            if(monthIntValue == i && instrumentTypeCode.equals(instrumentTypePut)){
                code = String.valueOf((char)(M+i));
                break;
            }
        }
        return code;
    }
}
