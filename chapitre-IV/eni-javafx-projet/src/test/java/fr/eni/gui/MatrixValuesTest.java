/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gui;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class MatrixValuesTest {

public MatrixValuesTest() {
}
private static MatrixValues instance;

@BeforeAll
public static void setUpClass() {
    instance = new MatrixValues();
}

@BeforeEach
public void setUp() {
    List<String[]> lines = Arrays.asList(
            new String[]{"0", "3", "male", "22", "1", "0", "7.25"},
            new String[]{"1", "", "female", "38", "1", "0", "71.2833"},
            new String[]{"1", "3", "", "26", "0", "0", "7.925"},
            new String[]{"1", "1", "female", "35", "1", "0", "53.1"}
    );

    List<String> headers = Arrays.asList(
            "Survived,Pclass,Sex,Age,Siblings/Spouses Aboard,Parents/Children Aboard,Fare"
    );
    lines.forEach(l -> instance.addRow(l));
    instance.setHeaders(headers);
}

@AfterEach
public void tearDown() {
    instance = new MatrixValues();
}

@AfterAll
public static void tearDownClass() {
}

    /**
     * Test of setHeaders method, of class MatrixValues.
     */
    @Test
    public void testSetHeaders() {
        System.out.println("setHeaders");
        List<String> headers = null;
        MatrixValues instance = new MatrixValues();
        instance.setHeaders(headers);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of addRow method, of class MatrixValues.
     */
    @Test
    public void testAddRow_StringArr() {
        System.out.println("addRow");
        String[] row = null;
        MatrixValues instance = new MatrixValues();
    }

    /**
     * Test of addRow method, of class MatrixValues.
     */
    @Test
    public void testAddRow_List() {
        System.out.println("addRow");
        List<String> row = null;
        MatrixValues instance = new MatrixValues();
        instance.addRow(row);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * First Test
     */
    @Test
    public void firstTest() {
        System.out.println("firstTest");
    }

    /**
     * Test of getHeaders method, of class MatrixValues.
     */
    @Test
    public void testGetHeaders() {
        System.out.println("getHeaders");
        MatrixValues instance = new MatrixValues();
        List<String> expResult = null;
        List<String> result = instance.getHeaders();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getValues method, of class MatrixValues.
     */
    @Test
    public void testGetValues() {
        System.out.println("getValues");
        MatrixValues instance = new MatrixValues();
        List<List<String>> expResult = null;
        List<List<String>> result = instance.getValues();
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of extractColumnByIndex method, of class MatrixValues.
     */
    @Test
    public void testExtractColumnByIndex() {
        System.out.println("extractColumnByIndex");
        int i = 0;
        MatrixValues instance = new MatrixValues();
        List<String> expResult = null;
    }

    /**
     * Test of extractColumnByheaderName method, of class MatrixValues.
     */
    @Test
    public void testExtractColumnByheaderName() {
        System.out.println("extractColumnByheaderName");
        String name = "";
        MatrixValues instance = new MatrixValues();
        List<String> expResult = null;
     
    }

/**
 * Test of countMissingValuesByHeader method, of class MatrixValues.
 */
@Test
public void testCountMissingValuesByHeader() {
    System.out.println("countMissingValuesByHeader");
    MatrixValues instance = new MatrixValues();
    Map<String, Integer> expResult = null;
}

    /**
     * Test of countLinesHavingMissingValues method, of class MatrixValues.
     */
    @Test
    public void testCountLinesHavingMissingValues() throws Exception {
        System.out.println("testing : countLinesHavingMissingValues");
        //Given
        // - 2 lignes avec valeurs manquante
        List<String[]> lines = Arrays.asList(
                new String[]{"0", "3", "Mr. Owen Harris Braund", "male", "22", "1", "0", "7.25"},
                new String[]{"1", "", "Mrs. John Bradley (Florence Briggs Thayer) Cumings", "female", "38", "1", "0", "71.2833"},
                new String[]{"1", "3", "Miss. Laina Heikkinen", "", "26", "0", "0", "7.925"},
                new String[]{"1", "1", "Mrs. Jacques Heath (Lily May Peel) Futrelle", "female", "35", "1", "0", "53.1"}
        );

        // - une liste de noms de colonnes
        List<String> headers = Arrays.asList(
                "Survived,Pclass,Name,Sex,Age,Siblings/Spouses Aboard,Parents/Children Aboard,Fare"
        );

        // - une instance de MatrixValues initialisée avec les valeurs
        final MatrixValues instance = new MatrixValues();
        lines.forEach(l -> instance.addRow(l));
        instance.setHeaders(headers);

        //When
        //Lorsque l'on exécute la méthode, on s'attend à avoir le résultat "2"
        int result = instance.countLinesHavingMissingValues();

        //Then
        //On vérifie que le résultat est bien 2
        assertEquals(2, result);
        //Clean : rien, tout est en mémoire
    }

}
