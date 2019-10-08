package lp2;

/*
 * Classe que representa um produto comercializado no SAGA.
 * Todo produto está sempre associado a um fornecedor.
 * Todo produto sempre possui nome preço e descriçao.
 */
public class Produto {

    // Nome do produto.
    private String nome;
    // Desrição do produto;
    private String descriçao;
    // Preço do produto.
    private double preço;

    /*
     * Constrói um novo produto a partir do seu nome, descrição e preço.
     * @param nome Nome do produto.
     * @param descriçao Descrição do produto.
     * @param preço Preço do produto.
     */
    public Produto(String nome, String descriçao, double preço) {
        if (nome.trim().isEmpty() || descriçao.trim().isEmpty()) {
            throw new IllegalArgumentException("Os atributos não podem ser vazios");
        }
        if (nome.equals(null) || descriçao.equals(null)) {
            throw new NullPointerException("Os atributos não podem ser nulos.");
        }
        this.nome = nome;
        this.preço = preço;
        this.descriçao = descriçao;
    }

    /*
     * Define um novo preço para o produto.
     * @param preço Novo preço associado ao produto.
     */
    public void setPreço(double preço) {
        this.preço = preço;
    }

    /*
     * Retorna uma representação em String de um Produto.
     * A representação tem o formato: nome - descriçao - preço.
     * @return Representação em String do produto.
     */
    @Override
    public String toString() {
        return nome + " - " + descriçao + " - " + preço;
    }
}
