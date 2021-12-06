package co.edu.uniquindio.proyecto.servicio;

import co.edu.uniquindio.proyecto.entidades.Plan;

import java.util.List;

//Requerimientos asociados a los planes.
public interface IPlanServicio {

    Plan crearPlan(Plan p) throws Exception;

    Plan actualizarPlan(Plan pNuevo) throws Exception;

    List<Plan> listarPlanes();

    Plan getPlan(Integer codigo) throws Exception;

    Double calcularCosto(Integer codigo) throw Exception;
}
