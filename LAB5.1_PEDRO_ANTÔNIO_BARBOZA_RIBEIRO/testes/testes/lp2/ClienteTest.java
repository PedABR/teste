package lp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testToString() {
        Cliente cliente = new Cliente("123", "fulano", "lsd", "fulano@email.com");
        assertEquals(cliente.toString(), "fulano - lsd - fulano@email.com");
    }

    @Test
    void setEmailPadrao() {
        Cliente cliente = new Cliente("123", "fulano", "lsd", "fulano@email.com");
        Cliente cliente1 = new Cliente("123", "fulano", "lsd", "fulano@gmail.com");
        cliente.setEmail("fulano@gmail.com");
        assertEquals(cliente.toString(), cliente1.toString());
    }

    @Test
    void setLocalização() {
        Cliente cliente = new Cliente("123", "fulano", "lsd", "fulano@email.com");
        Cliente cliente1 = new Cliente("123", "fulano", "lcc", "fulano@email.com");
        cliente.setLocalização("lcc");
        assertEquals(cliente.toString(), cliente1.toString());
    }

    @Test
    void setNome() {
        Cliente cliente = new Cliente("123", "fulano", "lsd", "fulano@email.com");
        Cliente cliente1 = new Cliente("123", "cicrano", "lsd", "fulano@email.com");
        cliente.setNome("cicrano");
        assertEquals(cliente.toString(), cliente1.toString());
    }
}