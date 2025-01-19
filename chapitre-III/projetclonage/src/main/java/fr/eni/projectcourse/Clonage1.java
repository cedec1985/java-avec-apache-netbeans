/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.projectcourse;

/**
 *
 * @author rlemo
 */
public class Clonage1 {
    
    public static void main(String[] args) {        
        Matiere sciences = new Matiere("Physique", "Chimie", "Mathématique");
        
        Etudiant etudiant1 = new Etudiant("Thomas", "Durand", sciences);
        Etudiant etudiant2 = null;
 
        try {
            etudiant2 = (Etudiant) etudiant1.clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
  
        System.out.println("Matiere3 de Etudiant1:"+etudiant1.matiere.cours3); 
        System.out.println("Matiere3 de Etudiant2:"+etudiant1.matiere.cours3);        
        etudiant2.matiere.cours3 = "Biologie";
        System.out.println("Matiere3 de Etudiant1:"+etudiant1.matiere.cours3);       
        System.out.println("Matiere3 de Etudiant2:"+etudiant2.matiere.cours3);
    }    
}
