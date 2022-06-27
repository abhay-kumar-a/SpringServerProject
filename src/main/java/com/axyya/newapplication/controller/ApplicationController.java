package com.axyya.newapplication.controller;


import com.axyya.newapplication.entity.Server;
import com.axyya.newapplication.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/server")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    // Show data
    @GetMapping("")
    public String  getServer(Model model)
    {
        List<Server> serverList= applicationService.getAllServer();
        model.addAttribute("list",serverList);
        return "index";
    }

    @GetMapping("/{s_id}")
    public String getServer(@PathVariable BigInteger s_id,Model model)
    {
        model.addAttribute("list",applicationService.getByID(s_id));
        return "index";
    }
    @GetMapping("/byName/{s_name}")
    public String getByName(@PathVariable String s_name,Model model)
    {
        model.addAttribute("list", applicationService.getByName(s_name));
        return "index";
    }

    // Add data
    @GetMapping("/showData")
    public String showData( Model model)
    {
        Server server = new Server();
        model.addAttribute("server",server);
        return "addData";
    }

    @PostMapping("")
     public String  saveData(@ModelAttribute("server") Server server) {
          applicationService.saveData(server);
         return "redirect:/server";
    }

    // Update data
    @GetMapping("/showUpdateData/{s_id}")
    public String updateData(@PathVariable BigInteger s_id ,Model model)
    {
        Server server = applicationService.getByID(s_id);
        model.addAttribute("server",server);
        return "update_server";
    }

    //Delete Data
    @GetMapping("/deleteData/{s_id}")
    public String deleteData(@PathVariable BigInteger s_id)
    {
        this.applicationService.deleteData(s_id);
        return "redirect:/server";
    }
}
