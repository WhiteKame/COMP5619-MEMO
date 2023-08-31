package com.project.memo.entity;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name="eventinfo")
@Entity
@Table(name="eventinfo")
public class Event implements Serializable {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer eventId;

  private String title;

  private String content;

  private Integer userId;

  public Integer getEventId() {
    return eventId;
  }

  public void setEventId(Integer eventId) {
    this.eventId = eventId;
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

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Event)) return false;

    Event event = (Event) o;

    if (getEventId() != null ? !getEventId().equals(event.getEventId()) : event.getEventId() != null) return false;
    if (getTitle() != null ? !getTitle().equals(event.getTitle()) : event.getTitle() != null) return false;
    if (getContent() != null ? !getContent().equals(event.getContent()) : event.getContent() != null) return false;
    return getUserId() != null ? getUserId().equals(event.getUserId()) : event.getUserId() == null;
  }

  @Override
  public int hashCode() {
    int result = getEventId() != null ? getEventId().hashCode() : 0;
    result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
    result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
    result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Event{" +
            "eventId=" + eventId +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", userId=" + userId +
            '}';
  }
}