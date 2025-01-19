/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gestionetudiants;

public class Matiere {
    
    String cours1;
    String cours2;
    String cours3;

    public Matiere(String cours1, String cours2, String cours3) {
        this.cours1 = cours1;
        this.cours2 = cours2;
        this.cours3 = cours3;
    }

    
    @Override
    public String toString() {
        return "Matiere{" + "cours1=" + cours1 + ", cours2=" + cours2 + ", cours3=" + cours3 + '}';
    }

   @Override
   protected Object clone() throws CloneNotSupportedException {
      Matiere matiere = (Matiere) super.clone();
      return matiere;
   }

    public String getCours1() {
        return cours1;
    }

    public void setCours1(String cours1) {
        this.cours1 = cours1;
    }

    public String getCours2() {
        return cours2;
    }

    public void setCours2(String cours2) {
        this.cours2 = cours2;
    }

    public String getCours3() {
        return cours3;
    }

    public void setCours3(String cours3) {
        this.cours3 = cours3;
    }


}
