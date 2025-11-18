package Test;

import main.Correo;
import main.BandejaRecibidos;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class BusquedaCorreoTest {

    @Test
    public void testBuscarPorAsunto() {
        BandejaRecibidos bandeja = new BandejaRecibidos();
        Correo c1 = new Correo("Pago", "Factura", "Lautaro", "juan@gmail.com", false, "yo");
        Correo c2 = new Correo("Reunion", "Agenda", "Lautaro", "juan@gmail.com", true, "yo");

        bandeja.agregarCorreo(c1);
        bandeja.agregarCorreo(c2);

        List<Correo> resultado = bandeja.buscarPorAsunto("Pago");

        Assert.assertEquals(1, resultado.size());
        Assert.assertEquals("Pago", resultado.get(0).getAsunto());
    }

    @Test
    public void testBuscarPorRemitente() {
        BandejaRecibidos bandeja = new BandejaRecibidos();
        Correo c1 = new Correo("Pago", "Factura", "Lautaro Lopez Lecube", "yo@gmail.com", false, "yo");
        Correo c2 = new Correo("Reunion", "Agenda", "Pedro Gonzalez", "yo@gmail.com", true, "yo");

        bandeja.agregarCorreo(c1);
        bandeja.agregarCorreo(c2);

        List<Correo> resultado = bandeja.buscarPorRemitente("Lautaro");

        Assert.assertEquals(1, resultado.size());
        Assert.assertEquals("Lautaro Lopez Lecube", resultado.get(0).getRemitente());
    }

    @Test
    public void testBuscarPorContenido() {
        BandejaRecibidos bandeja = new BandejaRecibidos();
        Correo c1 = new Correo("Pago", "Factura de luz", "Lautaro", "yo@gmail.com", false, "yo");
        Correo c2 = new Correo("Recordatorio", "Agenda del curso", "Lautaro", "yo@gmail.com", true, "yo");

        bandeja.agregarCorreo(c1);
        bandeja.agregarCorreo(c2);

        List<Correo> resultado = bandeja.buscarPorContenido("agenda");

        Assert.assertEquals(1, resultado.size());
        Assert.assertEquals("Recordatorio", resultado.get(0).getAsunto());
    }

    @Test
    public void testBuscarPorContacto() {
        BandejaRecibidos bandeja = new BandejaRecibidos();
        Correo c1 = new Correo("Pago", "Factura", "Lautaro", "marcos@gmail.com", false, "yo");
        Correo c2 = new Correo("Reunion", "Agenda", "Lautaro", "juan@gmail.com", true, "yo");

        bandeja.agregarCorreo(c1);
        bandeja.agregarCorreo(c2);

        List<Correo> resultado = bandeja.buscarPorContacto("juan");

        Assert.assertEquals(1, resultado.size());
        Assert.assertEquals("Reunion", resultado.get(0).getAsunto());
    }
}
