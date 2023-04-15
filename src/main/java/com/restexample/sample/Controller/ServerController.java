package com.restexample.sample.Controller;

import com.restexample.sample.Model.Server;
import com.restexample.sample.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServerController {
    @Autowired
    ServerRepository repo;

    @GetMapping("/")
    public String getHome(){
        String response =  "API Specifications-" + System.lineSeparator() +
                "1. For all Servers = /servers\n" +
                "2. For getting Servers By Name = /servers/{name}\n" +
                "3. For posting Server = /server\n" +
                "4. For Getting Server By ID = /server/{ID}\n" +
                "5. For deleting Server By ID = /server/{ID}\n";
        return response;
    }
    //Get All Servers EndPoint
    //This Function will Return all Servers Stored on MongoDB database and return them
    @GetMapping("/servers")
    public List<Server> getAllServers(){
        try{
            List<Server> data = repo.findAll();
        }catch(Exception e){
            System.out.println(e);
        }

        return repo.findAll();
    }

    @PostMapping("/servers")
    public Server addSever(@RequestBody Server server){
        if(repo.existsById(server.getID())){
            throw new ResponseStatusException(
                   HttpStatus.CONFLICT, "Key already present"
            );
        }
        return repo.save(server);
    }

    @GetMapping("/server/{ID}")
    public Server getOneServer(@PathVariable String ID){
        Server S = repo.findByID(ID);
        if(S==null){

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return S;
    }
    @DeleteMapping("/server/{ID}")
    public String removeServer(@PathVariable String ID){
        Server S = repo.findAllByID(ID);
        if(S==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        repo.deleteByID(ID);
        return "";
    }

    @GetMapping("/servers/{name}")
    public List<Server> getServersByName(@PathVariable String name){
        List<Server> S = repo.findAllByName(name);
        if(S.size()==0){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return S;
    }

}
