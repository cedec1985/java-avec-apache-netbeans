/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gestionnotesjsf.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author romai
 */
@Entity
@Table(name = "NOTES")
@NamedQueries({
    @NamedQuery(name = "Notes.findAll", query = "SELECT n FROM Notes n"),
    @NamedQuery(name = "Notes.findByIdNote", query = "SELECT n FROM Notes n WHERE n.idNote = :idNote"),
    @NamedQuery(name = "Notes.findByNote", query = "SELECT n FROM Notes n WHERE n.note = :note")})
public class Notes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NOTE")
    private Long idNote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTE")
    private BigDecimal note;
    @JoinColumn(name = "ID_ETUDIANT", referencedColumnName = "ID_ETUDIANT")
    @ManyToOne(optional = false)
    private Etudiants idEtudiant;
    @JoinColumn(name = "ID_MODULE", referencedColumnName = "ID_MODULE")
    @ManyToOne(optional = false)
    private Modules idModule;

    public Notes() {
    }

    public Notes(Long idNote) {
        this.idNote = idNote;
    }

    public Long getIdNote() {
        return idNote;
    }

    public void setIdNote(Long idNote) {
        this.idNote = idNote;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public Etudiants getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Etudiants idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Modules getIdModule() {
        return idModule;
    }

    public void setIdModule(Modules idModule) {
        this.idModule = idModule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNote != null ? idNote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notes)) {
            return false;
        }
        Notes other = (Notes) object;
        if ((this.idNote == null && other.idNote != null) || (this.idNote != null && !this.idNote.equals(other.idNote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.eni.gestionnotesjsf.entities.Notes[ idNote=" + idNote + " ]";
    }
    
}
