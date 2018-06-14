/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Notebook
 */
public class Produto {
    private int id;
    private int id_categoria;
    private String nome;
    private String descricao;
    private Float valor;

    public Produto(int id, int id_categoria, String nome, String descricao, Float valor) {
        this.id = id;
        this.id_categoria = id_categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Produto(int id) {
        this.id = id;
    }

    public Produto(int id_categoria, String nome, String descricao, Float valor) {
        this.id_categoria = id_categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
    
    
}
