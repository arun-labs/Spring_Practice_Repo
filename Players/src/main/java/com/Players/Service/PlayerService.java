package com.Players.Service;

import java.util.List;
import java.util.Optional;

import com.Players.Entity.Players;

public interface PlayerService {
    Players addPlayer(Players player);
    
    Players updatePlayers(Players player);
    
    List<Players> getAllPlayers();

    Optional<Players> viewById(String id);

    // Players removPlayers
}
