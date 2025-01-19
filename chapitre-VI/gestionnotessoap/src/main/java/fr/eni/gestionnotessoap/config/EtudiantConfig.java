/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gestionnotessoap.config;

import fr.eni.gestionnotessoap.services.EtudiantServiceImpl;
import javax.persistence.EntityManagerFactory;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;

public class EtudiantConfig {

    private Bus bus;

    private EntityManagerFactory entityManagerFactory;
     
    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, new EtudiantServiceImpl(entityManagerFactory));
        endpoint.publish("/etudiantservice");
        return endpoint;
    }
}
