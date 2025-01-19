/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.projectcourse;

public class Matiere implements Cloneable {
    String cours1;
    String cours2;
    String cours3;

    public Matiere(String cours1, String cours2, String cours3) {
        this.cours1 = cours1;
        this.cours2 = cours2;
        this.cours3 = cours3;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}