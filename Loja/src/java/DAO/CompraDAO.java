package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompraDAO {
    public ArrayList<Compra> Listar() {
        ArrayList<Compra> compras = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM COMPRA";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Compra compra;
                    compra = new Compra(Integer.parseInt(resultado.getString("ID")),Integer.parseInt(resultado.getString("ID_PRODUTO")),Integer.parseInt(resultado.getString("ID_USUARIO")));
                    compras.add(compra);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return compras;

    }
    public void Inserir(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO COMPRA (id_produto,id_usuario) VALUES (?,?)");
            sql.setInt(1, compra.getId_produto());
            sql.setInt(2, compra.getId_usuario());
 
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public Compra get(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM COMPRA WHERE ID = ? ");
            sql.setInt(1, compra.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    compra.setId_produto(resultado.getInt("ID_PRODUTO"));
                    compra.setId_usuario(resultado.getInt("ID_USUARIO"));
                    
                }
            }
            return compra;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE COMPRA SET id_produto = ?, id_usuario = ? WHERE ID = ? ");
            sql.setInt(1, compra.getId_produto());
            sql.setInt(2, compra.getId_usuario());
            sql.setInt(3, compra.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM COMPRA WHERE ID = ? ");
            sql.setInt(1, compra.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

}
