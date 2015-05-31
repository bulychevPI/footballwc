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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "groupresults")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupresults.findAll", query = "SELECT g FROM Groupresults g"),
    @NamedQuery(name = "Groupresults.findByTeamidTeam", query = "SELECT g FROM Groupresults g WHERE g.teamidTeam = :teamidTeam"),
    @NamedQuery(name = "Groupresults.findByPlayed", query = "SELECT g FROM Groupresults g WHERE g.played = :played"),
    @NamedQuery(name = "Groupresults.findByWon", query = "SELECT g FROM Groupresults g WHERE g.won = :won"),
    @NamedQuery(name = "Groupresults.findByDrawn", query = "SELECT g FROM Groupresults g WHERE g.drawn = :drawn"),
    @NamedQuery(name = "Groupresults.findByLost", query = "SELECT g FROM Groupresults g WHERE g.lost = :lost"),
    @NamedQuery(name = "Groupresults.findByGf", query = "SELECT g FROM Groupresults g WHERE g.gf = :gf"),
    @NamedQuery(name = "Groupresults.findByGa", query = "SELECT g FROM Groupresults g WHERE g.ga = :ga"),
    @NamedQuery(name = "Groupresults.findByPoints", query = "SELECT g FROM Groupresults g WHERE g.points = :points")})
public class Groupresults implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Team_idTeam")
    private Integer teamidTeam;
    @Column(name = "played")
    private Integer played;
    @Column(name = "won")
    private Integer won;
    @Column(name = "drawn")
    private Integer drawn;
    @Column(name = "lost")
    private Integer lost;
    @Column(name = "gf")
    private Integer gf;
    @Column(name = "ga")
    private Integer ga;
    @Column(name = "points")
    private Integer points;
    @JoinColumn(name = "Team_idTeam", referencedColumnName = "idTeam", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Team team;

    public Groupresults() {
    }

    public Groupresults(Integer teamidTeam) {
        this.teamidTeam = teamidTeam;
    }

    public Integer getTeamidTeam() {
        return teamidTeam;
    }

    public void setTeamidTeam(Integer teamidTeam) {
        this.teamidTeam = teamidTeam;
    }

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getDrawn() {
        return drawn;
    }

    public void setDrawn(Integer drawn) {
        this.drawn = drawn;
    }

    public Integer getLost() {
        return lost;
    }

    public void setLost(Integer lost) {
        this.lost = lost;
    }

    public Integer getGf() {
        return gf;
    }

    public void setGf(Integer gf) {
        this.gf = gf;
    }

    public Integer getGa() {
        return ga;
    }

    public void setGa(Integer ga) {
        this.ga = ga;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamidTeam != null ? teamidTeam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupresults)) {
            return false;
        }
        Groupresults other = (Groupresults) object;
        if ((this.teamidTeam == null && other.teamidTeam != null) || (this.teamidTeam != null && !this.teamidTeam.equals(other.teamidTeam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.footballwc.entity.Groupresults[ teamidTeam=" + teamidTeam + " ]";
    }
    
}
