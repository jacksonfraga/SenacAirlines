/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.db;

import com.jacksonf.dto.Aviao;
import com.jacksonf.dto.Voo;
import com.jacksonf.service.CrudDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 631210442
 */
public class VooDB extends CrudDB<Voo>{
    
    @Override
    public void salvar(Voo bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO voo  ");
            sql.append("(origem, destino, hora, aviaoId)  ");
            sql.append("VALUES  ");
            sql.append("(?,?,?,?) ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, bean.getOrigem()); 
            pstm.setString(2, bean.getDestino());  
            pstm.setDate(3, new java.sql.Date(bean.getHora().getTime()));
            pstm.setInt(4, bean.getAviao().getId());  

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
    public void excluir(Voo bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM voo WHERE id=?");
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
    public Voo consultar(Voo bean) {
        Voo voo = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ");
            sql.append("    voo.*, aviao.codigo AS aviao_codigo, aviao.nome AS aviao_nome ");
            sql.append("FROM voo ");
            sql.append("JOIN aviao on (aviao.id = voo.aviaoId) ");
            sql.append("WHERE voo.id = ?");
            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, bean.getId());

            logger.debug("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                logger.debug("Registro encontrado");
                voo = new Voo();
                voo.setId(rs.getInt("id"));
                voo.setOrigem(rs.getString("origem"));
                voo.setDestino(rs.getString("destino"));                
                voo.setHora(new Date(rs.getDate("hora").getTime()));
                voo.setAviao(new Aviao(rs.getInt("id"), rs.getString("aviao_codigo"), rs.getString("aviao_nome")));
            }
            logger.debug("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        
        return voo;
    }

    @Override
    public void alterar(Voo bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE voo  ");
            sql.append("SET origem = ?, destino = ?, hora = ?, aviaoId = ? ");
            sql.append("WHERE id = ?  ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, bean.getOrigem()); 
            pstm.setString(2, bean.getDestino());  
            pstm.setDate(3, new java.sql.Date(bean.getHora().getTime()));
            pstm.setInt(4, bean.getAviao().getId());  
            pstm.setInt(5, bean.getId());  

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
    public List<Voo> pesquisar(String pesquisa) {
        List<Voo> lista = new ArrayList<>();

        Connection conn = null;
        try {
            conn = abrirConexao();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ");
            sql.append("    voo.*, aviao.codigo AS aviao_codigo, aviao.nome AS aviao_nome ");
            sql.append("FROM voo ");
            sql.append("JOIN aviao on (aviao.id = voo.aviaoId) ");
            sql.append("WHERE (origem like ?) OR (destino like ?)");
            
            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, "%" + pesquisa + "%");
            pstm.setString(2, "%" + pesquisa + "%");

            logger.debug("Consultando: " + pesquisa);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                logger.debug("Registro encontrado");
                Voo voo = new Voo();
                voo.setId(rs.getInt("id"));
                voo.setOrigem(rs.getString("origem"));
                voo.setDestino(rs.getString("destino"));                
                voo.setHora(new Date(rs.getDate("hora").getTime()));
                voo.setAviao(new Aviao(rs.getInt("id"), rs.getString("aviao_codigo"), rs.getString("aviao_nome")));
                                
                lista.add(voo);
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
