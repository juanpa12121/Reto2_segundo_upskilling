package com.tcs.certificacion.exceptions;

public class GeneralExceptions extends AssertionError{

    private static final long serialVersionUID = 1L;

    public static final String THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED = "The status code services response isn't expected";
    public static final String USER_NOT_FOUND = "User not found";

    //Constructor
    public GeneralExceptions(String message, Throwable cause){
        super(message, cause);
    }    public GeneralExceptions(String message){
        super(message);
    }
}
