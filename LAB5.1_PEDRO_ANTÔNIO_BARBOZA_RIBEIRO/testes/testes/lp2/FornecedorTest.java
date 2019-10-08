package lp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    @Test
    void testToString() {
        Fornecedor fornecedor = new Fornecedor("fornecedor", "fornecedor@email.com", "99999-9999");
        assertEquals(fornecedor.toString(), "fornecedor - fornecedor@email.com - 99999-9999");
    }

    @Test
    void testToStringProdutosPadrao() {
        Fornecedor fornecedor = new Fornecedor("fornecedor", "fornecedor@email.com", "99999-9999");
        fornecedor.adicionaProduto("coisa", "é uma coisa", 1.5);
        fornecedor.adicionaProduto("outra coisa", "é uma coisa", 1.0);
        assertEquals(fornecedor.toStringProdutos(), "fornecedor - outra coisa - é uma coisa - 1.0 | fornecedor - coisa - é uma coisa - 1.5");
    }

    @Test
    void testToStringProdutosVazia() {
        Fornecedor fornecedor = new Fornecedor("fornecedor", "fornecedor@email.com", "99999-9999");
        assertEquals(fornecedor.toStringProdutos(), "");
    }

    @Test
    void testSetEmail() {
        Fornecedor fornecedor = new Fornecedor("fornecedor", "fornecedor@email.com", "99999-9999");
        Fornecedor fornecedor1 = new Fornecedor("fornecedor", "fornecedor@gmail.com", "99999-9999");
        fornecedor.setEmail("fornecedor@gmail.com");
        assertEquals(fornecedor.toString(), fornecedor1.toString());
    }

    @Test
    void testSetTelefone() {
        Fornecedor fornecedor = new Fornecedor("fornecedor", "fornecedor@email.com", "99999-9999");
        Fornecedor fornecedor1 = new Fornecedor("fornecedor", "fornecedor@email.com", "(83) 99999-9999");
        fornecedor.setTelefone("(83) 99999-9999");
        assertEquals(fornecedor.toString(), fornecedor1.toString());
    }

    @Test
    void testAdicionaProdutoEntradaNula() {
        Fornecedor fornecedor = new Fornecedor("fornecedor", "fornecedor@email.com", "99999-9999");
        assertThrows(NullPointerException.class, () -> {fornecedor.adicionaProduto(null, "é uma coisa", 1.5);});
    }

    @Test
    void testRemoveProdutoInexistente() {
        Fornecedor fornecedor = new Fornecedor("fornecedor", "fornecedor@email.com", "99999-9999");
        Fornecedor fornecedor1 = new Fornecedor("fornecedor", "fornecedor@email.com", "99999-9999");
        assertThrows(IllegalArgumentException.class, () -> {fornecedor.removeProduto("coisa", "é uma coisa");});
    }

    @Test
    void testExibeProdutoInexistente() {
        Fornecedor fornecedor = new Fornecedor("fornecedor", "fornecedor@email.com", "99999-9999");
        assertThrows(IllegalArgumentException.class, () -> {fornecedor.exibeProduto("coisa", "é uma coisa");});
    }

    @Test
    void testEditaProdutoInexistente() {
        Fornecedor fornecedor = new Fornecedor("fornecedor", "fornecedor@email.com", "99999-9999");
        assertThrows(IllegalArgumentException.class, () -> {fornecedor.editaProduto("coisa", "é uma coisa", 1.5);});
    }
}