package fr.eni.calculatorsoap;

public class CalculatriceImpl implements Calculatrice{

    @Override
    public Long add(Long premierOperande, Long secondOperande) {
        if (premierOperande == null || secondOperande == null){
                return 0l;
        }
        System.out.println("Premier operande : " + premierOperande + " second operande : "+ secondOperande);
        return premierOperande + secondOperande;
    }
    
}
