package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepo extends JpaRepository<Pago, Integer> {
    @Query("select p from Pago p where p.propietario.cedula = :cedulaPropietario")
    List<Pago> pagosPorPropietario(String cedulaPropietario);

    @Query("select p from Pago p where p.plan.codigo = :codigoPlan")
    List<Pago> pagosPorPlan(Integer codigoPlan) throws Exception;
}
