package com.project.memo.controller;

import com.project.memo.entity.Tracker;
import com.project.memo.service.ITrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class TrackerController extends BaseController{

    @Autowired
    private ITrackerService trackerService;

    @RequestMapping("add_new_tracker")
    public String addNewTracker(Model model, Tracker tracker, HttpSession session) {
        Integer eventId = getEventIdFromSession(session);
        trackerService.addNewTracker(eventId, tracker);
        return "redirect:/detail/" + eventId;
    }

    @RequestMapping("/trackerDelete/{trackerId}")
    public String delete(@PathVariable int trackerId, HttpSession session) throws IOException {
        trackerService.trackerDelete(trackerId);
        Integer eventId = getEventIdFromSession(session);
        return "redirect:/detail/" + eventId;
    }

    @GetMapping("/updateTracker/{trackerId}")
    public String updateTrackerPage(Model model, @PathVariable int trackerId, HttpSession session){
        Tracker trackerDetail = trackerService.getOneByTrackerId(trackerId);
        session.setAttribute("trackerId", trackerDetail.getTrackerId());
        model.addAttribute("trackerDetail",trackerDetail);
        return "modifieTracker";
    }

    @PostMapping("/updateTracker")
    public String updateTracker(Model model, Tracker tracker, HttpSession session) {
        Integer trackerId = getTrackerIdFromSession(session);
        Integer eventId = getEventIdFromSession(session);
        trackerService.updateTracker(trackerId, eventId, tracker);
        return "redirect:/detail/" + eventId;
    }

}
