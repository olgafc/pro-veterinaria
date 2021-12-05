package co.edu.uniquindio.proyecto.servicio;

import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.repositorios.PlanRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServicioImpl implements IPlanServicio {
    private final PlanRepo planesRepo;

    public PlanServicioImpl(PlanRepo planesRepo) {
        this.planesRepo = planesRepo;
    }

    @Override
    public Plan crearPlan(Plan p) throws Exception {
        Optional<Plan> buscado = planesRepo.findById(p.getCodigo());

        if(buscado.isPresent()) throw new Exception("El código" + p.getCodigo() + " ya está registrado.");

        return planesRepo.save(p);
    }

    @Override
    public Plan actualizarPlan(Plan p) throws Exception {
        Optional<Plan> buscado = planesRepo.findById(p.getCodigo());

        if(buscado.isEmpty()) throw new Exception("El código " + p.getCodigo() + " no está registrado.");

        return planesRepo.save(p);
    }

    @Override
    public List<Plan> listarPlanes() {
            return planesRepo.findAll();
    }

    @Override
    public Plan getPlan(Integer codigo) throws Exception {
        Optional<Plan> buscado = planesRepo.findById(codigo);

        if(buscado.isEmpty()) throw new Exception("El codigo " + codigo + " no está registrado.");

        return buscado.get();
    }
}
