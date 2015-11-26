/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.rnval;

import com.jacksonf.dto.Passagem;
import com.jacksonf.service.ValidacaoRN;

/**
 *
 * @author 631210442
 */
public class PassagemRNVal implements ValidacaoRN<Passagem>  {

    @Override
    public void validarSalvar(Passagem bean) {
        if (bean.getCliente().getId() <= 0) {
            throw new RuntimeException("Cliente não informado");
        }
        if (bean.getVoo().getId() <= 0) {
            throw new RuntimeException("Voo não informado");
        }
        
    }

    @Override
    public void validarExcluir(Passagem bean) {
        validarConsultar(bean);
    }

    @Override
    public void validarConsultar(Passagem bean) {        
        if (bean.getId() == 0) {
            throw new RuntimeException("Campo indentificador não informado");
        }
    }

    @Override
    public void validarAlterar(Passagem bean) {
        validarConsultar(bean);
        validarSalvar(bean);
    }
    
}
