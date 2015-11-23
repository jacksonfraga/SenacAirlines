/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.db;

import com.jacksonf.dto.Aviao;
import com.jacksonf.service.CrudDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 631210442
 */
public class AviaoDB extends CrudDB<Aviao> {

    @Override
    public void salvar(Aviao bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO aviao  ");
            sql.append("(codigo, nome)  ");
            sql.append("VALUES  ");
            sql.append("(?,?) ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, bean.getCodigo());  
            pstm.setString(2, bean.getNome());  

            logger.debug("Salvando: " + bean);
            pstm.execute();
            commitTransacao(conn);
            logger.debug("Salvamento executado com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public void excluir(Aviao bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM aviao WHERE id=?");
            pstm.setInt(1, bean.getId());

            logger.debug("Excluindo: " + bean);
            pstm.execute();
            commitTransacao(conn);
            logger.debug("Exclusão executada com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public Aviao consultar(Aviao bean) {
        Aviao aviao = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM aviao WHERE id=?");
            pstm.setInt(1, bean.getId());

            logger.debug("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                logger.debug("Registro encontrado");
                aviao = new Aviao();
                aviao.setId(rs.getInt("id"));
                aviao.setCodigo(rs.getString("codigo"));
                aviao.setNome(rs.getString("nome"));
            }
            logger.debug("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        
        return aviao;
    }

    @Override
    public void alterar(Aviao bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE aviao  ");
            sql.append("SET codigo = ?, nome = ?  ");
            sql.append("WHERE id = ?  ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, bean.getCodigo());
            pstm.setString(2, bean.getNome());            
            pstm.setInt(3, bean.getId());

            logger.debug("Salvando: " + bean);
            pstm.execute();
            commitTransacao(conn);
            logger.debug("Salvamento executado com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public List<Aviao> pesquisar(String pesquisa) {
        List<Aviao> lista = new ArrayList<>();
        
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM aviao WHERE nome like ?");
            pstm.setString(1, "%" + pesquisa + "%");

            logger.debug("Consultando: " + pesquisa);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                logger.debug("Registro encontrado");
                Aviao aviao = new Aviao();
                aviao.setId(rs.getInt("id"));
                aviao.setNome(rs.getString("nome"));
                aviao.setCodigo(rs.getString("codigo"));
                                
                lista.add(aviao);
            }
            logger.debug("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }        
        
        return lista;
    }
    
}
