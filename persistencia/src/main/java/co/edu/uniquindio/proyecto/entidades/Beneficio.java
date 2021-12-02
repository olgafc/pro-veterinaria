package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="Beneficio")
@Getter
@Setter
@ToString
public class Beneficio implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;


    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(nullable = false, length = 100)
    private Float precio;

    @ManyToMany(mappedBy = "beneficios")
    @ToString.Exclude
    private List<Plan> planes;
}
