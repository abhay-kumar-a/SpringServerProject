package com.axyya.newapplication.repository;

import com.axyya.newapplication.entity.Server;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends MongoRepository<Server,Long> {
    @Query("{'serverName' : { '$in':[?0]}}")
    List<Server> getByName(String name);

   // Server findByName(String name);

}
