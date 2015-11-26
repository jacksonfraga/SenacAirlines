/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.rnval;

import com.jacksonf.dto.Cliente;
import com.jacksonf.service.ValidacaoRN;

/**
 *
 * @author 631210442
 */
public class ClienteRNVal implements ValidacaoRN<Cliente>  {

    @Override
    public void validarSalvar(Cliente bean) {
        if (bean.getRg().trim().equals("")) {
            throw new RuntimeException("Campo RG não informado");
        }
        if (bean.getNome().trim().equals("")) {
            throw new RuntimeException("Campo Nome não informado");
        }
        if (bean.getTelefone().trim().equals("")) {
            throw new RuntimeException("Campo Telefone não informado");
        }
    }

    @Override
    public void validarExcluir(Cliente bean) {
        validarConsultar(bean);
    }

    @Override
    public void validarConsultar(Cliente bean) {        
        if (bean.getId() == 0) {
            throw new RuntimeException("Campo indentificador não informado");
        }
    }

    @Override
    public void validarAlterar(Cliente bean) {
        validarConsultar(bean);
        validarSalvar(bean);
    }
    
}
