/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.adapter;

import com.jacksonf.dto.Voo;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author 631210442
 */
public class VooListCellRenderer  extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Voo) {
            Voo voo = (Voo) value;
            
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            setText(String.format("%s > %s (%s)", voo.getOrigem(), voo.getDestino(), formatter.format(voo.getHora()) ));
        }
        return this;
    }



}
