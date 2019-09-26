package lp2;

public class Cliente {

    private String cpf;
    private String nome;
    private String localização;
    private String email;

    public Cliente (String cpf, String nome, String localização, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.localização = localização;
        this.email = email;
    }

    @Override
    public String toString() {
        return nome + " - " + localização + " - " + email;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Object other = (Cliente) obj;
        if (this.cpf.equals(((Cliente) other).getCpf())) {
            return true;
        }else {
            return false;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocalização(String localização) {
        this.localização = localização;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
}
