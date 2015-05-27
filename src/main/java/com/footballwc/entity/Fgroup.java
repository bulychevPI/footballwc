/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.footballwc.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "fgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fgroup.findAll", query = "SELECT f FROM Fgroup f"),
    @NamedQuery(name = "Fgroup.findByIdGroup", query = "SELECT f FROM Fgroup f WHERE f.idGroup = :idGroup"),
    @NamedQuery(name = "Fgroup.findByGroupName", query = "SELECT f FROM Fgroup f WHERE f.groupName = :groupName")})
public class Fgroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGroup")
    private Integer idGroup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "groupName")
    private String groupName;
    @OneToMany(mappedBy = "idGroup")
    private Collection<Team> teamCollection;

    public Fgroup() {
    }

    public Fgroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public Fgroup(Integer idGroup, String groupName) {
        this.idGroup = idGroup;
        this.groupName = groupName;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @XmlTransient
    public Collection<Team> getTeamCollection() {
        return teamCollection;
    }

    public void setTeamCollection(Collection<Team> teamCollection) {
        this.teamCollection = teamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroup != null ? idGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fgroup)) {
            return false;
        }
        Fgroup other = (Fgroup) object;
        if ((this.idGroup == null && other.idGroup != null) || (this.idGroup != null && !this.idGroup.equals(other.idGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.footballwc.entities.Fgroup[ idGroup=" + idGroup + " ]";
    }
    
}
