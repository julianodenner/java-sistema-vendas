package com.jdenner.gui;

import com.jdenner.dao.CompraDAO;
import com.jdenner.gui.tm.CompraTableModel;
import com.jdenner.gui.tm.ItemCompraTableModel;
import com.jdenner.to.Compra;
import com.jdenner.to.Fornecedor;
import com.jdenner.to.ItemCompra;
import com.jdenner.to.Produto;
import com.jdenner.to.enums.Situacao;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Janela de lançamento de compra
 *
 * @author Juliano
 */
public class LancamentoCompra extends javax.swing.JInternalFrame {

    private Compra compra = null;
    private CompraDAO compraDAO = new CompraDAO();

    public LancamentoCompra() {
        initComponents();
        habilitarFormulario(false);
        carregarGrade();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        pnBarraFerramentas = new javax.swing.JPanel();
        barraFerramentas = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        tpConteudo = new javax.swing.JTabbedPane();
        pnCabecalho = new javax.swing.JPanel();
        pnForm = new javax.swing.JPanel();
        lbFornecedor = new javax.swing.JLabel();
        lbValorTotal = new javax.swing.JLabel();
        lbDataCompra = new javax.swing.JLabel();
        ftfFornecedor = new javax.swing.JFormattedTextField();
        btFornecedor = new javax.swing.JButton();
        ftfValorTotal = new javax.swing.JFormattedTextField();
        ftfDataCompra = new javax.swing.JFormattedTextField();
        spGrade = new javax.swing.JScrollPane();
        tbGrade = new javax.swing.JTable();
        pnItens = new javax.swing.JPanel();
        pnFormItens = new javax.swing.JPanel();
        lbProduto = new javax.swing.JLabel();
        lbValorUnitario = new javax.swing.JLabel();
        lbQuantidade = new javax.swing.JLabel();
        ftfProduto = new javax.swing.JFormattedTextField();
        btProduto = new javax.swing.JButton();
        ftfValorUnitario = new javax.swing.JFormattedTextField();
        spQuantidade = new javax.swing.JSpinner();
        btAdicionarItem = new javax.swing.JButton();
        btRemoverItem = new javax.swing.JButton();
        spGradeItens = new javax.swing.JScrollPane();
        tbGradeItens = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("Vendas");

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

        btFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/finalizar.png"))); // NOI18N
        btFinalizar.setText("Finalizar");
        btFinalizar.setFocusable(false);
        btFinalizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFinalizar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btFinalizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/finalizar-foco.png"))); // NOI18N
        btFinalizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });
        barraFerramentas.add(btFinalizar);

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

        pnCabecalho.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
        pnCabecalho.setLayout(new java.awt.BorderLayout());

        pnForm.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0), javax.swing.BorderFactory.createTitledBorder(null, "Formulário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 153, 255)))); // NOI18N
        pnForm.setOpaque(false);
        pnForm.setLayout(new java.awt.GridBagLayout());

        lbFornecedor.setText("Fornecedor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(lbFornecedor, gridBagConstraints);

        lbValorTotal.setText("Valor Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(lbValorTotal, gridBagConstraints);

        lbDataCompra.setText("Data Compra:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(lbDataCompra, gridBagConstraints);

        ftfFornecedor.setEditable(false);
        ftfFornecedor.setColumns(25);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(ftfFornecedor, gridBagConstraints);

        btFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/buscar.png"))); // NOI18N
        btFornecedor.setToolTipText("Localizar cliente");
        btFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btFornecedor.setPreferredSize(new java.awt.Dimension(21, 21));
        btFornecedor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/buscar-foco.png"))); // NOI18N
        btFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFornecedorActionPerformed(evt);
            }
        });
        pnForm.add(btFornecedor, new java.awt.GridBagConstraints());

        ftfValorTotal.setEditable(false);
        ftfValorTotal.setColumns(10);
        ftfValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        ftfValorTotal.setValue(new Double(0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(ftfValorTotal, gridBagConstraints);

        ftfDataCompra.setEditable(false);
        ftfDataCompra.setColumns(10);
        ftfDataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        ftfDataCompra.setValue(new Date());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnForm.add(ftfDataCompra, gridBagConstraints);

        pnCabecalho.add(pnForm, java.awt.BorderLayout.PAGE_START);

        tbGrade.setModel(new CompraTableModel());
        tbGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGradeMouseClicked(evt);
            }
        });
        spGrade.setViewportView(tbGrade);

        pnCabecalho.add(spGrade, java.awt.BorderLayout.CENTER);

        tpConteudo.addTab("Dados da compra", pnCabecalho);

        pnItens.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
        pnItens.setLayout(new java.awt.BorderLayout());

        pnFormItens.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0), javax.swing.BorderFactory.createTitledBorder(null, "Formulário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 153, 255)))); // NOI18N
        pnFormItens.setOpaque(false);
        pnFormItens.setLayout(new java.awt.GridBagLayout());

        lbProduto.setText("Produto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnFormItens.add(lbProduto, gridBagConstraints);

        lbValorUnitario.setText("Valor Unitário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnFormItens.add(lbValorUnitario, gridBagConstraints);

        lbQuantidade.setText("Quantidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnFormItens.add(lbQuantidade, gridBagConstraints);

        ftfProduto.setEditable(false);
        ftfProduto.setColumns(25);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnFormItens.add(ftfProduto, gridBagConstraints);

        btProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/buscar.png"))); // NOI18N
        btProduto.setToolTipText("Localizar produto");
        btProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btProduto.setPreferredSize(new java.awt.Dimension(21, 21));
        btProduto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/buscar-foco.png"))); // NOI18N
        btProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnFormItens.add(btProduto, gridBagConstraints);

        ftfValorUnitario.setColumns(10);
        ftfValorUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        ftfValorUnitario.setValue(new Double(0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnFormItens.add(ftfValorUnitario, gridBagConstraints);

        spQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000000, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        pnFormItens.add(spQuantidade, gridBagConstraints);

        btAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/novo.png"))); // NOI18N
        btAdicionarItem.setToolTipText("Adicionar item");
        btAdicionarItem.setPreferredSize(new java.awt.Dimension(35, 30));
        btAdicionarItem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/novo-foco.png"))); // NOI18N
        btAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarItemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pnFormItens.add(btAdicionarItem, gridBagConstraints);

        btRemoverItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/excluir.png"))); // NOI18N
        btRemoverItem.setToolTipText("Remover item");
        btRemoverItem.setPreferredSize(new java.awt.Dimension(35, 30));
        btRemoverItem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jdenner/gui/img/excluir-foco.png"))); // NOI18N
        btRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverItemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        pnFormItens.add(btRemoverItem, gridBagConstraints);

        pnItens.add(pnFormItens, java.awt.BorderLayout.PAGE_START);

        tbGradeItens.setModel(new ItemCompraTableModel());
        spGradeItens.setViewportView(tbGradeItens);

        pnItens.add(spGradeItens, java.awt.BorderLayout.CENTER);

        tpConteudo.addTab("Itens da compra", pnItens);

        getContentPane().add(tpConteudo, java.awt.BorderLayout.CENTER);

        setBounds(10, 10, 450, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        compra = new Compra();
        habilitarFormulario(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        salvar(false);
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitarFormulario(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFornecedorActionPerformed
        BuscaFornecedor buscaFornecedor = new BuscaFornecedor(this);
        buscaFornecedor.setVisible(true);
    }//GEN-LAST:event_btFornecedorActionPerformed

    private void btProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutoActionPerformed
        BuscaProduto buscaProduto = new BuscaProduto(this);
        buscaProduto.setVisible(true);
    }//GEN-LAST:event_btProdutoActionPerformed

    private void btAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarItemActionPerformed
        if (validarFormularioItens()) {
            ItemCompra iv = new ItemCompra();
            iv.setProduto((Produto) ftfProduto.getValue());
            iv.setCompra(compra);
            iv.setQuantidade((int) spQuantidade.getValue());
            iv.setValorUnitario((Double) ftfValorUnitario.getValue());

            compra.addItem(iv);

            ItemCompraTableModel ivtm = (ItemCompraTableModel) tbGradeItens.getModel();
            ivtm.setDados(compra.getItens());

            ftfValorTotal.setValue(compra.getValorTotal());

            limpaFormularioItens();
        }
    }//GEN-LAST:event_btAdicionarItemActionPerformed

    private void btRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverItemActionPerformed
        if (tbGradeItens.getSelectedRowCount() > 0) {
            int linhaSelecionada = tbGradeItens.getSelectedRow();
            ItemCompraTableModel ivtm = (ItemCompraTableModel) tbGradeItens.getModel();
            ItemCompra iv = ivtm.getRowValue(linhaSelecionada);

            if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o item " + iv + "?", "Confirmação", JOptionPane.YES_NO_OPTION) == 0) {
                compra.removeItem(iv);
                ivtm.setDados(compra.getItens());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para remover.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btRemoverItemActionPerformed

    private void tbGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGradeMouseClicked
        if (evt.getClickCount() == 2) {
            int linhaSelecionada = tbGrade.getSelectedRow();
            CompraTableModel vtm = (CompraTableModel) tbGrade.getModel();
            compra = vtm.getRowValue(linhaSelecionada);

            if (compra.getSituacao() == Situacao.FINALIZADA) {
                JOptionPane.showMessageDialog(this, "Compra finalizada não pode ser alterada.", "Alerta", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (compra.getSituacao() == Situacao.CANCELADA) {
                JOptionPane.showMessageDialog(this, "Compra cancelada não pode ser alterada.", "Alerta", JOptionPane.WARNING_MESSAGE);
                return;
            }

            ftfFornecedor.setValue(compra.getFornecedor());
            ftfDataCompra.setValue(compra.getDataCompra());
            ftfValorTotal.setValue(compra.getValorTotal());

            ItemCompraTableModel ivtm = (ItemCompraTableModel) tbGradeItens.getModel();
            ivtm.setDados(compra.getItens());

            habilitarFormulario(true);
        }
    }//GEN-LAST:event_tbGradeMouseClicked

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar a compra?");
        if (opcao == 0) {
            salvar(true);
        }
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar a compra " + compra + "?");
        if (opcao == 0) {
            try {
                compraDAO.excluir(compra);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir a compra.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            habilitarFormulario(false);
            carregarGrade();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    public void setFornecedor(Fornecedor cliente) {
        ftfFornecedor.setValue(cliente);
    }

    public void setProduto(Produto produto) {
        ftfProduto.setValue(produto);
        ftfValorUnitario.setValue(produto.getPrecoCompra());
    }

    private void habilitarFormulario(boolean ativo) {
        btNovo.setEnabled(!ativo);
        btSalvar.setEnabled(ativo);
        btFinalizar.setEnabled(ativo);
        btExcluir.setEnabled(ativo);
        btCancelar.setEnabled(ativo);
        ftfFornecedor.setEnabled(ativo);
        btFornecedor.setEnabled(ativo);
        ftfDataCompra.setEnabled(ativo);
        ftfValorTotal.setEnabled(ativo);
        ftfProduto.setEnabled(ativo);
        btProduto.setEnabled(ativo);
        spQuantidade.setEnabled(ativo);
        ftfValorUnitario.setEnabled(ativo);
        btAdicionarItem.setEnabled(ativo);
        btRemoverItem.setEnabled(ativo);
        tbGrade.setEnabled(!ativo);

        if (!ativo) {
            limpaFormulario();
        }
    }

    private void limpaFormulario() {
        compra = null;
        ftfFornecedor.setValue(null);
        ftfDataCompra.setValue(new Date());
        ftfValorTotal.setValue(new Double(0));
        ftfProduto.setValue(null);
        spQuantidade.setValue(1);
        ftfValorUnitario.setValue(new Double(0));
        tbGradeItens.setModel(new ItemCompraTableModel());
        limpaFormularioItens();
    }

    private void limpaFormularioItens() {
        ftfProduto.setValue(null);
        spQuantidade.setValue(1);
        ftfValorUnitario.setValue(new Double(0));
    }

    private boolean validarFormulario() {
        if (ftfFornecedor.getValue() == null) {
            JOptionPane.showMessageDialog(this, "Fornecedor inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfFornecedor.requestFocus();
            return false;
        }
        if (compra.quantidadeItens() == 0) {
            JOptionPane.showMessageDialog(this, "Quantidade de itens inválida.", "Alerta", JOptionPane.WARNING_MESSAGE);
            tpConteudo.setSelectedIndex(1);
            return false;
        }
        return true;
    }

    private boolean validarFormularioItens() {
        if (ftfProduto.getValue() == null) {
            JOptionPane.showMessageDialog(this, "Produto inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfProduto.requestFocus();
            return false;
        }
        return true;
    }

    private void carregarGrade() {
        CompraTableModel tm = (CompraTableModel) tbGrade.getModel();
        try {
            tm.setDados(compraDAO.listarTodos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvar(boolean finalizar) {
        if (validarFormulario()) {
            compra.setFornecedor((Fornecedor) ftfFornecedor.getValue());
            compra.setDataCompra((Date) ftfDataCompra.getValue());
            if (finalizar) {
                compra.setSituacao(Situacao.FINALIZADA);
            } else {
                compra.setSituacao(Situacao.ABERTA);
            }

            if (compra.getCodigo() == 0) {
                try {
                    compraDAO.inserir(compra);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir a compra.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                try {
                    compraDAO.alterar(compra);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar a compra.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            habilitarFormulario(false);
            carregarGrade();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraFerramentas;
    private javax.swing.JButton btAdicionarItem;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btFornecedor;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btProduto;
    private javax.swing.JButton btRemoverItem;
    private javax.swing.JButton btSalvar;
    private javax.swing.JFormattedTextField ftfDataCompra;
    private javax.swing.JFormattedTextField ftfFornecedor;
    private javax.swing.JFormattedTextField ftfProduto;
    private javax.swing.JFormattedTextField ftfValorTotal;
    private javax.swing.JFormattedTextField ftfValorUnitario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbDataCompra;
    private javax.swing.JLabel lbFornecedor;
    private javax.swing.JLabel lbProduto;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JLabel lbValorUnitario;
    private javax.swing.JPanel pnBarraFerramentas;
    private javax.swing.JPanel pnCabecalho;
    private javax.swing.JPanel pnForm;
    private javax.swing.JPanel pnFormItens;
    private javax.swing.JPanel pnItens;
    private javax.swing.JScrollPane spGrade;
    private javax.swing.JScrollPane spGradeItens;
    private javax.swing.JSpinner spQuantidade;
    private javax.swing.JTable tbGrade;
    private javax.swing.JTable tbGradeItens;
    private javax.swing.JTabbedPane tpConteudo;
    // End of variables declaration//GEN-END:variables

}
