package org.usc.demo;

/**
 *
 * @author ShunLi
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(getCodeFromMonthAndType("1","STKOPS_P"));;
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
