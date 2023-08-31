package com.project.memo.vo;

import java.io.Serializable;

public class ItemVO implements Serializable {
    private Integer eventId;

    private Integer trackerId;

    private Integer toDoListId;

//    Event
    private String title;

    private String content;

//    Tracker
    private String trackerTitle;

    private Integer trackerDate;

    private Integer trackerStatus;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(Integer trackerId) {
        this.trackerId = trackerId;
    }

    public Integer getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(Integer toDoListId) {
        this.toDoListId = toDoListId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTrackerTitle() {
        return trackerTitle;
    }

    public void setTrackerTitle(String trackerTitle) {
        this.trackerTitle = trackerTitle;
    }

    public Integer getTrackerDate() {
        return trackerDate;
    }

    public void setTrackerDate(Integer trackerDate) {
        this.trackerDate = trackerDate;
    }

    public Integer getTrackerStatus() {
        return trackerStatus;
    }

    public void setTrackerStatus(Integer trackerStatus) {
        this.trackerStatus = trackerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemVO)) return false;

        ItemVO itemVO = (ItemVO) o;

        if (getEventId() != null ? !getEventId().equals(itemVO.getEventId()) : itemVO.getEventId() != null)
            return false;
        if (getTrackerId() != null ? !getTrackerId().equals(itemVO.getTrackerId()) : itemVO.getTrackerId() != null)
            return false;
        if (getToDoListId() != null ? !getToDoListId().equals(itemVO.getToDoListId()) : itemVO.getToDoListId() != null)
            return false;
        if (getTitle() != null ? !getTitle().equals(itemVO.getTitle()) : itemVO.getTitle() != null) return false;
        if (getContent() != null ? !getContent().equals(itemVO.getContent()) : itemVO.getContent() != null)
            return false;
        if (getTrackerTitle() != null ? !getTrackerTitle().equals(itemVO.getTrackerTitle()) : itemVO.getTrackerTitle() != null)
            return false;
        if (getTrackerDate() != null ? !getTrackerDate().equals(itemVO.getTrackerDate()) : itemVO.getTrackerDate() != null)
            return false;
        return getTrackerStatus() != null ? getTrackerStatus().equals(itemVO.getTrackerStatus()) : itemVO.getTrackerStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getEventId() != null ? getEventId().hashCode() : 0;
        result = 31 * result + (getTrackerId() != null ? getTrackerId().hashCode() : 0);
        result = 31 * result + (getToDoListId() != null ? getToDoListId().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        result = 31 * result + (getTrackerTitle() != null ? getTrackerTitle().hashCode() : 0);
        result = 31 * result + (getTrackerDate() != null ? getTrackerDate().hashCode() : 0);
        result = 31 * result + (getTrackerStatus() != null ? getTrackerStatus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ItemVO{" +
                "eventId=" + eventId +
                ", trackerId=" + trackerId +
                ", toDoListId=" + toDoListId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", trackerTitle='" + trackerTitle + '\'' +
                ", trackerDate=" + trackerDate +
                ", trackerStatus=" + trackerStatus +
                '}';
    }
}
