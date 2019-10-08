package lp2;

import java.util.HashMap;

/* Controller de clientes.
 * Todo controller de clientes possui um HashMap de clientes cujas chaves são seus CPFs.
 */
public class ClienteController {

    //HashMap de clientes.
    private HashMap<String, Cliente> clientes;

    //Constrói um novo controler de clientes sem parâmetros.
    public ClienteController() {
        this.clientes = new HashMap<>();
    }

    /*
     * Constrói e cadastra um novo cliente no controller a partirdo cpf, nome, localização e email do cliente.
     * @param cpf CPF do cliente.
     * @param nome Nome do cliente.
     * @param localização Local de estudo/trabalho do cliente.
     * @param email Email do cliente.
     */
    public String cadastraCliente(String cpf, String nome, String localização, String email) {
        Cliente cliente = new Cliente(cpf, nome, localização, email);
        if (clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("esse cliente já foi cadastrado");
        }else {
            clientes.put(cpf, cliente);
            return cpf;
        }
    }

    /*
     * Retorna uma representação em String do cliente a partir do seu cpf.
     * @param cpf CPF do cliente.
     * @return Representação em String do cliente.
     */
    public String exibeCliente(String cpf) {
        if (!clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Esse cliente não existe!");
        }
        return clientes.get(cpf).toString();
    }

    /*
     * Retorna uma representação em String de todos os clientes cadastrados.
     * @return Representação em String de todos os clientes cadastrados.
     */
    public String listaClientes() {
        String retorno = "";
        int count = 0;
        for (Cliente cliente : clientes.values()) {
            if (count == 0) {
                retorno += cliente.toString();
                count++;
            }else {
                retorno += " | " + cliente.toString();
            }
        }
        return retorno;
    }

    /*
     * Define um novo email, nome e localização para o cliente.
     * @param cpf CPF do cliente.
     * @param nome Novo nome do cliente.
     * @param localizaçao Nova localização do cliente.
     * @param email Novo email do cliente.
     */
    public void editarCliente(String cpf, String nome, String localização, String email) {
        if (!clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Esse cliente não existe!");
        }
        if (nome.trim().isEmpty() || email.trim().isEmpty() || localização.trim().isEmpty()) {
            throw new IllegalArgumentException("Os atributos não podem ser vazios");
        }
        if (nome.equals(null) || nome.equals(null)) {
            throw new IllegalArgumentException("Os atributos não podem ser vazios");
        }
        clientes.get(cpf).setEmail(email);
        clientes.get(cpf).setNome(nome);
        clientes.get(cpf).setLocalização(localização);
    }

    /*
     * Remove um cliente a partir do seu CPF.
     * @param cpf CPF do cliente.
     */
    public void removerCliente(String cpf) {
        if (!clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Esse cliente não existe!");
        }
        clientes.remove(cpf);
    }
}
