/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.db;

import com.jacksonf.dto.Cliente;
import com.jacksonf.dto.Passagem;
import com.jacksonf.dto.Voo;
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
public class PassagemDB extends CrudDB<Passagem>{

    @Override
    public void salvar(Passagem bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO passagem  ");
            sql.append("(vooId, clienteId, dataCompra)  ");
            sql.append("VALUES  ");
            sql.append("(?,?,?) ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, bean.getVoo().getId());
            pstm.setInt(2, bean.getCliente().getId());
            pstm.setDate(3, new java.sql.Date((bean.getDataCompra().getTime())));

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
    public void excluir(Passagem bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM passagem WHERE id=?");
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
    public Passagem consultar(Passagem bean) {
        Passagem passagem = null;

        Connection conn = null;
        try {
            conn = abrirConexao();
            
                    
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT");
            sql.append("    p.*, c.*, v.");
            sql.append("FROM passagem p");
            sql.append("JOIN cliente c on c.id = p.clienteId");
            sql.append("JOIN voo v on v.id = p.vooId");
            sql.append("WHERE p.id=? ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, bean.getId());

            logger.debug("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                logger.debug("Registro encontrado");
                passagem = new Passagem();
                passagem.setId(rs.getInt("id"));
                
                Cliente cliente = new Cliente();
                passagem.setCliente(cliente);
                
                Voo voo = new Voo();
                passagem.setVoo(voo);
                                                
                passagem.setDataCompra(rs.getDate("dataCompra"));
                
            }
            logger.debug("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return passagem;
    }

    @Override
    public void alterar(Passagem bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE passagem  ");
            sql.append("SET vooId = ?, clienteId = ?, dataCompra = ? ");
            sql.append("WHERE id = ?  ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, bean.getVoo().getId());
            pstm.setInt(2, bean.getCliente().getId());
            pstm.setDate(3, new java.sql.Date(bean.getDataCompra().getTime()));
            pstm.setInt(4, bean.getId());

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
    public List<Passagem> pesquisar(String pesquisa) {
        List<Passagem> lista = new ArrayList<>();

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM passagem WHERE nome like ?");
            pstm.setString(1, "%" + pesquisa + "%");

            logger.debug("Consultando: " + pesquisa);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                logger.debug("Registro encontrado");
                Passagem passagem = new Passagem();
                passagem.setId(rs.getInt("codigo"));
                
                
                Cliente cliente = new Cliente();
                passagem.setCliente(cliente);
                
                Voo voo = new Voo();
                passagem.setVoo(voo);
                
                passagem.setDataCompra(rs.getDate("dataCompra"));

                lista.add(passagem);
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
