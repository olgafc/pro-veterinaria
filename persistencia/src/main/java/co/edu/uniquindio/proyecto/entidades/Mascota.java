package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="Mascota")
@Getter
@Setter
@ToString

public class Mascota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 100)
    private Integer codigoMascota;


   //* @Enumerated(EnumType.STRING)
    //*private TipoMascota tipoMascota;

    @Column( length = 100)
    private String nombre;

    @Column(length = 100)
    private String raza;

    @Column(nullable = false, length = 100)
    private int edad;

    @Column( length = 100)
    private int sexo;


    @OneToMany(mappedBy = "mascota")
    @ToString.Exclude
    private List<Historial> historiales;

    @ManyToOne
    @ToString.Exclude
    private Propietario propietario;

    public Mascota() {
    }

    public Mascota(Integer codigoMascota, String nombre, String raza, int edad, int sexo) {
        this.codigoMascota = codigoMascota;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.sexo = sexo;
    }
}