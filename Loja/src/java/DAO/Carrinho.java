/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author Notebook
 */
public class Carrinho {
     private ArrayList<Produto> itens;

    public Carrinho() {
        this.itens = new ArrayList();
    }

    public ArrayList<Produto> getCarrinhoItens() {
        return this.itens;
    }

    public void setCarrinhoItens(Produto prod) {
        this.itens.add(prod);
    }

    public void removeCarrinhoItens(int id) {
        int i;
        for (i = 0; i < this.itens.size(); i++) {
            if(this.itens.get(i).getId() == id ){
                break;
            }
        }
        this.itens.remove(i);
    }
}
