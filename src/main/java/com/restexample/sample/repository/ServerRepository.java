package com.restexample.sample.repository;

import com.restexample.sample.Model.Server;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServerRepository extends MongoRepository<Server,String> {

    Server findByID(String ID);
    void deleteByID(String ID);

    List<Server> findAllByName(String name);

    Server findAllByID(String id);
}
