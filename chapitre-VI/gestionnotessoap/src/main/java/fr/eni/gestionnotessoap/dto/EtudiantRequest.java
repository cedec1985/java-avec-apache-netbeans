/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gestionnotessoap.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "EtudiantRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class EtudiantRequest {
    
    @XmlElement(required = true)
    private Long idEtudiant;
    
  @XmlElement
   private String nom;

   @XmlElement
  private String prenom;

   @XmlElement
   private String dtNaissance;

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

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
    
    
 

    
}
