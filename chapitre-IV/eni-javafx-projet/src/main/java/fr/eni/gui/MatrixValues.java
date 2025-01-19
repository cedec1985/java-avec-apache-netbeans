/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.eni.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author User
 */
public class MatrixValues {

    private List<String> headers;

    private List<List<String>> values = new ArrayList<>();

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public void addRow(String[] row) {
        values.add(new ArrayList<>(Arrays.asList(row)));
    }
    public void addRow(List<String> row) {
        values.add(row);
    }
    
    public List<String> getRowAt(int i){
        return values.get(i);
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<List<String>> getValues() {
        return values;
    }

    public List<String> extractColumnByIndex(int i) {
        return this.values.stream()
                .map(l -> l.get(i))
                .collect(Collectors.toList());
    }

    public List<String> extractColumnByheaderName(String name) {
        int index = this.headers.indexOf(name);
        return this.values.stream()
                .map(l -> l.get(index))
                .collect(Collectors.toList());
    }

    public Map<String, Integer> countMissingValuesByHeader() {
        Map<String, Integer> counts = new LinkedHashMap<>();
        final int size = values.size();
        final int headerSize = headers.size();
        for (int i = 0; i < size; i++) {
            List<String> currentRow = values.get(i);
            final int currentRowSize = currentRow.size();
            
            for (int j = 0; j <headerSize ; j++){
                final String value = currentRow.get(j);
                if ("".equals(value)){
                    final String currentHeader = headers.get(j); 
                    Integer currentCount = counts.get(currentHeader);
                    if (currentCount == null){
                        currentCount = 0;
                    }
                    counts.put(currentHeader, currentCount + 1 );
                }
            }
        }
        return counts;
    }
    
     public Integer countLinesHavingMissingValues() {

           return values.stream()
                   .mapToInt(l -> l.contains("")? 1 : 0)
                   .sum();
    
       
    }


}
