/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amavenspringjpa.services;

import com.mycompany.amavenspringjpa.dao.TrainerDao;
import com.mycompany.amavenspringjpa.entities.Trainer;
import java.util.List;

/**
 *
 * @author giorgos
 */
public class TrainerService {
    
    TrainerDao tdao = new TrainerDao();
    
    public List<Trainer> getTrainers(){
        return tdao.getTrainers();
    }
    
    public Trainer getTrainerById(Integer id) {
        return tdao.getTrainerById(id);
    }
    
    public boolean addTrainer(Trainer t) {
        return tdao.addTrainer(t);
    }
    
    public boolean updateTrainer(Trainer t){
        return tdao.updateTrainer(t);
    }
    
    public boolean deleteTrainer(Integer id) {
        return tdao.deleteTrainer(id);
    }
}
