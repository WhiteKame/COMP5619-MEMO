package com.project.memo.service;

import com.project.memo.entity.Tracker;

import java.util.List;

public interface ITrackerService {
    void addNewTracker(Integer eventId, Tracker tracker);

    int updateTracker(Integer trackerId, Integer eventId, Tracker tracker);

    Tracker getOneByTrackerId(int trackerId);

    List<Tracker> getAllByEventId(Integer eventId);

    Integer trackerDelete(int eventId);
}