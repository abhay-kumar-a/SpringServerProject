package com.axyya.newapplication.repository;

import com.axyya.newapplication.entity.Server;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ApplicationRepository extends MongoRepository<Server, BigInteger> {
//    @Query(value = "select s from Server as s where serverName=:serverName")
//    List<Server> getByName(@Param("serverName") String serverName);
    @Query("{'serverName' : { '$in':[?0]}}")
    List<Server> getByName(String name);

}
