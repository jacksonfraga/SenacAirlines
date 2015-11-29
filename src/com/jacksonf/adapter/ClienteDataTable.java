/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.adapter;

import com.jacksonf.dto.Cliente;
import org.apache.commons.lang.StringUtils;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 631210442
 */
public class ClienteDataTable  extends GenericDataTable<Cliente>{    

    public ClienteDataTable() {
    }

    public ClienteDataTable(List<Cliente> listaInicial) {
        super(listaInicial);
    }       
    
    @Override
    public List<String> setNomeColunas() {
        return Arrays.asList(StringUtils.split("ID;Nome;Rg;Telefone", ";"));
    }

    @Override
    public Object getValueByName(Cliente entity, String name) {
        switch (name) {
            case "ID":
                return entity.getId();
            case "Nome":
                return entity.getNome();
            case "Rg":
                return entity.getRg();
            case "Telefone":
                return entity.getTelefone();
            default:
                return null;
        }
    }
    
}
