package co.edu.uniquindio.proyecto.servicio;

import co.edu.uniquindio.proyecto.entidades.Planes;
import co.edu.uniquindio.proyecto.entidades.Propietario;

import java.util.List;

//Requerimientos asociados a los planes.
public interface IPlanServicio {

    Planes crearPlan(Planes p) throws Exception;

    Planes actualizarPlan(Planes pNuevo) throws Exception;

    List<Planes> listarPlanes();

    Planes getPlan(Integer codigo) throws Exception;
}
