/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.rn;

import com.jacksonf.db.VooDB;
import com.jacksonf.dto.Voo;
import com.jacksonf.rnval.VooRNVal;
import com.jacksonf.service.CrudDB;
import java.util.List;

/**
 *
 * @author 631210442
 */
public class VooRN  extends CrudDB<Voo> {

    private final VooDB vooDB;
    private final VooRNVal vooRNVal;

    public VooRN() {
        vooDB = new VooDB();
        vooRNVal = new VooRNVal();
    }
    
    @Override
    public void salvar(Voo bean) {
        vooRNVal.validarSalvar(bean);
        vooDB.salvar(bean);
    }

    @Override
    public void excluir(Voo bean) {
        vooRNVal.validarExcluir(bean);
        vooDB.excluir(bean);
    }

    @Override
    public Voo consultar(Voo bean) {
        return vooDB.consultar(bean);
    }

    @Override
    public void alterar(Voo bean) {        
        vooRNVal.validarAlterar(bean);
        vooDB.alterar(bean);
    }

    @Override
    public List<Voo> pesquisar(String pesquisa) {
        return vooDB.pesquisar(pesquisa);
    }
    
}
