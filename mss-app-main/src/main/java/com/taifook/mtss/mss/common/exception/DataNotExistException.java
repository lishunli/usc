package com.taifook.mtss.mss.common.exception;

import com.taifook.mtss.mss.common.constant.MssCoreErrorCode;
import com.taifook.mtss.mss.exception.MssException;

/**
 * Input Data Validation exception for unique data duplication.
 * Should only be used in Input Data Validation, but not business logic
 *
 */

public class DataNotExistException extends MssException {

    private static final long serialVersionUID = 6746532431408338334L;
    public final static String ERROR_CODE = MssCoreErrorCode.DATA_NOT_EXIST;

    public DataNotExistException() {
        super(ERROR_CODE);
    }

    public DataNotExistException(String field) {
        super(ERROR_CODE, new String[]{field});
    }

    public DataNotExistException(Throwable cause) {
        super(ERROR_CODE, cause);
    }

    public DataNotExistException(String field, Throwable cause) {
        super(ERROR_CODE, new String[]{field}, cause);
    }


}
