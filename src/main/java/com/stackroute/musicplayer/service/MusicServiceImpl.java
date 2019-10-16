package com.stackroute.musicplayer.service;

import com.stackroute.musicplayer.domain.Music;
import com.stackroute.musicplayer.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
@Service
public class MusicServiceImpl implements MusicService {

    MusicRepository musicrepository;
    @Autowired
    public MusicServiceImpl(MusicRepository musicrepository){
        this.musicrepository=musicrepository;
    }
    @Override
    public Music saveMusic(Music music) {
        Music saveMusic=musicrepository.save(music);

        return saveMusic;
    }

    @Override
    public List<Music> getAllMusic() {
        return musicrepository.findAll();
    }

    @Override
    public Music updateComments(Music music) {
        return musicrepository.save(music);
    }

    @Override
    public boolean deleteTrack(int Id) {
        musicrepository.deleteById(Id);
        return true;
    }

    @Override
    public Optional<Music> getTrackById(int id) {
        return musicrepository.findById(id);
    }
}
