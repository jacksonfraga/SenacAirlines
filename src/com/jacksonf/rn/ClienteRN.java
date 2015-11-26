/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.rn;

import com.jacksonf.db.ClienteDB;
import com.jacksonf.dto.Cliente;
import com.jacksonf.rnval.ClienteRNVal;
import com.jacksonf.service.CrudDB;
import java.util.List;

/**
 *
 * @author 631210442
 */
public class ClienteRN  extends CrudDB<Cliente> {

    private final ClienteDB clienteDB;
    private final ClienteRNVal clienteRNVal;

    public ClienteRN() {
        clienteDB = new ClienteDB();
        clienteRNVal = new ClienteRNVal();
    }
    
    @Override
    public void salvar(Cliente bean) {
        clienteRNVal.validarSalvar(bean);
        clienteDB.salvar(bean);
    }

    @Override
    public void excluir(Cliente bean) {
        clienteRNVal.validarExcluir(bean);
        clienteDB.excluir(bean);
    }

    @Override
    public Cliente consultar(Cliente bean) {
        return clienteDB.consultar(bean);
    }

    @Override
    public void alterar(Cliente bean) {        
        clienteRNVal.validarAlterar(bean);
        clienteDB.alterar(bean);
    }

    @Override
    public List<Cliente> pesquisar(String pesquisa) {
        return clienteDB.pesquisar(pesquisa);
    }
    
}
