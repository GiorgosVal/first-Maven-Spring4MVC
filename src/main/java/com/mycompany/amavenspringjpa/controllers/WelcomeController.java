/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amavenspringjpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author giorgos
 */
@Controller
@RequestMapping (value = "")
public class WelcomeController {
    
    @RequestMapping (method = RequestMethod.GET)
    public String goToTrainers() {
        return "redirect:/trainers";
    }
    
    
    
    
    
}
