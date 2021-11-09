package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Diagnostico implements Serializable {
    @Id

    @Column(nullable = false)
    private Integer fecha;

    @Column(nullable = false, length = 200)
    private String observaciones;


    @Column(nullable = false, length = 80)
    private String enfermedades;

    @Column(nullable = false, length = 80)
    private String medicamentos;




    }

