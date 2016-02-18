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
    private String colunas[] = {"Cliente", "Data", "Valor", "Situação"};
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
                return SDF.format(venda.getDataVenda());
            case 2:
                return NFC.format(venda.getValorTotal());
            case 3:
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
