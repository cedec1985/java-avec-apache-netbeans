/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.myfirstproject;

/**
 * la classe Main est la classe principale du projet contenant le point d'entrée
 * de l'application.
 *
 */
public class Main {

    /**
     * Méthode principale de l'application (point d'entrée).
     *
     * @param args : paramètre d'entrée
     */
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        HelloWorld.afficheLog("Bonjour !");
        HelloWorld.afficheConsole("Bienvenue !");
        HelloWorld.afficheConsole(helloWorld.getChaine());
        HelloWorld helloWorld2 = new HelloWorld();
        helloWorld2.afficheConsole("hello !");
        HelloWorld.afficheConsole(helloWorld.getChaine());
        helloWorld2.afficheConsole("aurevoir !");
    }

}
