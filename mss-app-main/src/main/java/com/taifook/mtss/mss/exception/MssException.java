package com.taifook.mtss.mss.exception;

import java.util.List;

import com.taifook.mtss.framework.exception.ErrorInfo;
import com.taifook.mtss.framework.exception.ErrorInfoException;


public class MssException extends ErrorInfoException {

    private static final long serialVersionUID = 1L;

    public MssException() {
    }

    public MssException(String errorCode) {
        super(errorCode);
    }


    public MssException(String errorCode, List<ErrorInfo> errorList) {
        super(errorCode, errorList);
    }

    public MssException(String errorCode, String[] errorParams) {
        super(errorCode, errorParams);
    }

    public MssException(String errorCode, String message) {
        super(errorCode, message);
    }

    public MssException(String errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public MssException(String errorCode, String[] errorParams, String message) {
        super(errorCode, errorParams, message);
    }


    public MssException(String errorCode, List<ErrorInfo> errorList, String message) {
        super(errorCode, errorList, message);
    }


    public MssException(String errorCode, String[] errorParams, List<ErrorInfo> errorList, String message) {
        super(errorCode, errorParams, errorList, message);
    }

    public MssException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public MssException(String errorCode, String[] errorParams, Throwable cause) {
        super(errorCode, errorParams, cause);
    }

    public MssException(String errorCode, String[] errorParams, String message, Throwable cause) {
        super(errorCode, errorParams, message, cause);
    }

    public MssException(String errorCode, List<ErrorInfo> errorList, String message, Throwable cause) {
        super(errorCode, errorList, message, cause);
    }

    public MssException(String errorCode, ErrorInfo[] errorList, String message, Throwable cause) {
        super(errorCode, errorList, message, cause);
    }

    public MssException(String errorCode, String[] errorParams, List<ErrorInfo> errorList, String message, Throwable cause) {
        super(errorCode, errorParams, errorList, message, cause);
    }

    public MssException(String errorCode, String[] errorParams, ErrorInfo[] errorList, String message, Throwable cause) {
        super(errorCode, errorParams, errorList, message, cause);
    }

    public MssException(ErrorInfo errorInfo) {
        super(errorInfo);
    }

    public MssException(ErrorInfo errorInfo, String message) {
        super(errorInfo, message);
    }

    public MssException(ErrorInfo errorInfo, Throwable cause) {
        super(errorInfo, cause);
    }

    public MssException(ErrorInfo errorInfo, String message, Throwable cause) {
        super(errorInfo, message, cause);
    }

    public MssException(ErrorInfo errorInfo, List<ErrorInfo> errorList, String message, Throwable cause) {
        super(errorInfo, errorList, message, cause);
    }

    public MssException(ErrorInfo errorInfo, ErrorInfo[] errorList, String message, Throwable cause) {
        super(errorInfo, errorList, message, cause);
    }
}
