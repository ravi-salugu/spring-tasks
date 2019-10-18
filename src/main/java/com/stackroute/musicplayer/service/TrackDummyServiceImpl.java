package com.stackroute.musicplayer.service;

import com.stackroute.musicplayer.domain.Music;
import com.stackroute.musicplayer.exceptions.TrackAlreadyExistsException;
import com.stackroute.musicplayer.exceptions.TrackNotFoundException;
import com.stackroute.musicplayer.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TrackDummyServiceImpl implements MusicService{
    private MusicRepository musicrepository;
    @Autowired
    public TrackDummyServiceImpl(MusicRepository musicrepository){
        this.musicrepository=musicrepository;
    }
    @Override
    public Music saveMusic(Music music) throws TrackAlreadyExistsException {
        if(musicrepository.existsById(music.getId())){
            throw new TrackAlreadyExistsException("dummy Track Already exists");
        }
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
    public void deleteTrack(int Id) throws TrackNotFoundException {

        if(!musicrepository.existsById(Id)){
            throw new TrackNotFoundException("dummy Track Not Found");
        }
        musicrepository.deleteById(Id);

    }

    @Override
    public Optional<Music> getTrackById(int id) throws TrackNotFoundException{
        if(!musicrepository.existsById(id)){
            throw new TrackNotFoundException("dummy Track Not Found");
        }
        return musicrepository.findById(id);
    }


    public List<Music> trackByName(String trackName) throws TrackNotFoundException {
        List<Music> tracks = musicrepository.trackByName(trackName);
        if(tracks.size()==0)
            throw new TrackNotFoundException("dummy Track Not Found ");
        else
            return tracks;
    }
}
