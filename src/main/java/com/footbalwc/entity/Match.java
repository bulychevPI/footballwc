/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.footbalwc.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "match")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Match.findAll", query = "SELECT m FROM Match m"),
    @NamedQuery(name = "Match.findByIdMatch", query = "SELECT m FROM Match m WHERE m.idMatch = :idMatch"),
    @NamedQuery(name = "Match.findByStage", query = "SELECT m FROM Match m WHERE m.stage = :stage"),
    @NamedQuery(name = "Match.findByTime", query = "SELECT m FROM Match m WHERE m.time = :time")})
public class Match implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMatch", nullable = false)
    private Integer idMatch;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "stage", nullable = false, length = 25)
    private String stage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMatch")
    private Collection<Goal> goalCollection;
    @JoinColumn(name = "idTeam1", referencedColumnName = "idTeam", nullable = false)
    @ManyToOne(optional = false)
    private Team idTeam1;
    @JoinColumn(name = "idTeam2", referencedColumnName = "idTeam", nullable = false)
    @ManyToOne(optional = false)
    private Team idTeam2;

    public Match() {
    }

    public Match(Integer idMatch) {
        this.idMatch = idMatch;
    }

    public Match(Integer idMatch, String stage, Date time) {
        this.idMatch = idMatch;
        this.stage = stage;
        this.time = time;
    }

    public Integer getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(Integer idMatch) {
        this.idMatch = idMatch;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @XmlTransient
    public Collection<Goal> getGoalCollection() {
        return goalCollection;
    }

    public void setGoalCollection(Collection<Goal> goalCollection) {
        this.goalCollection = goalCollection;
    }

    public Team getIdTeam1() {
        return idTeam1;
    }

    public void setIdTeam1(Team idTeam1) {
        this.idTeam1 = idTeam1;
    }

    public Team getIdTeam2() {
        return idTeam2;
    }

    public void setIdTeam2(Team idTeam2) {
        this.idTeam2 = idTeam2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatch != null ? idMatch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Match)) {
            return false;
        }
        Match other = (Match) object;
        if ((this.idMatch == null && other.idMatch != null) || (this.idMatch != null && !this.idMatch.equals(other.idMatch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.footbalwc.entity.Match[ idMatch=" + idMatch + " ]";
    }
    
}
