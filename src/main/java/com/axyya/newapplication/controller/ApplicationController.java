package com.axyya.newapplication.controller;


import com.axyya.newapplication.entity.Server;
import com.axyya.newapplication.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/server")
    List<Server> getServer()
    {
        return applicationService.getService();
    }
    @GetMapping("/server/{s_id}")
    public Server getServer(@PathVariable Long s_id)
    {
        return applicationService.getByID(s_id);
    }
    @GetMapping("/byName/{s_name}")
    public List<Server> getByName(@PathVariable String s_name)
    {
        return applicationService.getByName(s_name);
    }
    @PostMapping("/server")
    Server saveData(@RequestBody Server server) {
        return applicationService.saveServerData(server);
    }

    @PutMapping("/server/{s_id}")
    public Server updateServer(@RequestBody Server server, @PathVariable Long s_id) {
        this.applicationService.updateServer(server,s_id);
        return applicationService.saveServerData(server);
    }

    @DeleteMapping("/server/{s_id}")
    void deleteServer(@PathVariable Long s_id)  {
        applicationService.deleteServerData(s_id);
    }



}
