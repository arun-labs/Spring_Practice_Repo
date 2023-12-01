package com.Players.Repository;
import com.Players.Entity.Players;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface PlayerRepository extends MongoRepository<Players,String> {
    Optional<Players> findById(String id);
    
}
