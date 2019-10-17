package com.stackroute.musicplayer.controller;

import com.stackroute.musicplayer.domain.Music;
import com.stackroute.musicplayer.exceptions.TrackAlreadyExistsException;
import com.stackroute.musicplayer.exceptions.TrackNotFoundException;
import com.stackroute.musicplayer.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1")
public class MusicController {
   private MusicService musicService;

   @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveMusic(@RequestBody Music music){
        ResponseEntity responseEntity;
        try {
            musicService.saveMusic(music);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }
        catch (Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("track")
    public ResponseEntity<?> getAllMusic(){
        ResponseEntity<Object> responseEntity;
        try{
            responseEntity = new ResponseEntity<Object>(musicService.getAllMusic(), HttpStatus.CREATED);
        }catch (Exception ex) {
            responseEntity = new ResponseEntity<Object>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("track/{id}")
    public  ResponseEntity<?> updateComments(@PathVariable(value = "id") int id,@Valid @RequestBody Music music) throws TrackNotFoundException {
        ResponseEntity<?> responseEntity;
        Optional<Music> track1 = musicService.getTrackById(id);
        try{
            if(!track1.isPresent()){
                throw new Exception("id-"+id);
            }
            music.setId(id);
            musicService.saveMusic(music);
            responseEntity = new ResponseEntity<Object> (musicService.getAllMusic(), HttpStatus.CREATED);
        }catch (Exception ex) {
            responseEntity = new ResponseEntity<Object> (ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int Id){
        ResponseEntity<Object> responseEntity;
        try{
            musicService.deleteTrack(Id);
            responseEntity = new ResponseEntity<Object>(musicService.getAllMusic(), HttpStatus.CREATED);
        }catch (Exception ex) {
            responseEntity = new ResponseEntity<Object>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;    }

    @GetMapping("search/{name}")
    public ResponseEntity<?> searchTrack(@PathVariable String name) throws TrackAlreadyExistsException, TrackNotFoundException
    {


        ResponseEntity responseEntity;
        responseEntity= new ResponseEntity<List<Music>>(musicService.trackByName(name), HttpStatus.CREATED);
        return responseEntity;
    }




}
