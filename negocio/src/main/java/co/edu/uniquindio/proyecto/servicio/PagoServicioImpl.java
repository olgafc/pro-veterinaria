package co.edu.uniquindio.proyecto.servicio;

import co.edu.uniquindio.proyecto.entidades.Pago;
import co.edu.uniquindio.proyecto.entidades.Plan;
import co.edu.uniquindio.proyecto.entidades.Propietario;
import co.edu.uniquindio.proyecto.repositorios.PagoRepo;
import co.edu.uniquindio.proyecto.repositorios.PlanRepo;
import co.edu.uniquindio.proyecto.repositorios.PropietarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServicioImpl implements IPagoServicio {
    private final PagoRepo pagoRepo;
    private final PlanRepo planRepo;
    private final PropietarioRepo propietarioRepo;

    public PagoServicioImpl(PagoRepo pagoRepo, PlanRepo planRepo, PropietarioRepo propietarioRepo) {
        this.pagoRepo = pagoRepo;
        this.planRepo = planRepo;
        this.propietarioRepo = propietarioRepo;
    }

    @Override
    public Pago registrarPago(Pago p) throws Exception {
        Optional<Pago> pagoBuscado = pagoRepo.findById(p.getCodigo());

        if(pagoBuscado.isPresent()) throw new Exception("El código " + p.getCodigo() + " ya está registrado");

        return pagoRepo.save(p);
    }

    @Override
    public Pago actualizarPago(Pago p) throws Exception {
        Optional<Pago> pagoBuscado = pagoRepo.findById(p.getCodigo());

        if(pagoBuscado.isEmpty()) throw new Exception("El código " + p.getCodigo() + " no está registrado");

        return pagoRepo.save(p);
    }

    @Override
    public void eliminarPago(Integer codigo) throws Exception {
        Optional<Pago> pagoBuscado = pagoRepo.findById(codigo);

        if(pagoBuscado.isEmpty()) throw new Exception("El código " + codigo + " no está registrado");

        pagoRepo.deleteById(codigo);
    }

    @Override
    public List<Pago> pagosPorPlan(Integer codigoPlan) throws Exception {
        Optional<Plan> planBuscado = planRepo.findById(codigoPlan);

        if(planBuscado.isEmpty()) throw new Exception("El plan " + codigoPlan + " no está registrado");

        return pagoRepo.pagosPorPlan(codigoPlan);
    }

    @Override
    public List<Pago> pagosPorPropietario(String cedulaPropietario) throws Exception {
        Optional<Propietario> propietarioBuscado = propietarioRepo.findById(cedulaPropietario);

        if(propietarioBuscado.isEmpty()) throw new Exception("El propietario " + cedulaPropietario + " no está registrado");

        return pagoRepo.pagosPorPropietario(cedulaPropietario);
    }

    @Override
    public List<Pago> listarPagos() {
        return pagoRepo.findAll();
    }

    @Override
    public Pago getPago(Integer codigo) throws Exception {
        Optional<Pago> pagoBuscado = pagoRepo.findById(codigo);

        if(pagoBuscado.isEmpty()) throw new Exception("El pago " + pagoBuscado + " no está registrado");

        return pagoBuscado.get();
    }
}
