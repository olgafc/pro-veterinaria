package co.edu.uniquindio.proyecto.entidades;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Propietario")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Propietario extends Persona implements Serializable {

    @Column(length = 100)
    @Length(max = 100)
    private String direccion;

    @OneToMany(mappedBy = "propietario")
    @ToString.Exclude
    private List<Mascota> mascotas;

    @OneToMany(mappedBy = "propietario")
    @ToString.Exclude
    private List<Plan> planes;

    public Propietario(String cedula, String nombre, String direccion) {
        super(cedula, nombre);
        this.direccion = direccion;
    }
}


