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
public class UserDAO {
    public ArrayList<Usuario> Listar() {
        ArrayList<Usuario> usuarios = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM USUARIO";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Usuario usuario;
                    usuario = new Usuario(Integer.parseInt(resultado.getString("ID")),resultado.getString("NOME"),resultado.getString("CPF"),resultado.getString("RG"),resultado.getString("ENDERECO"),resultado.getString("BAIRRO"),resultado.getString("CIDADE"),resultado.getString("CEP"),resultado.getString("UF"),resultado.getString("REFERENCIA"),resultado.getString("TELEFONE"),resultado.getString("CELULAR"),resultado.getString("NUM_CARTAO"),resultado.getString("BANDEIRA"));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return usuarios;

    }
    public void Inserir(Usuario usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO USUARIO (nome,cpf,rg,endereco,bairro,cidade,cep,uf,referencia,telefone,celular,num_cartao,bandeira) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sql.setString(1, usuario.getNome());
            sql.setString(2, usuario.getCpf());
            sql.setString(3, usuario.getRg());
            sql.setString(4, usuario.getEndereco());
            sql.setString(5, usuario.getBairro());
            sql.setString(6, usuario.getCidade());
            sql.setString(7, usuario.getCep());
            sql.setString(8, usuario.getUf());
            sql.setString(9, usuario.getReferencia());
            sql.setString(10, usuario.getTelefone());
            sql.setString(11, usuario.getCelular());
            sql.setString(12, usuario.getNum_cartao());
            sql.setString(13, usuario.getBandeira());

            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public Usuario get(Usuario usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM USUARIO WHERE ID = ? ");
            sql.setInt(1, usuario.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    usuario.setNome(resultado.getString("NOME"));
                    usuario.setCpf(resultado.getString("CPF"));
                    usuario.setRg(resultado.getString("RG"));
                    usuario.setEndereco(resultado.getString("ENDERECO"));
                    usuario.setBairro(resultado.getString("BAIRRO"));
                    usuario.setCidade(resultado.getString("CIDADE"));
                    usuario.setCep(resultado.getString("CEP"));
                    usuario.setUf(resultado.getString("UF"));
                    usuario.setReferencia(resultado.getString("REFERENCIA"));
                    usuario.setTelefone(resultado.getString("TELEFONE"));
                    usuario.setCelular(resultado.getString("CELULAR"));
                    usuario.setNum_cartao(resultado.getString("NUM_CARTAO"));
                    usuario.setBandeira(resultado.getString("BANDEIRA"));
                }
            }
            return usuario;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Usuario usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE USUARIO SET nome = ?, cpf = ?, rg = ?, endereco = ?, bairro = ?, cidade = ?, cep = ?, uf = ?, referencia = ?, telefone = ?, celular = ?, num_cartao = ?, bandeira = ?  WHERE ID = ? ");
            sql.setString(1, usuario.getNome());
            sql.setString(2, usuario.getCpf());
            sql.setString(3, usuario.getRg());
            sql.setString(4, usuario.getEndereco());
            sql.setString(5, usuario.getBairro());
            sql.setString(6, usuario.getCidade());
            sql.setString(7, usuario.getCep());
            sql.setString(8, usuario.getUf());
            sql.setString(9, usuario.getReferencia());
            sql.setString(10, usuario.getTelefone());
            sql.setString(11, usuario.getCelular());
            sql.setString(12, usuario.getNum_cartao());
            sql.setString(13, usuario.getBandeira());
            sql.setInt(14, usuario.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Usuario usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM USUARIO WHERE ID = ? ");
            sql.setInt(1, usuario.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }


}
