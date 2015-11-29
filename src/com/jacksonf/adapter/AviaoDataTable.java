/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.adapter;

import com.jacksonf.dto.Aviao;
import org.apache.commons.lang.StringUtils;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 631210442
 */
public class AviaoDataTable  extends GenericDataTable<Aviao>{    

    public AviaoDataTable() {
    }

    public AviaoDataTable(List<Aviao> listaInicial) {
        super(listaInicial);
    }       
    
    @Override
    public List<String> setNomeColunas() {
        return Arrays.asList(StringUtils.split("ID;Nome;Código", ";"));
    }

    @Override
    public Object getValueByName(Aviao entity, String name) {
        switch (name) {
            case "ID":
                return entity.getId();
            case "Nome":
                return entity.getNome();
            case "Código":
                return entity.getCodigo();
            default:
                return null;
        }
    }
    
}
