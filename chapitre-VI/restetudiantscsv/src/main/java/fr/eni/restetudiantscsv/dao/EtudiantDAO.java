package fr.eni.restetudiantscsv.dao;

import fr.eni.restetudiantscsv.datamodel.Etudiant;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Classe récupérant et insérant les données dans le fichier csv
 * @author rlemo
 */
@Repository
public class EtudiantDAO {
    
    public static String csvFile = System.getProperty("user.dir")+"\\src\\main\\resources\\csv\\etudiants.csv";
      
    /**
     * Méthode GET récupérant la liste des étudiants du fichier csv
     * @return liste des étudiants du fichier csv
     */
    public List<Etudiant> getAllEtudiants() {             
        String line;
        String output;
        String cvsSplitBy = ",";
        List<Etudiant> etudiants = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

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
     * Méthode POST effectuant l'insertion d'un étudiant en fin de fichier
     * @param etudiant à insérer dans le fichier csv
     * @throws java.io.IOException
     */
    public void add(Etudiant etudiant) throws IOException {
        try (FileWriter csvWriter = new FileWriter(csvFile, true)) {
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