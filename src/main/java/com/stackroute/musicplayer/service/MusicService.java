package com.stackroute.musicplayer.service;

import com.stackroute.musicplayer.domain.Music;

import java.util.List;
import java.util.Optional;

public interface MusicService {

    public Music saveMusic(Music music);
    public List<Music> getAllMusic();

    public Music updateComments(Music music);
    public boolean deleteTrack(int Id);
    public Optional<Music> getTrackById(int id);

}
