package fr.eni.restetudiantscsv.datamodel;

/**
 * Classe représentant un étudiant et ses propriétés
 * @author rlemo
 */
public class Etudiant {
    
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String email;

    /**
     * Contructeur d'une entité Etudiant
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param email
     */
    public Etudiant(String nom, String prenom, String dateNaissance, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }    
}
