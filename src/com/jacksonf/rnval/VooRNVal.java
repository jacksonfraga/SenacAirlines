/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.rnval;

import com.jacksonf.dto.Voo;
import com.jacksonf.service.ValidacaoRN;
import java.util.Date;

/**
 *
 * @author 631210442
 */
public class VooRNVal implements ValidacaoRN<Voo>  {

    @Override
    public void validarSalvar(Voo bean) {
        if (bean.getHora().before(new Date())) {           
            throw new RuntimeException("A data do Voo deve ser uma data futura.");
        } 
        if (bean.getOrigem().trim().equals("")) {
            throw new RuntimeException("Campo Destino não informado");
        } 
        if (bean.getDestino().trim().equals("")) {
            throw new RuntimeException("Campo Nome não informado");
        }
    }

    @Override
    public void validarExcluir(Voo bean) {
        validarConsultar(bean);
    }

    @Override
    public void validarConsultar(Voo bean) {        
        if (bean.getId() == 0) {
            throw new RuntimeException("Campo indentificador não informado");
        }
    }

    @Override
    public void validarAlterar(Voo bean) {
        validarConsultar(bean);
        validarSalvar(bean);
    }
    
}
