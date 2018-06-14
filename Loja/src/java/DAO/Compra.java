
package DAO;


public class Compra {
    private int id;
    private int id_produto;
    private int id_usuario;

    public Compra(int id, int id_produto, int id_usuario) {
        this.id = id;
        this.id_produto = id_produto;
        this.id_usuario = id_usuario;
    }

    public Compra(int id_produto, int id_usuario) {
        this.id_produto = id_produto;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
