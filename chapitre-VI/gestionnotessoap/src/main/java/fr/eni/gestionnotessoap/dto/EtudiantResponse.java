/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gestionnotessoap.dto;

import fr.eni.gestionnotessoap.entities.Etudiants;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "EtudiantResponse")
public class EtudiantResponse {
    
    private Etudiants etudiant;
    
    private List<Etudiants> etudiants;

    public Etudiants getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiants etudiant) {
        this.etudiant = etudiant;
    }  

    public List<Etudiants> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiants> etudiants) {
        this.etudiants = etudiants;
    }
    
}
