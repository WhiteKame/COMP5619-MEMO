package com.project.memo.service.exceptions;

public class TitleDuplicatedException extends ServiceException{
    public TitleDuplicatedException() {
        super();
    }

    public TitleDuplicatedException(String message) {
        super(message);
    }

    public TitleDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TitleDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected TitleDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
