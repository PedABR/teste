package lp2;

/*
 * Classe que representa um cliente registrado no SAGA.
 * Todo cliente possui um cpf, nome, localização e email.
 */
public class Cliente {

    //CPF do cliente.
    private String cpf;
    //Nome do cliente.
    private String nome;
    //Local onde o cliente estuda/trabalha.
    private String localização;
    //Email do cliente.
    private String email;

    /*
     * Constrói um novo cliente a partir do seu cpf, nome, localização e email.
     * @param cpf CPF do cliente.
     * @param nome Nome do cliente.
     * @param localização Local onde o cliente estuda/trabalha.
     * @param email Email do cliente.
     */
    public Cliente (String cpf, String nome, String localização, String email) {
        if (nome.trim().isEmpty() || cpf.trim().isEmpty() || localização.trim().isEmpty() || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Os atributos não podem ser vazios");
        }
        if (nome.equals(null) || cpf.equals(null) || localização.equals(null) || email.equals(null)) {
            throw new IllegalArgumentException("Os atributos não podem ser vazios");
        }
        this.cpf = cpf;
        this.nome = nome;
        this.localização = localização;
        this.email = email;
    }

    /*
     * Retorna uma representação em String de um cliente.
     * A representação tem o formato: nome - localizaçao - email.
     * @return Representação em String do cliente.
     */
    @Override
    public String toString() {
        return nome + " - " + localização + " - " + email;
    }

    /*
     * Define um novo email para um cliente.
     * @param email Novo email do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * Define uma nova localização para um cliente.
     * @param localização Nova localização do cliente.
     */
    public void setLocalização(String localização) {
        this.localização = localização;
    }

    /*
     * Define um novo nome para um cliente.
     * @param nome Novo nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
