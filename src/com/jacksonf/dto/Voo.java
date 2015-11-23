/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.dto;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 631210442
 */
public class Voo  extends BaseDTO {
    private String  origem;
    private String destino;
    private Date hora;
    private Aviao aviao;

    public Voo() {
    }

    public Voo(int id, String origem, String destino, Date hora, Aviao aviao) {
        this.setId(id);
        this.origem = origem;
        this.destino = destino;
        this.hora = hora;
        this.aviao = aviao;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.origem);
        hash = 29 * hash + Objects.hashCode(this.destino);
        hash = 29 * hash + Objects.hashCode(this.hora);
        hash = 29 * hash + Objects.hashCode(this.aviao);
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
        final Voo other = (Voo) obj;
        if (!Objects.equals(this.origem, other.origem)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (!Objects.equals(this.aviao, other.aviao)) {
            return false;
        }
        return true;
    }

    
    
}
