/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.rn;

import com.jacksonf.db.PassagemDB;
import com.jacksonf.dto.Passagem;
import com.jacksonf.rnval.PassagemRNVal;
import com.jacksonf.service.CrudDB;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 631210442
 */
public class PassagemRN  extends CrudDB<Passagem> {

    private final PassagemDB passagemDB;
    private final PassagemRNVal passagemRNVal;

    public PassagemRN() {
        passagemDB = new PassagemDB();
        passagemRNVal = new PassagemRNVal();
    }
    
    @Override
    public void salvar(Passagem bean) {
        bean.setDataCompra(new Date());
        passagemRNVal.validarSalvar(bean);
        passagemDB.salvar(bean);
    }

    @Override
    public void excluir(Passagem bean) {
        passagemRNVal.validarExcluir(bean);
        passagemDB.excluir(bean);
    }

    @Override
    public Passagem consultar(Passagem bean) {
        return passagemDB.consultar(bean);
    }

    @Override
    public void alterar(Passagem bean) {        
        passagemRNVal.validarAlterar(bean);
        passagemDB.alterar(bean);
    }

    @Override
    public List<Passagem> pesquisar(String pesquisa) {
        return passagemDB.pesquisar(pesquisa);
    }
    
}
