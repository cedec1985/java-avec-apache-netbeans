package fr.eni.jsfetudiantscsv.presenter;

import fr.eni.jsfetudiantscsv.dao.EtudiantDAO;
import fr.eni.jsfetudiantscsv.dto.Etudiant;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Classe de présentation appelant les méthodes du DAO, utilisée par les vues.
 *
 * @author rlemo
 * @version 1.0
 */
//@RequestScoped
@SessionScoped
@Named("etuPresenter")
public class EtudiantPresenter implements Serializable {

    private EtudiantDAO etudiantDAO = new EtudiantDAO();
    private List<Etudiant> etudiants;
    private Etudiant newEtudiant = new Etudiant();

    /**
     * Retourne la liste des étudiants du fichier csv via le DAO
     *
     * @return la propriété représentant la liste des étudiants
     */
    public List<Etudiant> getListEtudiants() {
        etudiants = etudiantDAO.readAllEtudiants();
        return etudiants;
    }

    /**
     * Insère un étudiant dans le fichier csv et affiche la page JSF contenant
     * la liste des étudiants
     *
     * @return la page JSF ListEtudiants.xhtml
     * @throws IOException
     */
    public String insertEtudiant() throws IOException {
        etudiantDAO.add(newEtudiant);
        newEtudiant = new Etudiant();
        etudiants = etudiantDAO.readAllEtudiants();
        return "ListEtudiants";
    }

    public EtudiantDAO getEtudiantDAO() {
        return etudiantDAO;
    }

    public void setEtudiantDAO(EtudiantDAO etudiantDAO) {
        this.etudiantDAO = etudiantDAO;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Etudiant getNewEtudiant() {
        return newEtudiant;
    }

    public void setNewEtudiant(Etudiant newEtudiant) {
        this.newEtudiant = newEtudiant;
    }
}
