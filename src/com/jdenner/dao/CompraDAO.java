package com.jdenner.dao;

import com.jdenner.to.Compra;
import com.jdenner.to.ItemCompra;
import com.jdenner.to.enums.Situacao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe de acesso a dados da compra
 *
 * @author Juliano
 */
public class CompraDAO implements IDAO<Compra> {

    @Override
    public void inserir(Compra compra) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO TBCOMPRA (CODIGOFORNECEDOR, DATACOMPRA, VALORTOTAL, SITUACAO) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, compra.getFornecedor().getCodigo());
        ps.setDate(2, new Date(compra.getDataCompra().getTime()));
        ps.setDouble(3, compra.getValorTotal());
        ps.setInt(4, compra.getSituacao().getId());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int idCompra = rs.getInt(1);

        for (ItemCompra iv : compra.getItens()) {
            sql = "INSERT INTO TBITEMCOMPRA (CODIGOPRODUTO, CODIGOCOMPRA, QUANTIDADE, VALORUNITARIO) VALUES (?, ?, ?, ?)";
            ps = c.getConexao().prepareStatement(sql);
            ps.setInt(1, iv.getProduto().getCodigo());
            ps.setInt(2, idCompra);
            ps.setInt(3, iv.getQuantidade());
            ps.setDouble(4, iv.getValorUnitario());
            ps.execute();

            if (compra.getSituacao() == Situacao.FINALIZADA) {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.entradaEstoque(c, iv.getProduto().getCodigo(), iv.getQuantidade());
            }
        }
        c.confirmar();
    }

    @Override
    public void alterar(Compra compra) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TBCOMPRA SET CODIGOFORNECEDOR=?, DATACOMPRA=?, VALORTOTAL=?, SITUACAO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, compra.getFornecedor().getCodigo());
        ps.setDate(2, new Date(compra.getDataCompra().getTime()));
        ps.setDouble(3, compra.getValorTotal());
        ps.setInt(4, compra.getSituacao().getId());
        ps.setInt(5, compra.getCodigo());
        ps.execute();

        for (ItemCompra iv : compra.getItensRemover()) {
            sql = "DELETE FROM TBITEMCOMPRA WHERE CODIGO=?";
            ps = c.getConexao().prepareStatement(sql);
            ps.setInt(1, iv.getCodigo());
            ps.execute();
        }

        for (ItemCompra iv : compra.getItens()) {
            if (iv.getCodigo() == 0) {
                sql = "INSERT INTO TBITEMCOMPRA (CODIGOPRODUTO, CODIGOCOMPRA, QUANTIDADE, VALORUNITARIO) VALUES (?, ?, ?, ?)";
                ps = c.getConexao().prepareStatement(sql);
                ps.setInt(1, iv.getProduto().getCodigo());
                ps.setInt(2, iv.getCompra().getCodigo());
                ps.setInt(3, iv.getQuantidade());
                ps.setDouble(4, iv.getValorUnitario());
                ps.execute();
            } else {
                sql = "UPDATE TBITEMCOMPRA SET CODIGOPRODUTO=?, CODIGOCOMPRA=?, QUANTIDADE=?, VALORUNITARIO=? WHERE CODIGO=?";
                ps = c.getConexao().prepareStatement(sql);
                ps.setInt(1, iv.getProduto().getCodigo());
                ps.setInt(2, iv.getCompra().getCodigo());
                ps.setInt(3, iv.getQuantidade());
                ps.setDouble(4, iv.getValorUnitario());
                ps.setInt(5, iv.getCodigo());
                ps.execute();
            }

            if (compra.getSituacao() == Situacao.FINALIZADA) {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.entradaEstoque(c, iv.getProduto().getCodigo(), iv.getQuantidade());
            }
        }

        c.confirmar();
    }

    @Override
    public void excluir(Compra compra) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TBCOMPRA SET CODIGOFORNECEDOR=?, DATACOMPRA=?, VALORTOTAL=?, SITUACAO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, compra.getFornecedor().getCodigo());
        ps.setDate(2, new Date(compra.getDataCompra().getTime()));
        ps.setDouble(3, compra.getValorTotal());
        ps.setInt(4, Situacao.CANCELADA.getId());
        ps.setInt(5, compra.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Compra> listarTodos() throws Exception {
        Conexao c = new Conexao();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        String sql = "SELECT * FROM TBCOMPRA ORDER BY DATACOMPRA DESC";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaCompras = new ArrayList();
        while (rs.next()) {
            Compra compra = new Compra();
            compra.setCodigo(rs.getInt("CODIGO"));
            compra.setFornecedor(fornecedorDAO.recuperar(rs.getInt("CODIGOFORNECEDOR")));
            compra.setDataCompra(rs.getDate("DATACOMPRA"));
            compra.setSituacao(rs.getInt("SITUACAO"));

            String sqlItem = "SELECT * FROM TBITEMCOMPRA WHERE CODIGOCOMPRA=?";
            PreparedStatement psItem = c.getConexao().prepareStatement(sqlItem);
            psItem.setInt(1, compra.getCodigo());
            ResultSet rsItem = psItem.executeQuery();

            while (rsItem.next()) {
                ItemCompra iv = new ItemCompra();
                iv.setCodigo(rsItem.getInt("CODIGO"));
                iv.setProduto(produtoDAO.recuperar(rsItem.getInt("CODIGOPRODUTO")));
                iv.setCompra(compra);
                iv.setQuantidade(rsItem.getInt("QUANTIDADE"));
                iv.setValorUnitario(rsItem.getDouble("VALORUNITARIO"));
                compra.addItem(iv);
            }

            listaCompras.add(compra);
        }

        return listaCompras;
    }

    @Override
    public Compra recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        String sql = "SELECT * FROM TBCOMPRA ORDER BY DATACOMPRA DESC";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        Compra compra = new Compra();
        if (rs.next()) {
            compra.setCodigo(rs.getInt("CODIGO"));
            compra.setFornecedor(fornecedorDAO.recuperar(rs.getInt("CODIGOFORNECEDOR")));
            compra.setDataCompra(rs.getDate("DATACOMPRA"));
            compra.setSituacao(rs.getInt("SITUACAO"));

            String sqlItem = "SELECT * FROM TBITEMCOMPRA WHERE CODIGOCOMPRA=?";
            PreparedStatement psItem = c.getConexao().prepareStatement(sqlItem);
            psItem.setInt(1, compra.getCodigo());
            ResultSet rsItem = psItem.executeQuery();

            while (rsItem.next()) {
                ItemCompra iv = new ItemCompra();
                iv.setCodigo(rsItem.getInt("CODIGO"));
                iv.setProduto(produtoDAO.recuperar(rsItem.getInt("CODIGOPRODUTO")));
                iv.setCompra(compra);
                iv.setQuantidade(rsItem.getInt("QUANTIDADE"));
                iv.setValorUnitario(rsItem.getDouble("VALORUNITARIO"));
                compra.addItem(iv);
            }
        }

        return compra;
    }
}
