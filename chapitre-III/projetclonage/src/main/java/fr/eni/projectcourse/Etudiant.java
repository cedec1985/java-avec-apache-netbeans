/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.projectcourse;

public class Etudiant implements Cloneable {
    
    String prenom;
    String nom;
    Matiere matiere;

    public Etudiant(String prenom, String nom, Matiere matiere) {
        this.prenom = prenom;
        this.nom = nom;
        this.matiere = matiere;
    }
  
    //Methode par defaut : Crée une copie de surface
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
    
    //Methode surchargée : Crée une copie en profondeur
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Etudiant etudiant = (Etudiant) super.clone();
        etudiant.matiere = (Matiere) matiere.clone();
        return etudiant;
    }     
}
