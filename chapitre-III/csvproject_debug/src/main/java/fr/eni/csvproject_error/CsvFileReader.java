/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.csvproject_error;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {  
    
    public static void main(String[] args) {
       
       String line;
       String cvsSplitBy = ";";
       String csvFile = "C:\\Users\\cedri\\OneDrive\\Documents\\NetBeansProjects\\java-avec-apache-netbeans-master\\java-avec-apache-netbeans-master\\chapitre-III\\csvproject_debug\\src\\main\\resources\\csv\\addresses.csv";

       try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

           while ((line = br.readLine()) != null) {
               for (String s : line.split(cvsSplitBy)) {
                   System.out.println(s);
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
