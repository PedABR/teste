package lp2;

import java.util.HashMap;

public class Facade {

    private HashMap<String, Cliente> clientes;
    private HashMap<String, Fornecedor> fornecedores;

    public String cadastraCliente(String cpf, String nome, String localização, String email) {
        Cliente cliente = new Cliente(cpf, nome, localização, email);
        if (clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("esse cliente já foi cadastrado");
        }else {
            clientes.put(cpf, cliente);
            return cpf;
        }
    }

    public String exibeCliente(String cpf) {
        return clientes.get(cpf).toString();
    }

    public String listaClientes() {
        String retorno = "";
        for (Cliente cliente : clientes.values()) {
            retorno += cliente.toString() + "|";
        }
        return retorno;
    }

    public void editarCliente(String cpf, String nome, String localização, String email) {
        clientes.get(cpf).setEmail(email);
        clientes.get(cpf).setNome(nome);
        clientes.get(cpf).setLocalização(localização);
    }

    public void removerCliente(String cpf) {
        clientes.remove(cpf);
    }

    public String cadastraFornecedor(String nome, String telefone, String email) {
        Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
        if (fornecedores.containsKey(nome)) {
            throw new IllegalArgumentException("esse fornecedor já foi cadastrado");
        }else {
            fornecedores.put(nome, fornecedor);
            return nome;
        }
    }

    public String exibeFornecedor(String nome) {
        return fornecedores.get(nome).toString();
    }

    public String listaFornecedores() {
        String retorno = "";
        for (Fornecedor fornecedor : fornecedores.values()) {
            retorno += fornecedor.toString() + "|";
        }
        return retorno;
    }

    public void editaForncecedor(String nome, String email, String telefone) {
        fornecedores.get(nome).setEmail(email);
        fornecedores.get(nome).setTelefone(telefone);
    }

    public void removeFornecedor(String nome) {
        fornecedores.remove(nome);
    }
}
