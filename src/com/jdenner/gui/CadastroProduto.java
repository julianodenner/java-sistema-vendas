package com.jdenner.gui;

import com.jdenner.dao.ProdutoDAO;
import com.jdenner.gui.tm.ProdutoTableModel;
import com.jdenner.to.Produto;
import javax.swing.JOptionPane;

/**
 * Janela de cadastro de produto
 *
 * @author Juliano
 */
public class CadastroProduto extends javax.swing.JInternalFrame {

    private Produto produto = null;
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public CadastroProduto() {
        initComponents();
        habilitarFormulario(false);
        carregarGrade();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnBarraFerramentas = new javax.swing.JPanel();
        barraFerramentas = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        pnConteudo = new javax.swing.JPanel();
        pnForm = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        lbPrecoCompra = new javax.swing.JLabel();
        lbPrecoVenda = new javax.swing.JLabel();
        ftfNome = new javax.swing.JFormattedTextField();
        ftfPrecoCompra = new javax.swing.JFormattedTextField();
        ftfPrecoVenda = new javax.swing.JFormattedTextField();
        spGrade = new javax.swing.JScrollPane();
        tbGrade = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de produtos");

        pnBarraFerramentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
        pnBarraFerramentas.setOpaque(false);
        pnBarraFerramentas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        barraFerramentas.setFloatable(false);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/novo.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.setFocusable(false);
        btNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNovo.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btNovo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/novo-foco.png"))); // NOI18N
        btNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        barraFerramentas.add(btNovo);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/salvar.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setFocusable(false);
        btSalvar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalvar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btSalvar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/salvar-foco.png"))); // NOI18N
        btSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        barraFerramentas.add(btSalvar);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/excluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setFocusable(false);
        btExcluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExcluir.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btExcluir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/excluir-foco.png"))); // NOI18N
        btExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        barraFerramentas.add(btExcluir);

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setFocusable(false);
        btCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/cancelar-foco.png"))); // NOI18N
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        barraFerramentas.add(btCancelar);

        pnBarraFerramentas.add(barraFerramentas);

        getContentPane().add(pnBarraFerramentas, java.awt.BorderLayout.PAGE_START);

        pnConteudo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
        pnConteudo.setLayout(new java.awt.BorderLayout());

        pnForm.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0), javax.swing.BorderFactory.createTitledBorder(null, "Formulário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 153, 255)))); // NOI18N
        pnForm.setOpaque(false);
        pnForm.setLayout(new java.awt.GridBagLayout());

        lbNome.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(lbNome, gridBagConstraints);

        lbPrecoCompra.setText("Preço de compra:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(lbPrecoCompra, gridBagConstraints);

        lbPrecoVenda.setText("Preço de venda:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(lbPrecoVenda, gridBagConstraints);

        ftfNome.setColumns(25);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(ftfNome, gridBagConstraints);

        ftfPrecoCompra.setColumns(10);
        ftfPrecoCompra.setValue(new Double(0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(ftfPrecoCompra, gridBagConstraints);

        ftfPrecoVenda.setColumns(10);
        ftfPrecoVenda.setValue(new Double(0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(ftfPrecoVenda, gridBagConstraints);

        pnConteudo.add(pnForm, java.awt.BorderLayout.PAGE_START);

        tbGrade.setAutoCreateRowSorter(true);
        tbGrade.setModel(new ProdutoTableModel());
        tbGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGradeMouseClicked(evt);
            }
        });
        spGrade.setViewportView(tbGrade);

        pnConteudo.add(spGrade, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnConteudo, java.awt.BorderLayout.CENTER);

        setBounds(10, 10, 400, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        produto = new Produto();
        habilitarFormulario(true);
        btExcluir.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (validarFormulario()) {
            produto.setNome(ftfNome.getText().trim());
            produto.setPrecoCompra((Double) ftfPrecoCompra.getValue());
            produto.setPrecoVenda((Double) ftfPrecoVenda.getValue());

            if (produto.getCodigo() == 0) {
                try {
                    produtoDAO.inserir(produto);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir o produto.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                try {
                    produtoDAO.alterar(produto);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar o produto.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            habilitarFormulario(false);
            carregarGrade();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o produto " + produto + "?");
        if (opcao == 0) {
            try {
                produtoDAO.excluir(produto);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o produto.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            habilitarFormulario(false);
            carregarGrade();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitarFormulario(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tbGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGradeMouseClicked
        if (evt.getClickCount() == 2) {
            ProdutoTableModel tm = (ProdutoTableModel) tbGrade.getModel();
            produto = tm.getRowValue(tbGrade.getRowSorter().convertRowIndexToModel(tbGrade.getSelectedRow()));

            ftfNome.setValue(produto.getNome());
            ftfPrecoCompra.setValue(produto.getPrecoCompra());
            ftfPrecoVenda.setValue(produto.getPrecoVenda());

            habilitarFormulario(true);
        }
    }//GEN-LAST:event_tbGradeMouseClicked

    private void habilitarFormulario(boolean ativo) {
        btNovo.setEnabled(!ativo);
        btSalvar.setEnabled(ativo);
        btExcluir.setEnabled(ativo);
        btCancelar.setEnabled(ativo);
        ftfNome.setEnabled(ativo);
        ftfPrecoCompra.setEnabled(ativo);
        ftfPrecoVenda.setEnabled(ativo);
        tbGrade.setEnabled(!ativo);

        if (!ativo) {
            limpaFormulario();
        }
    }

    private void limpaFormulario() {
        produto = null;
        ftfNome.setValue("");
        ftfPrecoCompra.setValue(new Double(0));
        ftfPrecoVenda.setValue(new Double(0));
    }

    private boolean validarFormulario() {
        if (ftfNome.getText().trim().length() < 2) {
            JOptionPane.showMessageDialog(this, "Nome inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfNome.requestFocus();
            return false;
        }
        if (((Double) ftfPrecoCompra.getValue()) <= 0) {
            JOptionPane.showMessageDialog(this, "Preço de compra inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfPrecoCompra.requestFocus();
            return false;
        }
        if (((Double) ftfPrecoVenda.getValue()) <= 0) {
            JOptionPane.showMessageDialog(this, "Preço de venda inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfPrecoVenda.requestFocus();
            return false;
        }
        if (((Double) ftfPrecoVenda.getValue()) <= ((Double) ftfPrecoCompra.getValue())) {
            JOptionPane.showMessageDialog(this, "Preço de venda menor que preço de compra.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfPrecoVenda.requestFocus();
            return false;
        }
        return true;
    }

    private void carregarGrade() {
        ProdutoTableModel tm = (ProdutoTableModel) tbGrade.getModel();
        try {
            tm.setDados(produtoDAO.listarTodos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraFerramentas;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JFormattedTextField ftfNome;
    private javax.swing.JFormattedTextField ftfPrecoCompra;
    private javax.swing.JFormattedTextField ftfPrecoVenda;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPrecoCompra;
    private javax.swing.JLabel lbPrecoVenda;
    private javax.swing.JPanel pnBarraFerramentas;
    private javax.swing.JPanel pnConteudo;
    private javax.swing.JPanel pnForm;
    private javax.swing.JScrollPane spGrade;
    private javax.swing.JTable tbGrade;
    // End of variables declaration//GEN-END:variables
}
