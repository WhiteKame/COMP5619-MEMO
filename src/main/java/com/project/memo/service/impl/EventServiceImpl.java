package com.project.memo.service.impl;

import com.project.memo.entity.Event;
import com.project.memo.entity.Tracker;
import com.project.memo.mapper.EventMapper;
import com.project.memo.service.IEventService;
import com.project.memo.service.exceptions.InsertException;
import com.project.memo.service.exceptions.TitleDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements IEventService {
    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<Event> getAll() {
        return eventMapper.getAll();
    }

    @Override
    public Event getOneByEventId(int eventId) {
        return eventMapper.getOneByEventId(eventId);
    }

    @Override
    public Event getOneByEventTitle(String title) {
        return eventMapper.getOneByEventTitle(title);
    }

    @Override
    public void newEvent(Integer userId, Event event) {
        String eventTitle = event.getTitle();
        Event result = eventMapper.getOneByEventTitle(eventTitle);
        if (result != null) {
            throw new TitleDuplicatedException("Event Title exist! ");
        }
        event.setUserId(userId);
        Integer rows = eventMapper.insert(event);
        if (rows != 1) {
            throw new InsertException("Unknown issue when insert event! ");
        }
    }

    @Override
    public Event findByEventId(int eventId) {
        return eventMapper.getOneByEventId(eventId);
    }

    @Override
    public Integer delete(int eventId) {
        eventMapper.deleteTracker(eventId);
        return eventMapper.delete(eventId);
    }

    @Override
    public int save(Integer userId, Event event) {
        event.setUserId(userId);
        return eventMapper.save(event);
    }

    public int update(Integer eventId, Integer userId, Event event) {
        event.setEventId(eventId);
        event.setUserId(userId);
        return eventMapper.update(event);
    }

    @Override
    public List<Event> getAllEventByUserId(Integer userId) {
        return eventMapper.getAllEventByUserId(userId);
    }
}