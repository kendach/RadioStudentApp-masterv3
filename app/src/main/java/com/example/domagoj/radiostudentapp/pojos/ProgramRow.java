
package com.example.domagoj.radiostudentapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProgramRow {

    @SerializedName("ident")
    @Expose
    private Integer ident;
    @SerializedName("post_title")
    @Expose
    private String postTitle;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("descr")
    @Expose
    private String descr;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("start_ts")
    @Expose
    private String startTs;
    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("end_ts")
    @Expose
    private String endTs;
    @SerializedName("timing")
    @Expose
    private String timing;
    @SerializedName("img")
    @Expose
    private String img;

    public Integer getIdent() {
        return ident;
    }

    public void setIdent(Integer ident) {
        this.ident = ident;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTs() {
        return startTs;
    }

    public void setStartTs(String startTs) {
        this.startTs = startTs;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTs() {
        return endTs;
    }

    public void setEndTs(String endTs) {
        this.endTs = endTs;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
