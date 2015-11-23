/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author 631210442
 */
public abstract class CrudDB<T> implements Crud<T> {

    protected static final Logger logger = Logger.getLogger(CrudDB.class);

    protected final String BD_STRING_CONEXAO = Propriedades.getInstance().get("db.string");
    protected final String BD_USERNAME = Propriedades.getInstance().get("db.user");
    protected final String BD_PASSWORD = Propriedades.getInstance().get("db.pass");

    public CrudDB() {
        try {
            logger.debug("Identificando Driver JDBC");
            Class.forName(Propriedades.getInstance().get("db.driver"));
            logger.debug("Driver JDBC identificado com sucesso");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Connection abrirConexao() {
        try {
            logger.debug("Abrindo a conexão com o banco de dados");
            final Connection conexao = DriverManager.getConnection(BD_STRING_CONEXAO, BD_USERNAME, BD_PASSWORD);

            /*
             Desliga o commit automático, deixando este controle 
             para o desenvolvedor...
             */
            conexao.setAutoCommit(false);

            return conexao;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            logger.debug("Conexão com o banco de dados aberta com sucesso!");
        }
    }

    protected void fecharConexao(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                logger.debug("Conexão com o banco de dados encerrada com sucesso");
            }
        } catch (Exception e) {
            logger.error("Problema ao fechar conexão com banco de dados", e);
        }
    }

    protected void commitTransacao(Connection connection) {
        if (connection != null) {
            try {
                connection.commit();
                logger.debug("COMMIT da transação efetuado");
            } catch (SQLException ex) {
                logger.error("Problema ao efetuar COMMIT no banco de dados", ex);
            }
        }
    }

    protected void rollbackTransacao(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
                logger.debug("ROLLBACK da transação efetuado");
            } catch (SQLException ex) {
                logger.error("Problema ao efetuar ROLLBACK no banco de dados", ex);
            }
        }
    }
}

