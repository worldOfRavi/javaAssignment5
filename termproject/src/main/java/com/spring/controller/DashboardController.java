package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.beans.Clients;
import com.spring.dao.ClientsDao;

@Controller
public class DashboardController {
    private final ClientsDao clientsDao;

    @Autowired
    public DashboardController(ClientsDao clientsDao) {
        this.clientsDao = clientsDao;
    }
    
    @GetMapping("/dashboard")
    public String home(Model model) {
        List<Clients> clients = clientsDao.findAllClients();
        
        // Print the list of users to the console
        for (Clients client : clients) {
            System.out.println("User ID: " + client.getId() + ", Username: " + client.getName() + ", Password: " + client.getPassword());
        }
        
        model.addAttribute("clients", clients);
        return "dashboard"; // return index.jsp
    }
}
