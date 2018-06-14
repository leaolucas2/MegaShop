package DAO;

public class Usuario {
    private int id; 
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private String referencia;
    private String telefone;
    private String celular;
    private String num_cartao;
    private String bandeira ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(String num_cartao) {
        this.num_cartao = num_cartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(int id, String nome, String cpf, String rg, String endereco, String bairro, String cidade, String cep, String uf, String referencia, String telefone, String celular, String num_cartao, String bandeira) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.referencia = referencia;
        this.telefone = telefone;
        this.celular = celular;
        this.num_cartao = num_cartao;
        this.bandeira = bandeira;
    }

    public Usuario(String nome, String cpf, String rg) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Usuario(int id, String nome, String cpf, String rg) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Usuario(String nome, String cpf, String rg, String endereco, String bairro, String cidade, String cep, String uf, String referencia, String telefone, String celular, String num_cartao, String bandeira) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.referencia = referencia;
        this.telefone = telefone;
        this.celular = celular;
        this.num_cartao = num_cartao;
        this.bandeira = bandeira;
    }
    

}
