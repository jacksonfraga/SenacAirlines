/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.rn;

import com.jacksonf.db.AviaoDB;
import com.jacksonf.dto.Aviao;
import com.jacksonf.rnval.AviaoRNVal;
import com.jacksonf.service.CrudDB;
import java.util.List;

/**
 *
 * @author 631210442
 */
public class AviaoRN  extends CrudDB<Aviao> {

    private final AviaoDB aviaoDB;
    private final AviaoRNVal aviaoRNVal;

    public AviaoRN() {
        aviaoDB = new AviaoDB();
        aviaoRNVal = new AviaoRNVal();
    }
    
    @Override
    public void salvar(Aviao bean) {
        aviaoRNVal.validarSalvar(bean);
        aviaoDB.salvar(bean);
    }

    @Override
    public void excluir(Aviao bean) {
        aviaoRNVal.validarExcluir(bean);
        aviaoDB.excluir(bean);
    }

    @Override
    public Aviao consultar(Aviao bean) {
        return aviaoDB.consultar(bean);
    }

    @Override
    public void alterar(Aviao bean) {        
        aviaoRNVal.validarAlterar(bean);
        aviaoDB.alterar(bean);
    }

    @Override
    public List<Aviao> pesquisar(String pesquisa) {
        return aviaoDB.pesquisar(pesquisa);
    }
    
}
