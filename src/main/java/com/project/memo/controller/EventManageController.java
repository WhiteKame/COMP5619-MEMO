package com.project.memo.controller;

import com.project.memo.entity.Event;
import com.project.memo.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class EventManageController extends BaseController {

    @Autowired
    private IEventService eventService;

    @PostMapping("/add")
    public String save(Event event, HttpSession session) {
        Integer userId = getUserIdFromSession(session);
        eventService.save(userId, event);
        return "redirect:/index";
    }

    @RequestMapping("/delete/{eventId}")
    public String delete(@PathVariable int eventId, HttpServletResponse servletResponse) throws IOException {
        eventService.delete(eventId);
        return "redirect:/index";
    }

    @GetMapping("/updatePage/{eventId}")
    public String updatePage(Model model, @PathVariable int eventId){
        Event events = eventService.getOneByEventId(eventId);
        model.addAttribute("events",events);
        return "modifie";
    }

    @PostMapping("/updateEvent")
    public String updateEvent(Model model, Event event, HttpSession session) {
        Integer userId = getUserIdFromSession(session);
        Integer eventId = getEventIdFromSession(session);
        eventService.update(eventId, userId, event);
        return "redirect:/detail/" + eventId;
    }
}
