package com.stackroute.musicplayer.seeds;

import com.stackroute.musicplayer.domain.Music;
import com.stackroute.musicplayer.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    MusicRepository musicRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Music music=new Music(0,"November Rain","by GnR");
        musicRepository.save(music);

    }
}
