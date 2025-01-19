package fr.eni.calculgeometrique;

/**
 * Classe Cercle contenant deux méthodes nécessaires au calcul de son périmètre et aire.
 */
public class Cercle {
    
    /**
     * Constante PI
     */
    private static final double PI = 3.14159;

    /**
     * Propriété représentant le rayon du cercle
     */
    private double rayon;

    /**
    * Constructeur créant un cercle avec un rayon égale au paramètre.
    * @param r le rayon du cercle à créer
    */
   public Cercle(double r){
       this.rayon = r;
   }
    
    /**
     * Calcule l'aire d'un cercle
     * @return l'aire
     */
    public double getAire(){
            return PI * this.rayon * this.rayon;
    }

    /**
     * Calcule le périmètre d'un cercle
     * @return le périmètre
     */
    public double getPerimetre(){
            return 2 * PI * this.rayon;
    }
    
}
