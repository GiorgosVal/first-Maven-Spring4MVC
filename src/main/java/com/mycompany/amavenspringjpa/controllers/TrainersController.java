/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amavenspringjpa.controllers;

import com.mycompany.amavenspringjpa.entities.Trainer;
import com.mycompany.amavenspringjpa.services.TrainerService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author giorgos
 */
@Controller
@RequestMapping(value = {"/trainers"})
public class TrainersController {
    TrainerService tserv = new TrainerService();
    
    
    // READ
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getTrainers(ModelMap model) {
        model.addAttribute("trainers", tserv.getTrainers());
        return "trainers";
    }
    
    // INSERT
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newTrainer(ModelMap model) {
        model.addAttribute("trainer", new Trainer());
        model.addAttribute("title", "Add a new Trainer");
        model.addAttribute("action", "save");
        return "trainerAdd";
    }
    
    // UPDATE
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateTrainer(ModelMap model, @PathVariable String id) {
        Trainer t = tserv.getTrainerById(Integer.parseInt(id));
        model.addAttribute("title", "Update Trainer");
        model.addAttribute("action", "../save");
        model.addAttribute("trainer", t);
        return "trainerAdd";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTrainer(@Valid Trainer trainer, BindingResult result, ModelMap model) {
        
        if(result.hasErrors()) {
            return "trainerAdd";
        }
        
        if(trainer.getId() == null) {
            tserv.addTrainer(trainer);
            model.addAttribute("success", "Trainer added successfully.");
        } else {
            tserv.updateTrainer(trainer);
            model.addAttribute("success", "Trainer updated successfully.");
        }
        
        model.addAttribute("path", "1; URL=http://localhost:8084/aMavenSpringJPA/trainers/");
        return "success";
    }
    
    
    
    // DELETE
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(ModelMap model, @PathVariable String id) {
        tserv.deleteTrainer(Integer.parseInt(id));
        model.addAttribute("success", "Trainer deleted successfully.");
        model.addAttribute("path", "1; URL=http://localhost:8084/aMavenSpringJPA/trainers/");
        return "success";
    }
    
    
    
    
    
    
    
    
}
