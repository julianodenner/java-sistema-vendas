package com.jdenner.to;

/**
 * Classe de relação entre a compra e o produto
 *
 * @author Juliano
 */
public class ItemCompra {

    private int codigo;
    private Compra compra;
    private Produto produto;
    private int quantidade;
    private Double valorUnitario;

    public ItemCompra() {
        this.codigo = 0;
        this.compra = new Compra();
        this.produto = new Produto();
        this.quantidade = 0;
        this.valorUnitario = 0.0;
    }

    public ItemCompra(int codigo) {
        this.codigo = codigo;
        this.compra = new Compra();
        this.produto = new Produto();
        this.quantidade = 0;
        this.valorUnitario = 0.0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return getProduto().getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ItemCompra) {
            ItemCompra iv = (ItemCompra) o;
            if (iv.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}
