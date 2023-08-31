package com.project.memo.controller;

import com.project.memo.service.exceptions.InsertException;
import com.project.memo.service.exceptions.ServiceException;
import com.project.memo.service.exceptions.TitleDuplicatedException;
import com.project.memo.service.exceptions.TrackerCountLimitException;
import com.project.memo.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {
    public static final int OK = 200;

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof TitleDuplicatedException) {
            result.setState(4000);
            result.setMessage("Event title exist! ");
        } else if (e instanceof TrackerCountLimitException) {
            result.setState(4001);
            result.setMessage("Tracker amount is above limit! ");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("Unknown issue when insert data! ");
        }
        return result;
    }

    protected final Integer getUserIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    protected final Integer getEventIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("eventId").toString());
    }

    protected final Integer getTrackerIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("trackerId").toString());
    }
}
