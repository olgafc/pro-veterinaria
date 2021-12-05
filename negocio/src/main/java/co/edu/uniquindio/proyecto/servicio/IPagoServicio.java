package co.edu.uniquindio.proyecto.servicio;

import co.edu.uniquindio.proyecto.entidades.Pago;
import java.util.List;

public interface IPagoServicio {
    Pago registrarPago(Pago p) throws Exception;

    Pago actualizarPago(Pago p) throws Exception;

    void eliminarPago(Integer codigo) throws Exception;

    List<Pago> pagosPorPlan(Integer codigoPlan) throws Exception;

    List<Pago> pagosPorPropietario(String cedulaPropietario) throws Exception;

    List<Pago> listarPagos();

    Pago getPago(Integer codigo) throws Exception;
}
