package lp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorControllerTest {

    @Test
    void testCadastraFornecedorExistente() {
        FornecedorController fornecedorController = new FornecedorController();
        fornecedorController.cadastraFornecedor("cantina", "99999-9999", "cantina@email.com");
        assertThrows(IllegalArgumentException.class, () -> {fornecedorController.cadastraFornecedor("cantina", "9999-9999", "cantina@gmail.com");});
    }

    @Test
    void testCadastraFornecedorParametroVazio() {
        FornecedorController fornecedorController = new FornecedorController();
        assertThrows(IllegalArgumentException.class, () -> {fornecedorController.cadastraFornecedor("", "9999-9999", "cantina@gmail.com");});
    }

    @Test
    void testExibeFornecedor() {
        FornecedorController fornecedorController = new FornecedorController();
        fornecedorController.cadastraFornecedor("cantina", "99999-9999", "cantina@email.com");
        assertEquals(fornecedorController.exibeFornecedor("cantina"), "cantina - cantina@email.com - 99999-9999");
    }

    @Test
    void testExibeFornecedorInexistete() {
        FornecedorController fornecedorController = new FornecedorController();
        assertThrows(IllegalArgumentException.class, () -> {fornecedorController.exibeFornecedor("cantina");});
    }

    @Test
    void testEditaForncecedor() {
        FornecedorController fornecedorController = new FornecedorController();
        FornecedorController fornecedorController1 = new FornecedorController();
        fornecedorController.cadastraFornecedor("cantina", "99999-9999", "cantina@email.com");
        fornecedorController1.cadastraFornecedor("cantina", "99999-9999", "cantina@email.com");
        fornecedorController.editaForncecedor("cantina", "cantina@hotmail.com", "(83) 99999-9999");
        assertNotEquals(fornecedorController.exibeFornecedor("cantina"), fornecedorController1.exibeFornecedor("cantina"));
    }

    @Test
    void testEditaForncecedorInexistente() {
        FornecedorController fornecedorController = new FornecedorController();
        assertThrows(IllegalArgumentException.class, () -> {fornecedorController.exibeFornecedor("cantina");});
    }

    @Test
    void testListaFornecedores() {
        FornecedorController fornecedorController = new FornecedorController();
        fornecedorController.cadastraFornecedor("cantina", "99999-9999", "cantina@email.com");
        fornecedorController.cadastraFornecedor("lanchonete", "99898-9898", "lanchonete@email.com");
        assertEquals(fornecedorController.listaFornecedores(), "lanchonete - lanchonete@email.com - 99898-9898 | cantina - cantina@email.com - 99999-9999");
    }

    @Test
    void testRemoveFornecedor() {
        FornecedorController fornecedorController = new FornecedorController();
        FornecedorController fornecedorController1 = new FornecedorController();
        fornecedorController.cadastraFornecedor("cantina", "99999-9999", "cantina@email.com");
        fornecedorController.removeFornecedor("cantina");
        assertEquals(fornecedorController.listaFornecedores(), fornecedorController1.listaFornecedores());
    }

    @Test
    void testRemoveFornecedorInexistente() {
        FornecedorController fornecedorController = new FornecedorController();
        assertThrows(IllegalArgumentException.class, () -> {fornecedorController.removeFornecedor("cantina");});
    }

    @Test
    void testAdicionaProduto() {
        FornecedorController fornecedorController = new FornecedorController();
        fornecedorController.cadastraFornecedor("cantina", "99999-9999", "cantina@email.com");
        fornecedorController.cadastraFornecedor("lanchonete", "99898-9898", "lanchonete@email.com");
        fornecedorController.adicionaProduto("cantina", "café", "café pequeno", 0.50);
        assertNotEquals(fornecedorController.listaProdutos("cantina"), fornecedorController.listaProdutos("lanchonete"));
    }

    @Test
    void testAdicionaProdutoParâmetroVazio() {
        FornecedorController fornecedorController = new FornecedorController();
        assertThrows(IllegalArgumentException.class, () -> {fornecedorController.adicionaProduto("cantina", "", "café pequeno", 0.50);});
    }

    @Test
    void testListaProdutos() {
        FornecedorController fornecedorController = new FornecedorController();
        fornecedorController.cadastraFornecedor("cantina", "99999-9999", "cantina@email.com");
        fornecedorController.adicionaProduto("cantina", "sanduiche", "sanduiche de presunto", 3.00);
        fornecedorController.adicionaProduto("cantina", "suco", "suco de maça", 2.00);
        assertEquals(fornecedorController.listaProdutos("cantina"), "cantina - sanduiche - sanduiche de presunto - 3.0 | cantina - suco - suco de maça - 2.0");
    }

    @Test
    void testExibeProdutoInexistente() {
        FornecedorController fornecedorController = new FornecedorController();
        fornecedorController.cadastraFornecedor("cantina", "99999-9999", "cantina@email.com");
        assertThrows(IllegalArgumentException.class, () -> {fornecedorController.exibeProduto("cantina", "sanduíche", "sanduíche de presunto");});
    }

    @Test
    void testEditarProdutoInexistente() {
        FornecedorController fornecedorController = new FornecedorController();
        fornecedorController.cadastraFornecedor("cantina", "99999-9999", "cantina@email.com");
        assertThrows(IllegalArgumentException.class, () -> {fornecedorController.editaProduto("cantina", "sanduíche", "sanduíche de presunto", 1.5);});
    }

    @Test
    void teatListaFonecedoresProdutos() {
        FornecedorController fornecedorController = new FornecedorController();
        fornecedorController.cadastraFornecedor("cantina", "99999-9999", "cantina@email.com");
        fornecedorController.cadastraFornecedor("lanchonete", "99898-9898", "lanchonete@email.com");
        fornecedorController.adicionaProduto("cantina", "sanduíche", "sanduíche de presunto", 3.00);
        fornecedorController.adicionaProduto("lanchonete", "sanduíche", "sanduíche de presunto", 3.00);
        fornecedorController.adicionaProduto("cantina", "suco", "suco de maça", 2.00);
        fornecedorController.adicionaProduto("lanchonete", "suco", "suco de maça", 2.00);
        assertEquals(fornecedorController.listaFonecedoresProdutos(), "lanchonete - suco - suco de maça - 2.0 | lanchonete - sanduíche - sanduíche de presunto - 3.0 | cantina - sanduíche - sanduíche de presunto - 3.0 | cantina - suco - suco de maça - 2.0");
    }
}