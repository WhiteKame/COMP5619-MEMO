package com.project.memo.service.exceptions;

public class TrackerCountLimitException extends ServiceException {
    public TrackerCountLimitException() {
        super();
    }

    public TrackerCountLimitException(String message) {
        super(message);
    }

    public TrackerCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrackerCountLimitException(Throwable cause) {
        super(cause);
    }

    protected TrackerCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
