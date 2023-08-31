package com.project.memo.mapper;

import com.project.memo.entity.Tracker;

import java.util.List;

public interface TrackerMapper {
    Integer insert(Tracker tracker);

    Integer countByEventId(Integer eventId);

    public int updateTracker(Tracker tracker);

    Tracker getOneByTrackerId(int trackerId);

    List<Tracker> getAllByEventId(Integer eventId);

    Integer trackerDelete(int trackerId);
}
