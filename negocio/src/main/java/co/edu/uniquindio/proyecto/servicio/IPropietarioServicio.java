package co.edu.uniquindio.proyecto.servicio;

import co.edu.uniquindio.proyecto.entidades.Propietario;
import org.springframework.stereotype.Service;

import java.util.List;

//Requerimientos asociados al cliente o propietario.
public interface IPropietarioServicio {

    Propietario registrarPropietario(Propietario p) throws Exception;

    Propietario actualizarPropietario(Propietario pNuevo) throws Exception;

    void eliminarPropietario(String cedula) throws Exception;

    List<Propietario> listarPropietarios();

    Propietario getPropietario(String cedula) throws Exception;
}
