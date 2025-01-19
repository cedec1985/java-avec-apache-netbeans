/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gestionetudiants;

import java.util.Objects;

public class Etudiant implements Cloneable{
    
    private String prenom;
    private String nom;
    private Matiere matieres;

    public Etudiant(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }
    
        public Etudiant(String prenom, String nom, Matiere matieres) {
        this.prenom = prenom;
        this.nom = nom;
        this.matieres = matieres;
    }
/*
 @Override
    protected Object clone() throws CloneNotSupportedException {
     return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }*/

  //Overriding clone() method to create a deep copy of an object.@Override
  protected Object clone() throws CloneNotSupportedException {
      Etudiant etudiant = (Etudiant) super.clone();
      etudiant.matieres = (Matiere) matieres.clone();
     return etudiant;
  }

    public String concat(String str) {
        return nom.concat(str);
    }

    @Override
    public String toString() {
        return "Etudiant{" + "prenom=" + prenom + ", nom=" + nom + ", matieres=" + matieres + "}";
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.prenom);
        hash = 97 * hash + Objects.hashCode(this.nom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Etudiant other = (Etudiant) obj;
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    /**
     * Get the value of prenom
     *
     * @return the value of prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Set the value of prenom
     *
     * @param prenom new value of prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Matiere getMatieres(Matiere matieres) {
        return matieres;
    }

    public void setMatieres(Matiere matieres) {
        this.matieres = matieres;
    }



}
