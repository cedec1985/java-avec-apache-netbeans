package fr.eni.jsfetudiantscsv.dao;

import fr.eni.jsfetudiantscsv.dto.Etudiant;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe récupérant et insérant les données dans le fichier csv
 * @author rlemo
 * @version 1.0
 */
public class EtudiantDAO {
    
    private static final String CSVFILE = "C:\\ws_netbeans\\JsfEtudiantsCsv\\src\\main\\java\\csv\\etudiants.csv";
    
    /**
     * Lit les lignes du fichier csv afin de retourner une liste d'étudiants
     * @return une liste d'objets Etudiant
     */
    public List<Etudiant> readAllEtudiants() {             
        String line;
        String output;
        String cvsSplitBy = ",";
        List<Etudiant> etudiants = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSVFILE))) {

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                output = "Nom: " + data[0] + ", Prénom: " + data[1] + ", Date de naissance: " + data[2] + ", Mail: " + data[3];
                System.out.println(output); 
                etudiants.add(new Etudiant(data[0], data[1], data[2], data[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return etudiants;
    }
    
    /**
     * Insère un étudiant dans le fichier csv
     * @param etudiant à insérer
     * @throws IOException 
     */
    public void add(Etudiant etudiant) throws IOException {
        try (FileWriter csvWriter = new FileWriter(CSVFILE, true)) {
            String cvsSplitBy = ",";
            
            csvWriter.append("\n");
            csvWriter.append(etudiant.getPrenom());
            csvWriter.append(cvsSplitBy);
            csvWriter.append(etudiant.getNom());
            csvWriter.append(cvsSplitBy);
            csvWriter.append(etudiant.getDateNaissance());
            csvWriter.append(cvsSplitBy);
            csvWriter.append(etudiant.getEmail());
            
            csvWriter.flush();
        }    
    }
}