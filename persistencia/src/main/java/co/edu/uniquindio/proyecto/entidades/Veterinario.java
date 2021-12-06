package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Veterinario")
@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class Veterinario extends Persona implements Serializable {


    @Column(nullable = false, length = 100)
    @Length(max = 100)
    @NotBlank
    private String descripcionCargo;

    @OneToMany(mappedBy = "veterinario")
    @ToString.Exclude
    private List<Historial> historiales;

}

