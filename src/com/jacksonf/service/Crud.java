/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.service;

import java.util.List;

/**
 *
 * @author 631210442
 */
public interface Crud<T> {

    void salvar(T bean);
    void excluir(T bean);
    T consultar(T bean);
    void alterar(T bean);
    List<T> pesquisar(String pesquisa);
    
}