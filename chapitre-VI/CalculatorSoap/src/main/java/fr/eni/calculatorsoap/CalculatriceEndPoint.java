/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.calculatorsoap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

public class CalculatriceEndPoint {

    public static void main(String[] args) throws MalformedURLException {
        Endpoint.publish("http://localhost:8080/CalculatorSoap/Calculatrice", new CalculatriceImpl());

        URL urlObj = new URL("http://localhost:9080/CalculatorSoap-1.0.0-SNAPSHOT/CalculatriceImpl?wsdl");
        String namespaceURI = "http://calculatorsoap/";
        QName qname = new QName(namespaceURI, "calculatrice");
        QName portQName = new QName(namespaceURI, "CalculatriceImplPort");

        Service xmlService = Service.create(urlObj, qname);

        Calculatrice calculatrice = (Calculatrice) xmlService.getPort(portQName, Calculatrice.class);
        Long count = calculatrice.add(10l, 20l);
        System.out.println(count);
    }

}
