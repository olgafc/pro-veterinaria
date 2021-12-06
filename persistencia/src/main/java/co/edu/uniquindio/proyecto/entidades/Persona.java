package co.edu.uniquindio.proyecto.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name="Persona")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Persona implements Serializable {
    @Id
    @Column(nullable = false, length = 10)
    @Length(max = 10)
    @EqualsAndHashCode.Include
    @NotBlank
    private String cedula;

    @Column(nullable = false, length = 100)
    @Length(max = 100)
    @NotBlank
    private String nombre;

    @Column(nullable = false, length = 100)
    @Length(max = 100)
    @NotBlank
    private String email;

    @Column(nullable = true, length = 100)
    @Length(max = 100)
    //@NotBlank
    private String password;

    @ElementCollection
    @ToString.Exclude
    private Map<String, String> numTelefono;

    public Persona() {
    }

    public Persona(String cedula, String nombre, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
    }
}
