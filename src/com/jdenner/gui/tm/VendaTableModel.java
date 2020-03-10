package com.jdenner.gui.tm;

import com.jdenner.to.Venda;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que define o modelo para tabela contendo dados da venda
 *
 * @author Juliano
 */
public class VendaTableModel extends AbstractTableModel {

    private final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    private final NumberFormat NFC = NumberFormat.getCurrencyInstance();
    private String colunas[] = {"Cliente", "Produto(s)", "Data", "Valor", "Situação"};
    private List<Venda> dados;

    @Override
    public int getRowCount() {
        if(dados == null){
            return 0;
        }
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int l, int c) {
        Venda venda = dados.get(l);
        switch (c) {
            case 0:
                return venda.getCliente().getNome();
            case 1:
                String produtos = "";
                for(int i=0; i<venda.getItens().size(); i++) {
                    produtos += venda.getItens().get(i).getProduto().getNome() + " - " + venda.getItens().get(i).getQuantidade();
                    if(i < venda.getItens().size() - 1) {
                        produtos += ", ";
                    }
                }
                return produtos;
            case 2:
                return SDF.format(venda.getDataVenda());
            case 3:
                return NFC.format(venda.getValorTotal());
            case 4:
                return venda.getSituacao();
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }

    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }

    @Override
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public void setDados(List<Venda> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Venda getRowValue(int l) {
        return dados.get(l);
    }
}
