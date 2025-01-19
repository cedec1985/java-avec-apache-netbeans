package fr.eni.calculatorsoap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Calculatrice {
    
    @WebMethod
    Long add(Long premierOperande, Long secondOperande);
    
}
