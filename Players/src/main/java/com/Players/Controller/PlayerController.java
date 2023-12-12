package com.Players.Controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;
import org.springframework.http.ResponseEntity;

import com.Players.Entity.Players;
import com.Players.Service.PlayerService;

@RestController
@RequestMapping("/team")
public class PlayerController{
    @Autowired
    PlayerService playerService;
    @PostMapping("/add")
    public ResponseEntity<Players> addPlayer(@RequestBody Players player){
        Players addedPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(addedPlayer,HttpStatus.CREATED);
    }
    // @PutMapping("/update/{id}/{name}")
    // public ResponseEntity<Players> updatePlayers(@PathVariable String id, @PathVariable String name){
    //     Players updatedPlayer = playerService.updatePlayers(id,name);
    //     return ResponseEntity.ok(updatedPlayer);
    // }
    @PutMapping("/update")
    public ResponseEntity<Players> updatePlayers(@RequestBody Players player){
    Players updatedPlayer = playerService.updatePlayers(player);
    if (updatedPlayer != null) {
        return ResponseEntity.ok(updatedPlayer);
    } else {
        return ResponseEntity.notFound().build();
    }
}
    @GetMapping("/viewAll")
    public ResponseEntity<List<Players>> getAllPlayers(){
        List<Players> allPlayers = playerService.getAllPlayers();
        return new ResponseEntity<>(allPlayers,HttpStatus.OK);
    }
    @GetMapping("/viewById/{id}")
    public ResponseEntity<Players> viewById(@PathVariable String id){
        Optional<Players> findPlayer = playerService.viewById(id);
        if(findPlayer.isPresent()){
            return new ResponseEntity<>(findPlayer.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
  
    } 
    // @DeleteMapping("/remove")
    // public ResponseEntity<Players> removePlayer(@PathVariable String id){
    //     Players foundPlayer = playerService.removePlayer(id);
    //     return new ResponseEntity<>(foundPlayer,HttpStatus.OK);
    // }   
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Players> removePlayer(@PathVariable String id) {
        Players removedPlayer = playerService.removePlayer(id);
        if (removedPlayer != null) {
            return new ResponseEntity<>(removedPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }  
    
}

