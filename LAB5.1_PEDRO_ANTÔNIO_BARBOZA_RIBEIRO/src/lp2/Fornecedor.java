package lp2;

import java.util.HashMap;

/*
 * Classe que representa um fornecedor de produtos registrado no SAGA.
 * Todo forncedor possui nome, email, telefone e um Hashmap de produtos.
 */
public class Fornecedor {

    //Nome do fornecdor.
    private String nome;
    //Email do fornecedor.
    private String email;
    //Telefone do fornecedor.
    private String telefone;
    //Hashmap de produtos cuja chave é composta do nome e da descriçao do produto
    private HashMap<ProdutoID, Produto> produtos;

    /*
     * Constrói um novo fornecedor a partir do se nome, email e telefone.
     * @param nome Nome do fornecedor.
     * @param email Email do fornecedor.
     * @param telefone Telefone do fornecedor.
     */
    public Fornecedor (String nome, String email, String telefone) {
        if (nome.trim().isEmpty() || telefone.trim().isEmpty() || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Os atributos não podem ser vazios");
        }
        if (nome.equals(null) || email.equals(null) || telefone.equals(null)) {
            throw new IllegalArgumentException("Os atributos não podem ser vazios");
        }
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        produtos = new HashMap<>();
    }

    /*
     * Retorna uma representação em String de um fornecedor.
     * A representação tem o formato: nome - email - telefone.
     * @return Representação em String do fornecedor.
     */
    @Override
    public String toString() {
        return nome + " - " + email + " - " + telefone;
    }

    /*
     * Retorna uma representação em String de todos os produtos desse fornecedor.
     * A representação tem o formato: nome do fornecedor - produto |
     * @return Lista dos produtos desse fornecedor.
     */
    public String toStringProdutos() {
        String saida = "";
        int count = 0;
        for(Produto produto : produtos.values()) {
            if (count == 0) {
                saida += nome + " - " + produto.toString();
                count++;
            }else {
                saida += " | " + nome + " - " + produto.toString();
            }
        }
        return saida;
    }

    /*
     * Define um novo email para um fornecedor.
     * @param email Novo email do fornecedor.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * Define um novo telefone para um fornecedor.
     * @param email Novo telefone do fornecedor.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /*
     * Constrói e adiciona um produto novo a esse fornecedor(não adiciona um produto já atrelado a esse fornecedor).
     * O produto é adicionado ao HashMap de produtos com uma chave composta de seu nome e descriçao.
     * @param nome Nome do produto.
     * @param descriçao Descrição do produto.
     * @param preço Preço do produto.
     */
    public void adicionaProduto(String nome, String descriçao, double preço) {
        ProdutoID chave = new ProdutoID(nome, descriçao);
        if (produtos.containsKey(chave)) {
            throw new IllegalArgumentException("Esse produto já está cadastrado.");
        }
        Produto produto = new Produto(nome, descriçao, preço);
        produtos.put(chave, produto);
    }

    /*
     * Remove um produto desse fornecedor a partir do seu nome e descrição.
     * @param nome Nome do produto a ser removido.
     * @param descriçao Descrição do produto a ser removido.
     */
    public void removeProduto(String nome, String descriçao) {
        ProdutoID chave = new ProdutoID(nome, descriçao);
        if (!produtos.containsKey(chave)) {
            throw new IllegalArgumentException("Esse produto não está cadastrado.");
        }
        produtos.remove(chave);
    }

    /*
     * Retorna uma representação em String de um produto especificado pelo seu nome e descrição.
     * @param nome Nome do produto.
     * @param descriçao Descrição do produto.
     * @return Representação em String do produto.
     */
    public String exibeProduto(String nome, String descriçao) {
        ProdutoID chave = new ProdutoID(nome, descriçao);
        if (!produtos.containsKey(chave)) {
            throw new IllegalArgumentException("Esse produto não está cadastrado.");
        }
        return produtos.get(chave).toString();
    }

    /*
     * Define um novo preço para um produto desse fornecedor.
     * @param nome Nome do produto.
     * @param descriçao Descrição do produto.
     * @param preço Novo preço do produto.
     */
    public void editaProduto(String nome, String descriçao, double preço) {
        ProdutoID  chave = new ProdutoID(nome, descriçao);
        if (!produtos.containsKey(chave)) {
            throw new IllegalArgumentException("Esse fornecedor não está cadastrado.");
        }
        produtos.get(chave).setPreço(preço);
    }
}
