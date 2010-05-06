package com.taifook.mtss.mss.common.constant;

/**
 * As the Permission Code is defined as a master table but not a LOV table
 * in CCIS, to avoid the potential problem when MSS reads from the database
 * with new/undefined Permission Code, this is intended to use String
 * constants as the values of Permission Code.
 */
public interface PermissionCode {
    public static final String VIEW = "V";
    public static final String CREATE = "I";
    public static final String CREATE_BACK_DATE = "B";
    public static final String EDIT = "E";
    public static final String DELETE = "D";
    public static final String REVERSE = "Q";
    public static final String SUBMIT = "S";
    public static final String ASSIGN = "G";
    public static final String RETURN = "N";
    public static final String DISHONOR = "H";
    public static final String TERMINATE = "M";

    public static final String COPY = "C";
    public static final String EXECUTE = "X";
    public static final String PRE_DAYEND = "Z";
    public static final String READ = "R";
    public static final String APPROVE = "A";
    public static final String GENERATE_REPORT = "P";
    public static final String DOWNLOAD = "O";
    public static final String UPLOAD = "U";

    public static final String PRINT = "T";
    public static final String REJECT = "J";
    public static final String REVIEW = "W";

}
