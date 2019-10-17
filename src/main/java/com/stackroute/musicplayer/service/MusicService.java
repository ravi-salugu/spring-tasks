package com.stackroute.musicplayer.service;

import com.stackroute.musicplayer.domain.Music;
import com.stackroute.musicplayer.exceptions.TrackAlreadyExistsException;
import com.stackroute.musicplayer.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface MusicService {

    public Music saveMusic(Music music) throws TrackAlreadyExistsException;
    public List<Music> getAllMusic();

    public Music updateComments(Music music);
    public void deleteTrack(int Id) throws TrackNotFoundException;
    public Optional<Music> getTrackById(int id) throws TrackNotFoundException;
    public List<Music> trackByName(String name) throws TrackNotFoundException;
}
