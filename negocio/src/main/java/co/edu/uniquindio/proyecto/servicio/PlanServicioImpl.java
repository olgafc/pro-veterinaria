package co.edu.uniquindio.proyecto.servicio;

import co.edu.uniquindio.proyecto.entidades.Planes;
import co.edu.uniquindio.proyecto.entidades.Propietario;
import co.edu.uniquindio.proyecto.repositorios.PlanesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServicioImpl implements IPlanServicio {
    private final PlanesRepo planesRepo;

    public PlanServicioImpl(PlanesRepo planesRepo) {
        this.planesRepo = planesRepo;
    }

    @Override
    public  Planes crearPlan(Planes p) throws Exception {
        Optional<Planes> buscado = planesRepo.findById(p.getCodigo());

        if(buscado.isPresent()) throw new Exception("El código" + p.getCodigo() + " ya está registrado.");

        return planesRepo.save(p);
    }

    @Override
    public Planes actualizarPlan(Planes p) throws Exception {
        Optional<Planes> buscado = planesRepo.findById(p.getCodigo());

        if(buscado.isEmpty()) throw new Exception("El código " + p.getCodigo() + " no está registrado.");

        return planesRepo.save(p);
    }

    @Override
    public List<Planes> listarPlanes() {
            return planesRepo.findAll();
    }

    @Override
    public Planes getPlan(Integer codigo) throws Exception {
        Optional<Planes> buscado = planesRepo.findById(codigo);

        if(buscado.isEmpty()) throw new Exception("El codigo " + codigo + " no está registrado.");

        return buscado.get();
    }
}
