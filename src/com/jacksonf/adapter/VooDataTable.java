/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.adapter;

import com.jacksonf.dto.Voo;
import org.apache.commons.lang.StringUtils;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 631210442
 */
public class VooDataTable  extends GenericDataTable<Voo>{    

    public VooDataTable() {
    }

    public VooDataTable(List<Voo> listaInicial) {
        super(listaInicial);
    }       
    
    @Override
    public List<String> setNomeColunas() {
        return Arrays.asList(StringUtils.split("ID;Avião;Origem;Destino;Hora", ";"));
    }

    @Override
    public Object getValueByName(Voo entity, String name) {
        switch (name) {
            case "ID":
                return entity.getId();
            case "Avião":
                return entity.getAviao().getNome();
            case "Origem":
                return entity.getOrigem();
            case "Destino":
                return entity.getDestino();
            case "Hora":
                return entity.getHora().toString();
            default:
                return null;
        }
    }
    
}
