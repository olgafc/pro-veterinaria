package co.edu.uniquindio.proyecto.entidades;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="Propietario")
@Getter
@Setter
@ToString


public class Propietario extends Persona implements Serializable {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 100)
    @EqualsAndHashCode.Include
    private Integer identificacion;


    @Column(length = 100)
    private String direccion;

    @Column(nullable = false, length = 100)
    private Integer email;

    public Propietario() {
    }

    public Propietario(Integer identificacion, String direccion, Integer email) {
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.email = email;
    }
}


