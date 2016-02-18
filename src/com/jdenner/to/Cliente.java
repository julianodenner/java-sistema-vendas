package com.jdenner.to;

import java.util.Date;

/**
 * Classe contendo os dados do cliente
 *
 * @author Juliano
 */
public class Cliente {

    private int codigo;
    private String nome;
    private String cpf;
    private Date dataNascimento;

    public Cliente() {
        this.codigo = 0;
        this.nome = "";
        this.cpf = "";
        this.dataNascimento = new Date();
    }

    public Cliente(int codigo) {
        this.codigo = codigo;
        this.nome = "";
        this.cpf = "";
        this.dataNascimento = new Date();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cliente) {
            Cliente c = (Cliente) o;
            if (c.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}
