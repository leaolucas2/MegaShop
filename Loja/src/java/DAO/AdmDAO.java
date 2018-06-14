/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Notebook
 */
public class AdmDAO {
    public ArrayList<Administrador> Listar() {
        ArrayList<Administrador> administradores = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM ADMINISTRADOR";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Administrador administrador;
                    administrador = new Administrador(Integer.parseInt(resultado.getString("ID")),resultado.getString("NOME"),resultado.getString("SENHA"));
                    administradores.add(administrador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return administradores;

    }
    public void Inserir(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO ADMINISTRADOR (nome, senha) VALUES (?,?)");
            sql.setString(1, administrador.getNome());
            sql.setString(2, administrador.getSenha());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public Administrador get(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE ID = ? ");
            sql.setInt(1, administrador.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    administrador.setNome(resultado.getString("NOME"));
                    administrador.setSenha(resultado.getString("SENHA"));
                }
            }
            return administrador;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
     public Administrador Login(String nome) throws Exception {
        Conexao conexao = new Conexao();
        try {
            Administrador administrador = new Administrador();
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE NOME = ? ");
            sql.setString(1, nome);
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                
                while (resultado.next()) {
                    administrador.setNome(resultado.getString("NOME"));
                    administrador.setSenha(resultado.getString("SENHA"));
                }
            }
            return administrador;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE ADMINISTRADOR SET nome = ?, senha = ?  WHERE ID = ? ");
            sql.setString(1, administrador.getNome());
            sql.setString(2, administrador.getSenha());
            sql.setInt(3, administrador.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM ADMINISTRADOR WHERE ID = ? ");
            sql.setInt(1, administrador.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }


}
