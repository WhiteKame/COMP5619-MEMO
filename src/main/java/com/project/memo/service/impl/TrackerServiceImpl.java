package com.project.memo.service.impl;

import com.project.memo.entity.Tracker;
import com.project.memo.mapper.TrackerMapper;
import com.project.memo.service.ITrackerService;
import com.project.memo.service.exceptions.InsertException;
import com.project.memo.service.exceptions.TrackerCountLimitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackerServiceImpl implements ITrackerService {
    @Autowired
    private TrackerMapper trackerMapper;

    @Value("${user.tracker.max-count}")
    private Integer maxTrackerCount;

    @Override
    public void addNewTracker( Integer eventId, Tracker tracker) {
        Integer count = trackerMapper.countByEventId(eventId);
        if (count >= maxTrackerCount) {
            throw new TrackerCountLimitException("Amount of trackers is above the limit! ");
        }

        tracker.setEventId(eventId);

        Integer rows = trackerMapper.insert(tracker);
        if (rows != 1) {
            throw new InsertException("Unknown issue when insert the tracker! ");
        }
    }

    public int updateTracker(Integer trackerId, Integer eventId, Tracker tracker) {
        tracker.setTrackerId(trackerId);
        tracker.setEventId(eventId);
        return trackerMapper.updateTracker(tracker);
    }

    @Override
    public Tracker getOneByTrackerId(int trackerId) {
        return trackerMapper.getOneByTrackerId(trackerId);
    }

    @Override
    public List<Tracker> getAllByEventId(Integer eventId) {
        return trackerMapper.getAllByEventId(eventId);
    }

    @Override
    public Integer trackerDelete(int trackerId) {
        return trackerMapper.trackerDelete(trackerId);
    }
}