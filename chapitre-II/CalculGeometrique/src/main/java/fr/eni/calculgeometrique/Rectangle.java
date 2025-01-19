package fr.eni.calculgeometrique;

/**
 * Classe Rectangle contenant deux méthodes nécessaires au calcul de son périmètre et aire.
 */
public class Rectangle {
    /**
     * Propriété représentant la longueur du rectangle
     */
    private double longueur;    

    /**
     * Propriété représentant la largeur du rectangle
     */
    private double largeur;
   
    
    /**
    * Constructeur créant un rectangle avec un largeur et une longueur.
    * @param longueur : longueur du rectangle à créer
    * @param largeur  : largeur du rectangle à créer
    */
   public Rectangle(double longueur, double largeur){
       this.longueur = longueur;
       this.largeur = largeur;
   }
   
    /**
     * Calcule l'aire d'un rectangle
     * @return l'aire
     */
    public double getAire(){
            return this.longueur * this.largeur;
    }

    /**
     * Calcule le périmètre d'un rectangle
     * @return le périmètre
     */
    public double getPerimetre(){
            return (this.longueur + this.largeur) * 2;
    }    
}
