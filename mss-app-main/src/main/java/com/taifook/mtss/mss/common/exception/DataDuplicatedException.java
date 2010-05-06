/**
 *
 */
package com.taifook.mtss.mss.common.exception;

import com.taifook.mtss.mss.common.constant.MssCoreErrorCode;
import com.taifook.mtss.mss.exception.MssException;

/**
 * Input Data Validation exception for unique data duplication.
 * Should only be used in Input Data Validation, but not business logic
 *
 */
public class DataDuplicatedException extends MssException {
    private static final long serialVersionUID = -2716196603296818020L;
    public final static String ERROR_CODE = MssCoreErrorCode.DATA_DUPLICATED;

    public DataDuplicatedException() {
        super(ERROR_CODE);
    }

    public DataDuplicatedException(Throwable cause) {
        super(ERROR_CODE, cause);
    }

    public DataDuplicatedException(String fieldName) {
        super(ERROR_CODE, new String[]{fieldName});
    }

    public DataDuplicatedException(String fieldName, Throwable cause) {
        super(ERROR_CODE, new String[]{fieldName}, cause);
    }


}
