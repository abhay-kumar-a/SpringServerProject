package com.axyya.newapplication.service;

import com.axyya.newapplication.entity.Server;
import com.axyya.newapplication.exception.ServerNotFoundException;
import com.axyya.newapplication.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationService {
    @Autowired
    ApplicationRepository repository;

    List<Server> list = new ArrayList<>();

   public List<Server> getService()
    {
        List<Server> services = repository.findAll();
        return services;
    }

    public Server getByID(Long id)
    {
         Optional<Server> server = repository.findById(id);

         if(server.isPresent())
         {
             return server.get();
         }
         else {
             throw new ServerNotFoundException("server not found" + id);
         }

    }
    public Server saveServerData(Server server)
     {
         return repository.save(server);
     }

     // delete data
   public void deleteServerData(Long id)  {
       repository.deleteById(id);
   }

     public  List<Server> getByName(String name)
     {
         List<Server> list1= repository.getByName(name);
         if(list1.isEmpty())
         {
             throw new ServerNotFoundException("server not found");
         }
         return list1;
     }
     public void updateServer(Server server , Long id)
     {
         list = list.stream().map(o -> {
             if(o.getServerId()==id)
             {
                 o.setServerName(server.getServerName());
                 o.setServerLanguage(server.getServerLanguage());
                 o.setServerFramework(server.getServerFramework());
             }
             return o;
         }).collect(Collectors.toList());
     }
}
