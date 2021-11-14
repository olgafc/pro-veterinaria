package co.edu.uniquindio.proyecto.servicio;

import co.edu.uniquindio.proyecto.entidades.Propietario;
import co.edu.uniquindio.proyecto.repositorios.PropietarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServicioImpl implements IPropietarioServicio {
    /*private final PropietarioRepo propietarioRepo;

    public PropietarioServicioImpl(PropietarioRepo propietarioRepo) {
        this.propietarioRepo = propietarioRepo;
    }
    */

    @Override
    public Propietario registrarPropietario(Propietario p) throws Exception {
        return null;
    }

    @Override
    public Propietario actualizarPropietario(Propietario pNuevo) throws Exception {
        return null;
    }

    @Override
    public void eliminarPropietario(Integer idGenerado) throws Exception {

    }

    @Override
    public List<Propietario> listarPropietarios() {
        return null;
    }

    @Override
    public Propietario getPropietario(Integer idGenerado) throws Exception {
        return null;
    }
}
