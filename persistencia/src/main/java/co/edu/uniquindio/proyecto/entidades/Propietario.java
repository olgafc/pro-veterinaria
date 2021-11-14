package co.edu.uniquindio.proyecto.entidades;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Propietario")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Propietario extends Persona implements Serializable {

    @Column(length = 100)
    private String direccion;

    @Column(nullable = false, length = 100)
    private Integer email;
}


