package com.project.memo.entity;


import lombok.Data;
import org.thymeleaf.util.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@Table(name="trackerinfo")
public class Tracker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer trackerId;
  private String trackerTitle;
  private Integer trackerDate;
  private String trackerStatus;
  private Integer eventId;
  @Column(columnDefinition="bit(1) default 0 ")
  private Boolean trackerMon;
  @Column(columnDefinition="bit(1) default 0 ")
  private Boolean trackerTue;
  @Column(columnDefinition="bit(1) default 0 ")
  private Boolean trackerWed;
  @Column(columnDefinition="bit(1) default 0 ")
  private Boolean trackerThu;
  @Column(columnDefinition="bit(1) default 0 ")
  private Boolean trackerFri;
  @Column(columnDefinition="bit(1) default 0 ")
  private Boolean trackerSat;
  @Column(columnDefinition="bit(1) default 0 ")
  private Boolean trackerSun;

}
