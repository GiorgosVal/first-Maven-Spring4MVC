/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amavenspringjpa.controllers;

import com.mycompany.amavenspringjpa.dao.TrainerDao;
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
    
    /*
    
    3. ΓIA UPDATE trainer
        - Το button θα οδηγεί στο /trainers/update/{id} σε μέθοδο GET
          και εκεί θα μου εμφανίζει view με τα στοιχεία του trainer
        - Στο submit της φόρμας θα πηγαίνει στο /trainers/update σε μέθοδο POST
          και εκεί θα κάνω update του trainer (και του κωδικού του). Όταν τελείωσει θα πρέπει να
          εμφανίζω μήνυμα επιτυχίας και να κάνω redirect στο /trainers
    
    4. ΓΙΑ DELETE trainer
        - Το button θα οδηγεί στο /trainers/delete/{id} σε μέθοδο GET
          και εκεί θα γίνεται το delete, και μετά redirect στο /trainers
    
    INSERT
    SELECT
        
    */
    
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
        model.addAttribute("action", "");
        return "trainerAdd";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveTrainer(@Valid Trainer trainer, BindingResult result, ModelMap model) {
        
        if(result.hasErrors()) {
            return "trainerAdd";
        }
        tserv.addTrainer(trainer);
        model.addAttribute("success", "Trainer added successfully.");
        model.addAttribute("path", "1; URL=../trainers");
        return "success";
    }
    
    // UPDATE
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateTrainer(ModelMap model, @PathVariable String id) {
        Trainer t = tserv.getTrainerById(Integer.parseInt(id));
        model.addAttribute("title", "Update Trainer");
        model.addAttribute("action", "../update");
        model.addAttribute("trainer", t);
        return "trainerAdd";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateTrainer(@Valid Trainer trainer, BindingResult result, ModelMap model) {
        
        if(result.hasErrors()) {
            return "trainerAdd";
        }
        tserv.updateTrainer(trainer);
        model.addAttribute("success", "Trainer updated successfully.");
        model.addAttribute("path", "1; URL=../trainers");
        return "success";
    }
    
    // DELETE
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(ModelMap model, @PathVariable String id) {
        tserv.deleteTrainer(Integer.parseInt(id));
        model.addAttribute("success", "Trainer deleted successfully.");
        model.addAttribute("path", "1; URL=../");
        return "success";
    }
    
    
    
    
    
    
    
    
}
