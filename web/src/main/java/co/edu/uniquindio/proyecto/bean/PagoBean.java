package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.MetodoPago;
import co.edu.uniquindio.proyecto.entidades.Pago;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Propietario;
import co.edu.uniquindio.proyecto.servicio.IPagoServicio;
import co.edu.uniquindio.proyecto.servicio.IPlanServicio;
import co.edu.uniquindio.proyecto.servicio.IPropietarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@ViewScoped
public class PagoBean implements Serializable {
    @Getter @Setter
    private Pago pago;

    @Getter @Setter
    private LocalDate fechaPago;

    @Getter @Setter
    private List<MetodoPago> metodosPago;

    @Getter @Setter
    private List<Propietario> propietarios;

    @Getter @Setter
    private List<Plan> planes;

    @Autowired
    private IPagoServicio pagoServicio;

    @Autowired
    private IPropietarioServicio propietarioServicio;

    @Autowired
    private IPlanServicio planServicio;

    @PostConstruct
    public void inicializar() {
        pago = new Pago();
        fechaPago = LocalDate.now();
        metodosPago = pagoServicio.listarMetodosPago();
        propietarios = propietarioServicio.listarPropietarios();
        planes = planServicio.listarPlanes();
    }

    public void registrarPago() {
        Double costo = calcularCosto();
    }

    private Double calcularCosto() {
        if(pago.getPropietario() != null && pago.getPlan() != null) {
            return planServicio.calcularCosto(pago.getPlan().getCodigo());
        }

        return 0.0;
    }

    public String fechaFormateada() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd MMM, yyyy");

        return formato.format(fechaPago);
    }
}
