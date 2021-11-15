package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.MetodoPago;
import co.edu.uniquindio.proyecto.entidades.Planes;
import co.edu.uniquindio.proyecto.entidades.MetodoPago.*;
import co.edu.uniquindio.proyecto.entidades.Propietario;
import co.edu.uniquindio.proyecto.servicio.IPlanServicio;
import co.edu.uniquindio.proyecto.servicio.IPropietarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static co.edu.uniquindio.proyecto.entidades.MetodoPago.DEBITO;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class PlanServicioTest {
    @Autowired
    private IPlanServicio planServicio;

    @Test
    public void crearTest() {
        Planes p = new Planes(123, "Hogar", DEBITO);
        try {
            Planes respuesta = planServicio.crearPlan(p);

            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listar() {
        List<Planes> lista = planServicio.listarPlanes();
        lista.forEach(System.out::println);
    }

    @Test
    public void actualizar() {
        try {
            Planes p = new Planes(123, "Hogar", DEBITO);
            planServicio.crearPlan(p);

            Planes buscado = planServicio.getPlan(123);
            buscado.setNombre("Descuento");
            planServicio.actualizarPlan(buscado);

            Planes pActualizado = planServicio.getPlan(123);;
            Assertions.assertEquals("Descuento", pActualizado.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
