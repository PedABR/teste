package lp2;

/*
 * Classe que composta os controllers e serve de base para o main.
 * Todo façade contem um controller de fornecedores e um controller de clientes.
 */
public class Facade {

    // Controller de fornecedores.
    FornecedorController fornecedores;
    // Controller de clientes.
    ClienteController clientes;

    // Constrói um Facade sem parâmetros.
    public Facade() {
        this.clientes = new ClienteController();
        this.fornecedores = new FornecedorController();
    }

    /*
     * Constrói e cadastra um novo cliente no controller a partirdo cpf, nome, localização e email do cliente.
     * @param cpf CPF do cliente.
     * @param nome Nome do cliente.
     * @param localização Local de estudo/trabalho do cliente.
     * @param email Email do cliente.
     */
    public String cadastraCliente(String cpf, String nome, String localizaçao, String email) {
        return clientes.cadastraCliente(cpf, nome, localizaçao, email);
    }

    /*
     * Retorna uma representação em String do cliente a partir do seu cpf.
     * @param cpf CPF do cliente.
     * @return Representação em String do cliente.
     */
    public String exibeCliente(String cpf) {
        return clientes.exibeCliente(cpf);
    }

    /*
     * Define um novo email, nome e localização para o cliente.
     * @param cpf CPF do cliente.
     * @param nome Novo nome do cliente.
     * @param localizaçao Nova localização do cliente.
     * @param email Novo email do cliente.
     */
    public void editaCliente(String cpf, String nome, String localizaçao, String email) {
        clientes.editarCliente(cpf, nome, localizaçao, email);
    }

    /*
     * Remove um cliente a partir do seu CPF.
     * @param cpf CPF do cliente.
     */
    public void removeCliente(String cpf) {
        clientes.removerCliente(cpf);
    }

    /*
     * Retorna uma representação em String de todos os clientes cadastrados.
     * @return Representação em String de todos os clientes cadastrados.
     */
    public String listaClientes() {
        return clientes.listaClientes();
    }

    /*
     * Constrói e cadastra um novo fornecedor no controller a partir de seu nome, telefone e email.
     * @param nome Nome do fornecedor.
     * @param telefone Telefone do fornecedor.
     * @param email Email do fornecedor.
     */
    public String cadastraFornecedor(String nome, String telefone, String email) {
        return fornecedores.cadastraFornecedor(nome, telefone, email);
    }

    /*
     * Retorna uma representação em String de um fornecedor especificado pelo seu nome.
     * @param nome Nome do fornecedor.
     */
    public String exibeFornecedor(String nome) {
        return fornecedores.exibeFornecedor(nome);
    }

    /*
     * Retorna uma representação em String de todos os fornecedores.
     * @return Representação em String dos fornecedores separadas por "|".
     */
    public String listaFornecedores() {
        return fornecedores.listaFornecedores();
    }

    /*
     * Define um novo email e telefone a um fornecedor especificado pelo seu nome.
     * @param nome Nome do fornecedor.
     * @param telefone Novo telefone do fornecedor.
     * @param email Novo Email do fornecedor.
     */
    public void editaFornecedor(String nome, String email, String telefone) {
        fornecedores.editaForncecedor(nome, email, telefone);
    }

    /*
     * Remove um fornecedor especificado pelo seu nome.
     * @param Nome do fornecedor a ser removido.
     */
    public void removeFornecedor(String nome) {
        fornecedores.removeFornecedor(nome);
    }

    /*
     * Constrói e adiciona um produto a partir do seu nome, descriçao e preço a um fornecedor especificado pelo seu nome.
     * @param nome Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @param descriçao Descrição do produto.
     * @param preço Preço do produto.
     */
    public void cadastraProduto(String nome, String nomeProduto, String descriçao, double preço) {
        fornecedores.adicionaProduto(nome, nomeProduto, descriçao, preço);
    }

    /*
     * Retorna uma representação de todos os produtos de um forncedor especificado pelo seu nome.
     * @param Nome do fornecedor.
     * @return Representação em String de todos os produtos do fornecedor especificado.
     */
    public String listaProdutos(String nome) {
        return fornecedores.listaProdutos(nome);
    }

    /*
     * Retorna uma representação em String de um produto especificado pelo seu nome e descrição de um fornecedor especificado pelo seu nome.
     * @param nome Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @param descriçao Descrição do produto.
     * @return Representação em String do produto.
     */
    public String exibeProduto(String nome, String nomeProduto,String descriçao) {
        return fornecedores.exibeProduto(nome, nomeProduto, descriçao);
    }
    /*
     * Define um novo preço a um produto especificado pelo seu nome e descrição de um fornecedor.
     * @param nome Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @param descriçao Descriçao do produto.
     * @param preço Novo preço do produto.
     */
    public void editaProduto(String nome, String nomeProduto, String descriçao, double preço) {
        fornecedores.editaProduto(nome, nomeProduto, descriçao, preço);
    }

    /*
     * Remove um produto especificado pelo seu nome e descrição de um fornecedor espeificado pelo seu nome.
     * @param nome Nome do fornecedor.
     * @param nomeProduto Nome do produto.
     * @descriçao descriçao Descriçao do produto.
     */
    public void removeProduto(String nome, String nomeProduto, String descriçao) {
        fornecedores.removeProduto(nome, nomeProduto, descriçao);
    }

    /*
     * Retorna uma representação em String de uma lista de todos os fornecedores e seus respectivod produtos.
     * @return Lista de todos os fornecedores e seus produtos.
     */
    public String listaForncedoresEProdutos() {
        return fornecedores.listaFonecedoresProdutos();
    }
}
