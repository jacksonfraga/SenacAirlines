/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.rnval;

import com.jacksonf.dto.Aviao;
import com.jacksonf.service.ValidacaoRN;

/**
 *
 * @author 631210442
 */
public class AviaoRNVal implements ValidacaoRN<Aviao>  {

    @Override
    public void validarSalvar(Aviao bean) {
        if (bean.getCodigo().trim().equals("")) {
            throw new RuntimeException("Campo Código não informado");
        }
        if (bean.getNome().trim().equals("")) {
            throw new RuntimeException("Campo Nome não informado");
        }
    }

    @Override
    public void validarExcluir(Aviao bean) {
        validarConsultar(bean);
    }

    @Override
    public void validarConsultar(Aviao bean) {        
        if (bean.getId() == 0) {
            throw new RuntimeException("Campo indentificador não informado");
        }
    }

    @Override
    public void validarAlterar(Aviao bean) {
        validarConsultar(bean);
        validarSalvar(bean);
    }
    
}
