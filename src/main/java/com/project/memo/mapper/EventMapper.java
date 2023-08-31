package com.project.memo.mapper;

import com.project.memo.entity.Event;
import com.project.memo.entity.Tracker;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EventMapper{
    List<Event> getAll();

    Event getOneByEventId(int eventId);

    Event getOneByEventTitle(String title);

    Integer insert(Event event);

    public int delete(int eventId);

    public int deleteTracker(int eventId);

    int save(Event event);

    public int update(Event event);

    List<Event> getAllEventByUserId(Integer userId);
}