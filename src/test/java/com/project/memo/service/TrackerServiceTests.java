package com.project.memo.service;

import com.project.memo.entity.Tracker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrackerServiceTests {

    @Autowired
    private ITrackerService trackerService;

    @Test
    public void addNewTracker() {
        Tracker tracker = new Tracker();
        tracker.setTrackerDate(78);
        tracker.setTrackerTitle("测试标题66636");
        tracker.setTrackerStatus(true);
        trackerService.addNewTracker(61, tracker);
    }
}
