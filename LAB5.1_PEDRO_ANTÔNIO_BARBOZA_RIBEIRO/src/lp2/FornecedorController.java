package lp2;

import java.util.HashMap;

/*
 * Controller de Fornecedores.
 * Todo controller de fornecedores possui um HashMap de fornecedores cujas chaves são seus nomes.
 */
public class FornecedorController {

    // HashMap de fornecedores.
    private HashMap<String, Fornecedor> fornecedores;

    // Constrói um controller de fornecedores sem parâmetros.
    public FornecedorController() {
        fornecedores = new HashMap<>();
    }

    /*
     * Constrói e cadastra um novo fornecedor no controller a partir de seu nome, telefone e email.
     * @param nome Nome do fornecedor.
     * @param telefone Telefone do fornecedor.
     * @param email Email do fornecedor.
     */
    public String cadastraFornecedor(String nome, String telefone, String email) {
        Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
        if (fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("Esse fornecedor já foi cadastrado");
        }else {
            fornecedores.put(nome, fornecedor);
            return nome;
        }
    }

    /*
     * Retorna uma representação em String de um fornecedor especificado pelo seu nome.
     * @param nome Nome do fornecedor.
     */
    public String exibeFornecedor(String nome) {
        if (!fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("Esse fornecedor não existe.");
        }
        return fornecedores.get(nome).toString();
    }

    /*
     * Define um novo email e telefone a um fornecedor especificado pelo seu nome.
     * @param nome Nome do fornecedor.
     * @param telefone Novo telefone do fornecedor.
     * @param email Novo Email do fornecedor.
     */
    public void editaForncecedor(String nome, String email, String telefone) {
        if (!fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("Esse fornecedor não existe.");
        }
        if (telefone.trim().isEmpty() || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Os atributos não podem ser vazios");
        }
        if (email.equals(null) || telefone.equals(null)) {
            throw new IllegalArgumentException("Os atributos não podem ser vazios");
        }
        fornecedores.get(nome).setEmail(email);
        fornecedores.get(nome).setTelefone(telefone);
    }

    /*
     * Retorna uma representação em String de todos os fornecedores.
     * @return Representação em String dos fornecedores separadas por "|".
     */
    public String listaFornecedores() {
        String retorno = "";
        int count = 0;
        for (Fornecedor fornecedor : fornecedores.values()) {
            if (count == 0) {
                retorno += fornecedor.toString();
                count++;
            }else {
                retorno += " | " + fornecedor.toString();
            }
        }
        return retorno;
    }

    /*
     * Remove um fornecedor especificado pelo seu nome.
     * @param Nome do fornecedor a ser removido.
     */
    public void removeFornecedor(String nome) {
        if (!fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("Esse fornecedor não existe.");
        }
        fornecedores.remove(nome);
    }

    /*
     * Constrói e adiciona um produto a partir do seu nome, descriçao e preço a um fornecedor especificado pelo seu nome.
     * @param nome Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @param descriçao Descrição do produto.
     * @param preço Preço do produto.
     */
    public void adicionaProduto(String nome, String nomeProduto, String descriçao, double preço) {
        if (!fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("Esse fornecedor não existe.");
        }
        fornecedores.get(nome).adicionaProduto(nomeProduto, descriçao, preço);
    }

    /*
     * Retorna uma representação de todos os produtos de um forncedor especificado pelo seu nome.
     * @param Nome do fornecedor.
     * @return Representação em String de todos os produtos do fornecedor especificado.
     */
    public String listaProdutos(String nome) {
        if (!fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("Esse fornecedor não existe.");
        }
        return fornecedores.get(nome).toStringProdutos();
    }

    /*
     * Retorna uma representação em String de um produto especificado pelo seu nome e descrição de um fornecedor especificado pelo seu nome.
     * @param nome Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @param descriçao Descrição do produto.
     * @return Representação em String do produto.
     */
    public String exibeProduto(String nome, String nomeProduto, String descriçao) {
        if (!fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("Esse fornecedor não existe.");
        }
        return fornecedores.get(nome).exibeProduto(nomeProduto, descriçao);
    }
    /*
     * Remove um produto especificado pelo seu nome e descrição de um fornecedor espeificado pelo seu nome.
     * @param nome Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @descriçao descriçao Descriçao do produto.
     */
    public void removeProduto(String nome, String nomeProduto, String descriçao) {
        if (!fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("Esse fornecedor não existe.");
        }
            fornecedores.get(nome).removeProduto(nomeProduto, descriçao);
    }

    /*
     * Define um novo preço a um produto especificado pelo seu nome e descrição de um fornecedor.
     * @param nome Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @param descriçao Descriçao do produto.
     * @param preço Novo preço do produto.
     */
    public void editaProduto(String nome, String nomeProduto, String descriçao, double preço) {
        if (!fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("Esse fornecedor não existe.");
        }
        fornecedores.get(nome).editaProduto(nomeProduto, descriçao, preço);
    }

    /*
     * Retorna uma representação em String de uma lista de todos os fornecedores e seus respectivod produtos.
     * @return Lista de todos os fornecedores e seus produtos.
     */
    public String listaFonecedoresProdutos() {
        String saida = "";
        int count = 0;
        for (Fornecedor fornecedor : fornecedores.values()) {
            if (count == 0) {
                saida += fornecedor.toStringProdutos();
                count++;
            } else {
                saida += " | " + fornecedor.toStringProdutos();
            }
        }
        return saida;
    }
}
