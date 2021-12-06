package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.MetodoPago;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.servicio.IPlanServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class PlanServicioTest {
    @Autowired
    private IPlanServicio planServicio;

    @Test
    public void crearTest() {
        Plan p = new Plan(123, "Hogar", MetodoPago.CUENTA_CORRIENTE);
        try {
            Plan respuesta = planServicio.crearPlan(p);

            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listar() {
        List<Plan> lista = planServicio.listarPlanes();
        lista.forEach(System.out::println);
    }

    @Test
    public void actualizar() {
        try {
            Plan p = new Plan(123, "Hogar", MetodoPago.TARJETA_DEBITO);
            planServicio.crearPlan(p);

            Plan buscado = planServicio.getPlan(123);
            buscado.setNombre("Descuento");
            planServicio.actualizarPlan(buscado);

            Plan pActualizado = planServicio.getPlan(123);;
            Assertions.assertEquals("Descuento", pActualizado.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
