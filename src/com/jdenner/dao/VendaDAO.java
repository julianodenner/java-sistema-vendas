package com.jdenner.dao;

import com.jdenner.to.ItemVenda;
import com.jdenner.to.Venda;
import com.jdenner.to.enums.Situacao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe de acesso a dados da venda
 *
 * @author Juliano
 */
public class VendaDAO implements IDAO<Venda> {

    @Override
    public void inserir(Venda venda) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO TBVENDA (CODIGOCLIENTE, DATAVENDA, VALORTOTAL, SITUACAO) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, venda.getCliente().getCodigo());
        ps.setDate(2, new Date(venda.getDataVenda().getTime()));
        ps.setDouble(3, venda.getValorTotal());
        ps.setInt(4, venda.getSituacao().getId());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int idVenda = rs.getInt(1);

        for (ItemVenda iv : venda.getItens()) {
            sql = "INSERT INTO TBITEMVENDA (CODIGOPRODUTO, CODIGOVENDA, QUANTIDADE, VALORUNITARIO) VALUES (?, ?, ?, ?)";
            ps = c.getConexao().prepareStatement(sql);
            ps.setInt(1, iv.getProduto().getCodigo());
            ps.setInt(2, idVenda);
            ps.setInt(3, iv.getQuantidade());
            ps.setDouble(4, iv.getValorUnitario());
            ps.execute();

            if (venda.getSituacao() == Situacao.FINALIZADA) {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.saidaEstoque(c, iv.getProduto().getCodigo(), iv.getQuantidade());
            }
        }
        c.confirmar();
    }

    @Override
    public void alterar(Venda venda) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TBVENDA SET CODIGOCLIENTE=?, DATAVENDA=?, VALORTOTAL=?, SITUACAO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, venda.getCliente().getCodigo());
        ps.setDate(2, new Date(venda.getDataVenda().getTime()));
        ps.setDouble(3, venda.getValorTotal());
        ps.setInt(4, venda.getSituacao().getId());
        ps.setInt(5, venda.getCodigo());
        ps.execute();

        for (ItemVenda iv : venda.getItensRemover()) {
            sql = "DELETE FROM TBITEMVENDA WHERE CODIGO=?";
            ps = c.getConexao().prepareStatement(sql);
            ps.setInt(1, iv.getCodigo());
            ps.execute();
        }

        for (ItemVenda iv : venda.getItens()) {
            if (iv.getCodigo() == 0) {
                sql = "INSERT INTO TBITEMVENDA (CODIGOPRODUTO, CODIGOVENDA, QUANTIDADE, VALORUNITARIO) VALUES (?, ?, ?, ?)";
                ps = c.getConexao().prepareStatement(sql);
                ps.setInt(1, iv.getProduto().getCodigo());
                ps.setInt(2, iv.getVenda().getCodigo());
                ps.setInt(3, iv.getQuantidade());
                ps.setDouble(4, iv.getValorUnitario());
                ps.execute();
            } else {
                sql = "UPDATE TBITEMVENDA SET CODIGOPRODUTO=?, CODIGOVENDA=?, QUANTIDADE=?, VALORUNITARIO=? WHERE CODIGO=?";
                ps = c.getConexao().prepareStatement(sql);
                ps.setInt(1, iv.getProduto().getCodigo());
                ps.setInt(2, iv.getVenda().getCodigo());
                ps.setInt(3, iv.getQuantidade());
                ps.setDouble(4, iv.getValorUnitario());
                ps.setInt(5, iv.getCodigo());
                ps.execute();
            }

            if (venda.getSituacao() == Situacao.FINALIZADA) {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.saidaEstoque(c, iv.getProduto().getCodigo(), iv.getQuantidade());
            }
        }

        c.confirmar();
    }

    @Override
    public void excluir(Venda venda) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TBVENDA SET CODIGOCLIENTE=?, DATAVENDA=?, VALORTOTAL=?, SITUACAO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, venda.getCliente().getCodigo());
        ps.setDate(2, new Date(venda.getDataVenda().getTime()));
        ps.setDouble(3, venda.getValorTotal());
        ps.setInt(4, Situacao.CANCELADA.getId());
        ps.setInt(5, venda.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Venda> listarTodos() throws Exception {
        Conexao c = new Conexao();
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        String sql = "SELECT * FROM TBVENDA ORDER BY DATAVENDA DESC";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaVendas = new ArrayList();
        while (rs.next()) {
            Venda venda = new Venda();
            venda.setCodigo(rs.getInt("CODIGO"));
            venda.setCliente(clienteDAO.recuperar(rs.getInt("CODIGOCLIENTE")));
            venda.setDataVenda(rs.getDate("DATAVENDA"));
            venda.setSituacao(rs.getInt("SITUACAO"));

            String sqlItem = "SELECT * FROM TBITEMVENDA WHERE CODIGOVENDA=?";
            PreparedStatement psItem = c.getConexao().prepareStatement(sqlItem);
            psItem.setInt(1, venda.getCodigo());
            ResultSet rsItem = psItem.executeQuery();

            while (rsItem.next()) {
                ItemVenda iv = new ItemVenda();
                iv.setCodigo(rsItem.getInt("CODIGO"));
                iv.setProduto(produtoDAO.recuperar(rsItem.getInt("CODIGOPRODUTO")));
                iv.setVenda(venda);
                iv.setQuantidade(rsItem.getInt("QUANTIDADE"));
                iv.setValorUnitario(rsItem.getDouble("VALORUNITARIO"));
                venda.addItem(iv);
            }

            listaVendas.add(venda);
        }

        return listaVendas;
    }

    @Override
    public Venda recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        String sql = "SELECT * FROM TBVENDA ORDER BY DATAVENDA DESC";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        Venda venda = new Venda();
        if (rs.next()) {
            venda.setCodigo(rs.getInt("CODIGO"));
            venda.setCliente(clienteDAO.recuperar(rs.getInt("CODIGOCLIENTE")));
            venda.setDataVenda(rs.getDate("DATAVENDA"));
            venda.setSituacao(rs.getInt("SITUACAO"));

            String sqlItem = "SELECT * FROM TBITEMVENDA WHERE CODIGOVENDA=?";
            PreparedStatement psItem = c.getConexao().prepareStatement(sqlItem);
            psItem.setInt(1, venda.getCodigo());
            ResultSet rsItem = psItem.executeQuery();

            while (rsItem.next()) {
                ItemVenda iv = new ItemVenda();
                iv.setCodigo(rsItem.getInt("CODIGO"));
                iv.setProduto(produtoDAO.recuperar(rsItem.getInt("CODIGOPRODUTO")));
                iv.setVenda(venda);
                iv.setQuantidade(rsItem.getInt("QUANTIDADE"));
                iv.setValorUnitario(rsItem.getDouble("VALORUNITARIO"));
                venda.addItem(iv);
            }
        }

        return venda;
    }
}
