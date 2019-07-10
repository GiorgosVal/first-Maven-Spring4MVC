/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amavenspringjpa.helpful;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author giorgos
 */
public class Username {
    
    public String createUsername(String type, String last_name, String first_name, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        StringBuilder username = new StringBuilder(type)
                .append("-")
                .append(last_name.substring(0, 4))
                .append("-")
                .append(first_name.substring(0, 2))
                .append("-")
                .append(sdf.format(date).substring(5));
        return username.toString();
    }
    
    public String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyy");
        return sdf.format(date);
    }
    
}
