package fr.eni.calculgeometrique;

/**
 * Classe principale du programme.
 */
public class CalculGeometrique {
    
    /**
     * Méthode principale de l'application (point d'entrée).
     * @param args : paramètre d'entrée
     */
    public static void main(String[] args){
        Cercle cercle = new Cercle(20);
        System.out.println("Périmètre du cercle : " + cercle.getPerimetre());
        System.out.println("Aire du cercle : " + cercle.getAire());
        
        Rectangle rectangle = new Rectangle(5, 5);
        System.out.println("Périmètre du rectangle : " + rectangle.getPerimetre());
        System.out.println("Aire du rectangle : " + rectangle.getAire());
        
        Carre carre = new Carre(5);
        System.out.println("Périmètre du carré : " + carre.getPerimetre());
        System.out.println("Aire du carré : " + carre.getAire());
    }
}
