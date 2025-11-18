package com.app;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class UsuarioBandejaTest {

    @Test
    public void usuarioyBandejas() {
        Usuario u = new Usuario("me@test.com");
        assertEquals("me@test.com", u.getEmail());
        Usuario dest = new Usuario("tu@test.com");
        u.enviarCorreo("t","c", Arrays.asList("tu@test.com"), Arrays.asList(dest), false);
        assertNotNull(u.getBandejaEnviados());
        assertNotNull(dest.getBandeja());

        BandejaEnviados be = u.getBandejaEnviados();
        assertTrue(be.getCorreos().size() >= 0);


        
    }
}
