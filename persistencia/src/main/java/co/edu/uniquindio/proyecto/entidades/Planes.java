package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Planes")
@Getter
@Setter
@ToString

public class Planes implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;


    @Column(nullable = false, length = 100)
    private Integer nombre;

    public Planes() {
    }

    public Planes(Integer codigo, Integer nombre, MetodoPago metodoPago) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.metodoPago = metodoPago;
    }

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;
    }



