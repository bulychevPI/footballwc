/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.footballwc.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "goal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Goal.findAll", query = "SELECT g FROM Goal g"),
    @NamedQuery(name = "Goal.findByIdGoal", query = "SELECT g FROM Goal g WHERE g.idGoal = :idGoal"),
    @NamedQuery(name = "Goal.findByMinute", query = "SELECT g FROM Goal g WHERE g.minute = :minute"),
    @NamedQuery(name = "Goal.findByPenalties", query = "SELECT g FROM Goal g WHERE g.penalties = :penalties")})
public class Goal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGoal")
    private Integer idGoal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "minute")
    private int minute;
    @Column(name = "Penalties")
    private Boolean penalties;
    @JoinColumn(name = "idPlayer", referencedColumnName = "idPlayer")
    @ManyToOne(optional = false)
    private Player idPlayer;
    @JoinColumn(name = "idMatch", referencedColumnName = "idMatch")
    @ManyToOne(optional = false)
    private Match idMatch;

    public Goal() {
    }

    public Goal(Integer idGoal) {
        this.idGoal = idGoal;
    }

    public Goal(Integer idGoal, int minute) {
        this.idGoal = idGoal;
        this.minute = minute;
    }

    public Integer getIdGoal() {
        return idGoal;
    }

    public void setIdGoal(Integer idGoal) {
        this.idGoal = idGoal;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Boolean getPenalties() {
        return penalties;
    }

    public void setPenalties(Boolean penalties) {
        this.penalties = penalties;
    }

    public Player getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Player idPlayer) {
        this.idPlayer = idPlayer;
    }

    public Match getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(Match idMatch) {
        this.idMatch = idMatch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGoal != null ? idGoal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goal)) {
            return false;
        }
        Goal other = (Goal) object;
        if ((this.idGoal == null && other.idGoal != null) || (this.idGoal != null && !this.idGoal.equals(other.idGoal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.footballwc.entity.Goal[ idGoal=" + idGoal + " ]";
    }
    
}
