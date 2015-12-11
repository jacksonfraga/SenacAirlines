/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.adapter;

import com.jacksonf.dto.Aviao;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author 631210442
 */
public class AviaoListCellRenderer  extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Aviao) {
            Aviao aviao = (Aviao) value;
            setText(String.format("%s (%s)", aviao.getNome(), aviao.getCodigo()));
        }
        return this;
    }



}
