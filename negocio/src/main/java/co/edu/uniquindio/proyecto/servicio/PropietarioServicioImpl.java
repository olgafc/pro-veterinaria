package co.edu.uniquindio.proyecto.servicio;

import co.edu.uniquindio.proyecto.entidades.Propietario;
import co.edu.uniquindio.proyecto.repositorios.PropietarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioServicioImpl implements IPropietarioServicio {
    private final PropietarioRepo propietarioRepo;

    public PropietarioServicioImpl(PropietarioRepo propietarioRepo) {
        this.propietarioRepo = propietarioRepo;
    }

    @Override
    public Propietario registrarPropietario(Propietario p) throws Exception {
        Optional<Propietario> buscado = propietarioRepo.findById(p.getCedula());

        if(buscado.isPresent()) throw new Exception("La cédula " + p.getCedula() + " ya está registrada.");

        buscado = propietarioRepo.findByEmail(p.getEmail());

        if(buscado.isPresent()) throw new Exception("El correo " + p.getEmail() + " ya está registrado.");

        return propietarioRepo.save(p);
    }

    @Override
    public Propietario actualizarPropietario(Propietario pNuevo) throws Exception {
        Optional<Propietario> buscado = propietarioRepo.findById(pNuevo.getCedula());

        if(buscado.isEmpty()) throw new Exception("La cédula " + pNuevo.getCedula() + " no está registrada.");

        return propietarioRepo.save(pNuevo);
    }

    @Override
    public void eliminarPropietario(String cedula) throws Exception {
        Optional<Propietario> buscado = propietarioRepo.findById(cedula);

        if(buscado.isEmpty()) throw new Exception("La cédula " + cedula + " no está registrada.");

        propietarioRepo.delete(buscado.get());
    }

    @Override
    public List<Propietario> listarPropietarios() {
        return propietarioRepo.findAll();
    }

    @Override
    public Propietario getPropietario(String cedula) throws Exception {
        Optional<Propietario> buscado = propietarioRepo.findById(cedula);

        if(buscado.isEmpty()) throw new Exception("La cédula " + cedula + " no está registrada.");

        return buscado.get();
    }
}
