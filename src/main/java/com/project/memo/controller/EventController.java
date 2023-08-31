package com.project.memo.controller;

import com.project.memo.entity.Event;
import com.project.memo.entity.ToDo;
import com.project.memo.entity.Tracker;
import com.project.memo.service.IEventService;
import com.project.memo.service.IToDoService;
import com.project.memo.service.ITrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class EventController extends BaseController {

    @Resource
    @Autowired
    private IEventService eventService;

    @Autowired
    private IToDoService toDoService;

    @Resource
    @Autowired
    private ITrackerService trackerService;

    @GetMapping("/index")
    public String index(Map<String, List> result, HttpSession session) {

        Integer userId = getUserIdFromSession(session);
        List<Event> Events=eventService.getAllEventByUserId(userId);
        result.put("events",Events);

        return "index";
    }

    @GetMapping("/detail/{eventId}")
    public String detail(Model model, @PathVariable Integer eventId, HttpSession session){
        Event events = eventService.getOneByEventId(eventId);
        session.setAttribute("eventId", events.getEventId());
        model.addAttribute("eventsInfo",events);
        List<Tracker> Trackers = trackerService.getAllByEventId(eventId);
        model.addAttribute("trackers",Trackers);
        Integer userId = getUserIdFromSession(session);
        List<ToDo> todos = toDoService.findTodosByEventId(eventId);
        model.addAttribute("todos", todos);
        return "detail";
    }

    @GetMapping("/login")
    public ModelAndView rotename(){
        log.info("login...");
        return new ModelAndView("login");
    }

    @RequestMapping("/{rotename}")
    public ModelAndView rotename(@PathVariable("rotename") String rotename){
        log.info("rotename...");
        return new ModelAndView(rotename);
    }

    @RequestMapping("/favicon.ico")
    @ResponseBody
    void favicon(){
    }
}
