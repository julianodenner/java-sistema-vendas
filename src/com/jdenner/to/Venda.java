package com.jdenner.to;

import com.jdenner.to.enums.Situacao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe contendo os dados da venda
 *
 * @author Juliano
 */
public class Venda {

    private int codigo;
    private Cliente cliente;
    private Date dataVenda;
    private Double valorTotal;
    private Situacao situacao;
    private List<ItemVenda> itens;
    private List<ItemVenda> itensRemover;

    public Venda() {
        this.codigo = 0;
        this.cliente = new Cliente();
        this.dataVenda = new Date();
        this.valorTotal = 0.0;
        this.itens = new ArrayList<>();
        this.itensRemover = new ArrayList<>();
    }

    public Venda(int codigo) {
        this.codigo = codigo;
        this.cliente = new Cliente();
        this.dataVenda = new Date();
        this.valorTotal = 0.0;
        this.itens = new ArrayList<>();
        this.itensRemover = new ArrayList<>();

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorTotal() {
        double total = 0;
        for (ItemVenda iv : itens) {
            total += (iv.getValorUnitario() * iv.getQuantidade());
        }
        return total;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public void setSituacao(int situacao) {
        if (situacao == Situacao.ABERTA.getId()) {
            setSituacao(Situacao.ABERTA);
        } else if (situacao == Situacao.FINALIZADA.getId()) {
            setSituacao(Situacao.FINALIZADA);
        } else if (situacao == Situacao.CANCELADA.getId()) {
            setSituacao(Situacao.CANCELADA);
        }
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public List<ItemVenda> getItensRemover() {
        return itensRemover;
    }

    public void addItem(ItemVenda itemVenda) {
        itens.add(itemVenda);
    }

    public void removeItem(ItemVenda itemVenda) {
        itens.remove(itemVenda);
        if (itemVenda.getCodigo() != 0) {
            itensRemover.add(itemVenda);
        }
    }

    public int quantidadeItens() {
        return itens.size();
    }
}
