package lp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteControllerTest {

    @Test
    void testCadastraCliente() {
        ClienteController clienteController = new ClienteController();
        ClienteController clienteController1 = new ClienteController();
        clienteController.cadastraCliente("123", "fulano", "lcc", "fulano@email.com");
        assertNotEquals(clienteController, clienteController1);
    }

    @Test
    void testCadastraClienteJaCadastrado() {
        ClienteController clienteController = new ClienteController();
        clienteController.cadastraCliente("123", "fulano", "lcc", "fulano@email.com");
        assertThrows(IllegalArgumentException.class, () -> {clienteController.cadastraCliente("123", "fulano", "lcc", "fulano@email.com");});
    }

    @Test
    void testExibeClientePadrao() {
        ClienteController clienteController = new ClienteController();
        clienteController.cadastraCliente("123", "fulano", "lcc", "fulano@email.com");
        assertEquals(clienteController.exibeCliente("123"), "fulano - lcc - fulano@email.com");
    }

    @Test
    void testExibeClienteInexistente() {
        ClienteController clienteController = new ClienteController();
        assertThrows(IllegalArgumentException.class, () -> {clienteController.exibeCliente("123");});
    }

    @Test
    void testListaClientes() {
        ClienteController clienteController = new ClienteController();
        clienteController.cadastraCliente("123", "fulano", "lcc", "fulano@email.com");
        clienteController.cadastraCliente("111", "cicrano", "lsd", "cicrano@email.com");
        assertEquals(clienteController.listaClientes(), "cicrano - lsd - cicrano@email.com | fulano - lcc - fulano@email.com");
    }

    @Test
    void testEditarClientePadrao() {
        ClienteController clienteController = new ClienteController();
        clienteController.cadastraCliente("123", "fulano", "lcc", "fulano@email.com");
        ClienteController clienteController1 = new ClienteController();
        clienteController1.cadastraCliente("123", "fulano", "lcc", "fulano@email.com");
        clienteController.editarCliente("123", "cicrano", "lsd", "cicrano@gmail.com");
        assertNotEquals(clienteController.exibeCliente("123"), clienteController1.exibeCliente("123"));
    }

    @Test
    void testEditarClienteInexistente() {
        ClienteController clienteController = new ClienteController();
        assertThrows(IllegalArgumentException.class, () -> {clienteController.editarCliente("123", "fulano", "lsd", "fulano@email.com");});
    }

    @Test
    void testRemoverCliente() {
        ClienteController clienteController = new ClienteController();
        clienteController.cadastraCliente("123", "fulano", "lcc", "fulano@email.com");
        ClienteController clienteController1 = new ClienteController();
        clienteController1.cadastraCliente("123", "fulano", "lcc", "fulano@email.com");
        clienteController.removerCliente("123");
        assertNotEquals(clienteController.listaClientes(), clienteController1.listaClientes());
    }

    @Test
    void testRemoverClienteInexistente() {
        ClienteController clienteController = new ClienteController();
        assertThrows(IllegalArgumentException.class, () -> {clienteController.removerCliente("123");});
    }
}