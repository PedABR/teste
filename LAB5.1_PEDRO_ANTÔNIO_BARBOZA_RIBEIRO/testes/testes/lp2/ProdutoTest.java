package lp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void testSetPreçoPadrao() {
        Produto produto = new Produto("coisa", "é uma coisa", 1.5);
        Produto produto1 = new Produto("coisa", "é uma coisa", 0.5);
        produto1.setPreço(1.5);
        assertEquals(produto.toString(), produto1.toString());
    }

    @Test
    void testToString() {
        Produto produto = new Produto("coisa", "é uma coisa", 1.5);
        assertEquals(produto.toString(), "coisa - é uma coisa - 1.5");
    }
}