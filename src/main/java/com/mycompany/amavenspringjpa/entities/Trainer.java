/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amavenspringjpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author giorgos
 */
@Entity
@Table(name = "trainers", catalog = "assignment2", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tfname", "tlname", "tdob", "username"})
    , @UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t")
    , @NamedQuery(name = "Trainer.findById", query = "SELECT t FROM Trainer t WHERE t.id = :id")
    , @NamedQuery(name = "Trainer.findByTfname", query = "SELECT t FROM Trainer t WHERE t.tfname = :tfname")
    , @NamedQuery(name = "Trainer.findByTlname", query = "SELECT t FROM Trainer t WHERE t.tlname = :tlname")
    , @NamedQuery(name = "Trainer.findByTsubject", query = "SELECT t FROM Trainer t WHERE t.tsubject = :tsubject")
    , @NamedQuery(name = "Trainer.findByTdob", query = "SELECT t FROM Trainer t WHERE t.tdob = :tdob")
    , @NamedQuery(name = "Trainer.findByUsername", query = "SELECT t FROM Trainer t WHERE t.username = :username")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(nullable = false, length = 15)
    private String tfname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(nullable = false, length = 25)
    private String tlname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String tsubject;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tdob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String username;

    public Trainer() {
    }

    public Trainer(Integer id) {
        this.id = id;
    }

    public Trainer(Integer id, String tfname, String tlname, String tsubject, Date tdob, String username) {
        this.id = id;
        this.tfname = tfname;
        this.tlname = tlname;
        this.tsubject = tsubject;
        this.tdob = tdob;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTfname() {
        return tfname;
    }

    public void setTfname(String tfname) {
        this.tfname = tfname;
    }

    public String getTlname() {
        return tlname;
    }

    public void setTlname(String tlname) {
        this.tlname = tlname;
    }

    public String getTsubject() {
        return tsubject;
    }

    public void setTsubject(String tsubject) {
        this.tsubject = tsubject;
    }

    public Date getTdob() {
        return tdob;
    }

    public void setTdob(Date tdob) {
        this.tdob = tdob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.amavenspringjpa.entities.Trainer[ id=" + id + " ]";
    }
    
}
