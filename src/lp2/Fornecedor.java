package lp2;

import java.util.HashMap;
import java.util.HashSet;

public class Fornecedor {

    private String nome;
    private String email;
    private String telefone;
    private HashMap<String, Produto> produtos;

    public Fornecedor (String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
}
