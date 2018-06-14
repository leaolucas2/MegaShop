package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Notebook
 */
public class ProdDAO {
    public ArrayList<Produto> Listar() {
        ArrayList<Produto> produtos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto(Integer.parseInt(resultado.getString("ID")),Integer.parseInt(resultado.getString("ID_CATEGORIA")),resultado.getString("NOME"),resultado.getString("DESCRICAO"),Float.parseFloat(resultado.getString("VALOR")));
                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return produtos;

    }
    
    public ArrayList<Produto> ListarPorNome(String nome) {
        ArrayList<Produto> produtos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE LOWER(NOME) LIKE LOWER(?) ");
            sql.setString(1,nome);
            ResultSet resultado = sql.executeQuery();
            
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto(Integer.parseInt(resultado.getString("ID")),Integer.parseInt(resultado.getString("ID_CATEGORIA")),resultado.getString("NOME"),resultado.getString("DESCRICAO"),Float.parseFloat(resultado.getString("VALOR")));
                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return produtos;

    }
    
    public ArrayList<Produto> ListarPorCategoria(int id) {
        ArrayList<Produto> produtos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE ID_CATEGORIA = ? ");
            sql.setInt(1,id);
            ResultSet resultado = sql.executeQuery();
            
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto(Integer.parseInt(resultado.getString("ID")),Integer.parseInt(resultado.getString("ID_CATEGORIA")),resultado.getString("NOME"),resultado.getString("DESCRICAO"),Float.parseFloat(resultado.getString("VALOR")));
                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return produtos;

    }
    
    public ArrayList<Categoria> ListarCategorias() {
        ArrayList<Categoria> categorias = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM CATEGORIA";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Categoria categoria;
                    categoria = new Categoria(Integer.parseInt(resultado.getString("ID")),resultado.getString("DESCRICAO"));
                    categorias.add(categoria);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return categorias;

    }
    public void Inserir(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO PRODUTO (id_categoria,nome,descricao,valor) VALUES (?,?,?,?)");
            sql.setInt(1, produto.getId_categoria());
            sql.setString(2,produto.getNome());
            sql.setString(3,produto.getDescricao());
            sql.setFloat(4, produto.getValor());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public Produto get(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE ID = ? ");
            sql.setInt(1, produto.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    produto.setNome(resultado.getString("NOME"));
                    produto.setDescricao(resultado.getString("DESCRICAO"));
                    produto.setId_categoria(resultado.getInt("ID_CATEGORIA"));
                    produto.setValor(resultado.getFloat("VALOR"));
                }
            }
            return produto;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE PRODUTO SET id_categoria = ?, nome = ? , descricao= ?, valor= ? WHERE ID = ? ");
            sql.setInt(1, produto.getId_categoria());
            sql.setString(2, produto.getNome());
            sql.setString(3, produto.getDescricao());
            sql.setFloat(4, produto.getValor());
            sql.setInt(5, produto.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM PRODUTO WHERE ID = ? ");
            sql.setInt(1, produto.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }


}
