package com.jdenner.to;

/**
 * Classe contendo os dados do fornecedor
 *
 * @author Juliano
 */
public class Fornecedor {

    private int codigo;
    private String nome;
    private String cnpj;

    public Fornecedor() {
        this.codigo = 0;
        this.nome = "";
        this.cnpj = "";
    }

    public Fornecedor(int codigo) {
        this.codigo = codigo;
        this.nome = "";
        this.cnpj = "";
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Fornecedor) {
            Fornecedor c = (Fornecedor) o;
            if (c.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}
