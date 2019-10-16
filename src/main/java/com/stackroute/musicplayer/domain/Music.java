package com.stackroute.musicplayer.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    int Id;
    String songName;
    String comments;

    public Music() {
    }

    public Music(int id, String songName, String comments) {
        this.Id = id;
        this.songName = songName;
        this.comments = comments;
    }

    public int getId() {
        return Id;
    }

    public String getSongName() {
        return songName;
    }

    public String getComments() {
        return comments;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Music{" +
                "Id=" + Id +
                ", songName='" + songName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
