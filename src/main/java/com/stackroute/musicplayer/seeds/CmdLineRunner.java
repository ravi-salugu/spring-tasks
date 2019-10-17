package com.stackroute.musicplayer.seeds;

import com.stackroute.musicplayer.domain.Music;
import com.stackroute.musicplayer.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdLineRunner implements CommandLineRunner {
    @Autowired
    MusicRepository musicRepository;
    @Override
    public void run(String... args) throws Exception {

        Music music=new Music(2,"Rover","LedZep");
        musicRepository.save(music);

    }
}
