/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gestionnotessoap.services;

import fr.eni.gestionnotessoap.dto.EtudiantRequest;
import fr.eni.gestionnotessoap.dto.EtudiantResponse;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface EtudiantService {
    
   @WebMethod 
   public EtudiantResponse getEtudiants(); 

   @WebMethod 
   public EtudiantResponse getEtudiantById(EtudiantRequest request);
}
