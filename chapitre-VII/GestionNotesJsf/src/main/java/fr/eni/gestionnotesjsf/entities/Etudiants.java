/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gestionnotesjsf.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author romai
 */
@Entity
@Table(name = "ETUDIANTS")
@NamedQueries({
    @NamedQuery(name = "Etudiants.findAll", query = "SELECT e FROM Etudiants e"),
    @NamedQuery(name = "Etudiants.findByIdEtudiant", query = "SELECT e FROM Etudiants e WHERE e.idEtudiant = :idEtudiant"),
    @NamedQuery(name = "Etudiants.findByNom", query = "SELECT e FROM Etudiants e WHERE e.nom = :nom"),
    @NamedQuery(name = "Etudiants.findByPrenom", query = "SELECT e FROM Etudiants e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Etudiants.findByDtNaissance", query = "SELECT e FROM Etudiants e WHERE e.dtNaissance = :dtNaissance")})
public class Etudiants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ETUDIANT")
    private Long idEtudiant;
    @Size(max = 255)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 255)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 10)
    @Column(name = "DT_NAISSANCE")
    private String dtNaissance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtudiant")
    private Collection<Notes> notesCollection;

    public Etudiants() {
    }

    public Etudiants(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDtNaissance() {
        return dtNaissance;
    }

    public void setDtNaissance(String dtNaissance) {
        this.dtNaissance = dtNaissance;
    }

    public Collection<Notes> getNotesCollection() {
        return notesCollection;
    }

    public void setNotesCollection(Collection<Notes> notesCollection) {
        this.notesCollection = notesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtudiant != null ? idEtudiant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiants)) {
            return false;
        }
        Etudiants other = (Etudiants) object;
        if ((this.idEtudiant == null && other.idEtudiant != null) || (this.idEtudiant != null && !this.idEtudiant.equals(other.idEtudiant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.eni.gestionnotesjsf.entities.Etudiants[ idEtudiant=" + idEtudiant + " ]";
    }
    
}
