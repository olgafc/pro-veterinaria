package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Propietario;
import co.edu.uniquindio.proyecto.servicio.IPropietarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class PropietarioServicioTest {
    @Autowired
    private IPropietarioServicio propietarioServicio;

    @Test
    public void RegistrarTest() {
        Propietario p = new Propietario("123", "Stiven", "", "stiven@email.com");
        try {
            Propietario respuesta = propietarioServicio.registrarPropietario(p);

            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void eliminar() {
        try {
            Propietario p = new Propietario("123", "Stiven", "", "stiven@email.com");
            propietarioServicio.registrarPropietario(p);

            propietarioServicio.eliminarPropietario("123");
            Assertions.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void listar() {
        List<Propietario> lista = propietarioServicio.listarPropietarios();
        lista.forEach(System.out::println);
    }

    @Test
    public void actualizar() {
        Propietario p = new Propietario("123", "Steven", "", "stiven@email.com");

        try {
            Propietario buscado = propietarioServicio.getPropietario("123");
            buscado.setNombre("Stiven");

            Propietario pActualizado = propietarioServicio.getPropietario("123");;
            Assertions.assertEquals("Stiven", pActualizado.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
