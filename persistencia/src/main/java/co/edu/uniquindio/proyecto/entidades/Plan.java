package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Planes")
@Getter
@Setter
@ToString

public class Plan implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;


    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToMany
    @ToString.Exclude
    private List<Beneficio> beneficios;

    @OneToMany(mappedBy = "plan")
    private List<Pago> pagos;

    public Plan() {
    }

    public Plan(Integer codigo, String nombre, MetodoPago metodoPago) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.metodoPago = metodoPago;
    }

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;
}



