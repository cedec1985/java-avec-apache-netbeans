package fr.eni.restetudiantscsv.controller;

import fr.eni.restetudiantscsv.dao.EtudiantDAO;
import fr.eni.restetudiantscsv.datamodel.Etudiant;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe déclarant les services Rest d'un étudiant
 * @author rlemo
 */
@RestController
public class EtudiantController {
        
    @Autowired
    private EtudiantDAO daoEtudiant;
        
    /**
     * Service Rest retournant la liste des étudiants
     * @return
     * @throws ParseException 
     */
    @GetMapping("/etudiants")
    public List<Etudiant> all() throws ParseException {
        return daoEtudiant.getAllEtudiants();
    }
    
    /**
     * Service Rest insérant un étudiant dans le fichier csv
     * @param etudiant
     * @return le code retour de l'insertion
     * @throws java.io.IOException
     */
    @PostMapping("/etudiant/add")
    public ResponseEntity addEtudiant(@RequestBody Etudiant etudiant) throws IOException {
        daoEtudiant.add(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
 
}
