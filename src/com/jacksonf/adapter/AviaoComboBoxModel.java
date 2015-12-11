/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.adapter;

import com.jacksonf.dto.Aviao;
import com.jacksonf.rn.AviaoRN;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author 631210442
 */
public class AviaoComboBoxModel implements ComboBoxModel{

    private final List<Aviao> listagem = new AviaoRN().pesquisar("");
    private Aviao itemSelected;
    
    
    
    @Override
    public void setSelectedItem(Object anItem) {
        itemSelected = (Aviao)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return itemSelected;
    }

    @Override
    public int getSize() {
        return listagem.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listagem.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }
    
}
