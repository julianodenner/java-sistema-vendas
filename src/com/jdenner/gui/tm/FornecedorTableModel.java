package com.jdenner.gui.tm;

import com.jdenner.to.Fornecedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que define o modelo para tabela contendo dados do fornecedor
 *
 * @author Juliano
 */
public class FornecedorTableModel extends AbstractTableModel {

    private String colunas[] = {"Nome", "CNPJ"};
    private List<Fornecedor> dados;

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
        Fornecedor fornecedor = dados.get(l);
        switch (c) {
            case 0:
                return fornecedor.getNome();
            case 1:
                return fornecedor.getCnpj();
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

    public void setDados(List<Fornecedor> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Fornecedor getRowValue(int l) {
        return dados.get(l);
    }
}
