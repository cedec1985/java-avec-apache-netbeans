/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gui;

/**
 *
 * @author User
 */
public class StatEntry {
    
    private String columnName;
    private Integer missingValues;
    private Double missingValuesPercent;


    public StatEntry(String columnName, Integer missingValues, Double missingValuesPercent) {
        this.columnName = columnName;
        this.missingValues = missingValues;
        this.missingValuesPercent = missingValuesPercent;
                
              
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getMissingValues() {
        return missingValues;
    }

    public void setMissingValues(Integer missingValues) {
        this.missingValues = missingValues;
    }
    
    
    public Double getMissingValuesPercent() {
        return missingValuesPercent;
    }

    public void setMissingValuesPercent(Double missingValuesPercent) {
        this.missingValuesPercent = missingValuesPercent;
    }
    
    
    
           
    
}
