/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.adapter;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 631210442
 */
public abstract class GenericDataTable<T> extends AbstractTableModel{
    
    private List<String> nomeColunas;  
    private List<T> lista;
    
    public abstract List<String> setNomeColunas();    
    public abstract Object getValueByName(T entity, String name);

    
    public GenericDataTable() {
        this.lista = new ArrayList<>();
        this.nomeColunas = setNomeColunas();
        
    }
    
    public GenericDataTable(List<T> listaInicial) {        
        this();  
        this.lista.clear();  
        this.lista.addAll(listaInicial);  
        super.fireTableDataChanged();  
    }
    
    @Override
    public String getColumnName(int column) {
        return nomeColunas.get(column);
        
    }
        
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {         
        return nomeColunas.size(); 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T entity = lista.get( rowIndex ); 
        
        return getValueByName(entity, nomeColunas.get(columnIndex));
    }
    
}
