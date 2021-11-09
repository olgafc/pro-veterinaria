package co.edu.uniquindio.proyecto.entidades;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Usuario extends Persona implements Serializable  {



    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @ElementCollection
    @JoinColumn(nullable = false)
    private Map<String, String> numTelefono;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroPersona genero;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

     @OneToMany(mappedBy = "usuarioPrestamo")
    private List<Prestamo> prestamos;

    public Usuario(String email, Map<String, String> numTelefono, GeneroPersona genero) {
        this.email = email;
        this.numTelefono = numTelefono;
        this.genero = genero;
    }

    public Usuario(String codigo, String nombre, LocalDate fechaNacimiento, String email, Map<String, String> numTelefono) {
        super(codigo, nombre, fechaNacimiento);
        this.email = email;
        this.numTelefono = numTelefono;
    }
}
