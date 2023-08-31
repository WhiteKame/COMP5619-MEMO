package com.project.memo.service;

import com.project.memo.entity.Event;
import com.project.memo.entity.Tracker;

import java.util.List;

public interface IEventService {
    List<Event> getAll();

    Event getOneByEventId(int eventId);

    Event getOneByEventTitle(String title);

    void newEvent(Integer userId, Event event);

    Event findByEventId(int eventId);

    Integer delete(int eventId);

    int save(Integer userId, Event event);

    int update(Integer eventId, Integer userId, Event event);

    List<Event> getAllEventByUserId(Integer userId);
}