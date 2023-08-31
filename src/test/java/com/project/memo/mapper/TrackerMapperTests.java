package com.project.memo.mapper;

import com.project.memo.entity.Tracker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrackerMapperTests {

    @Autowired
    private TrackerMapper trackerMapper;

    @Test
    public void insert() {
        Tracker tracker = new Tracker();
        tracker.setTrackerDate(4);
        tracker.setTrackerTitle("测试标题");
        tracker.setTrackerStatus(false);
        tracker.setEventId(57);
        trackerMapper.insert(tracker);
    }

    @Test
    public void countByEventId() {
        Integer count = trackerMapper.countByEventId(11);
        System.out.println(count);

    }


}
