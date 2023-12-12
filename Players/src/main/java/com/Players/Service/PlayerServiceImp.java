package com.Players.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Players.Entity.Players;
import com.Players.Repository.PlayerRepository;
@Service
public class PlayerServiceImp implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Players addPlayer(Players player) {
        return playerRepository.save(player);
        
    }
    public Players updatePlayers(Players player){
        Optional<Players> optionalPlayer = playerRepository.findById(player.getId());
        if(optionalPlayer.isPresent()){
            Players existingPlayer = optionalPlayer.get();
            existingPlayer.setName(player.getName());
            Players updatedPlayers = playerRepository.save(existingPlayer);
            return updatedPlayers;

        }else{
            return null;
        }


    }

    public List<Players> getAllPlayers(){
        return playerRepository.findAll();
    }
    @Override
    public Optional<Players> viewById(String id) {
        
        Optional<Players> foundPlayer = playerRepository.findById(id);
        return playerRepository.findById(id);

    }

    public Players removePlayer(String id) {
        Optional<Players> playerToRemove = playerRepository.findById(id);
        if (playerToRemove.isPresent()) {
            playerRepository.deleteById(id);
            return playerToRemove.get();
        }
        return null;
    }
    
}
