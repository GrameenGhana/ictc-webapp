/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.wrapper;

/**
 *
 * @author Joseph George Davis
 * @date Aug 30, 2015 2:14:07 PM
 * description:
 */
public class MeetingWrapper {
    
    String type = "type";
    String meetingIndex ="index";
    String season ="season";
    String startDate = "startdate";
    String endDate ="enddate";
    String attended="attended";

    public String getAttended() {
        return attended;
    }

    public void setAttended(String attended) {
        this.attended = attended;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMeetingIndex() {
        return meetingIndex;
    }

    public void setMeetingIndex(String meeting) {
        this.meetingIndex = meeting;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    

}
