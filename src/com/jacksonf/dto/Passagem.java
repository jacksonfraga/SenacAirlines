/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.dto;

import java.security.Timestamp;
import java.util.Date;
import java.util.Objects;


/**
 *
 * @author 631210442
 */
public class Passagem  extends BaseDTO {
    private Voo voo;
    private Cliente cliente;
    private Date dataCompra;

    public Passagem() {
    }

    public Passagem(int id, Voo voo, Cliente cliente, Date dataCompra) {
        this.setId(id);
        this.voo = voo;
        this.cliente = cliente;
        this.dataCompra = dataCompra;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.voo);
        hash = 83 * hash + Objects.hashCode(this.cliente);
        hash = 83 * hash + Objects.hashCode(this.dataCompra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Passagem other = (Passagem) obj;
        if (!Objects.equals(this.voo, other.voo)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.dataCompra, other.dataCompra)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
