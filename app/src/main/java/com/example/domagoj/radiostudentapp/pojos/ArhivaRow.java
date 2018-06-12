
package com.example.domagoj.radiostudentapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArhivaRow {

    @SerializedName("redni")
    @Expose
    private String redni;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("played_song")
    @Expose
    private String playedSong;
    @SerializedName("played_time")
    @Expose
    private String playedTime;

    public String getRedni() {
        return redni;
    }

    public void setRedni(String redni) {
        this.redni = redni;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayedSong() {
        return playedSong;
    }

    public void setPlayedSong(String playedSong) {
        this.playedSong = playedSong;
    }

    public String getPlayedTime() {
        return playedTime;
    }

    public void setPlayedTime(String playedTime) {
        this.playedTime = playedTime;
    }

}
