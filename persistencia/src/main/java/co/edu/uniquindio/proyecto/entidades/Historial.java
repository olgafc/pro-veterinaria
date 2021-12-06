package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="Historial")
@Setter
@Getter
@ToString

public class Historial implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Integer codigo;

        @Column(nullable = false, length = 80)
        private String nombre;


        @Column(nullable = false)
        private Integer fecha;


        @ManyToOne
        @ToString.Exclude
        @JoinColumn(nullable = false)
        private Mascota mascota;

        @Column(nullable = false, length = 80)
        private String descripcion;

        @ManyToOne
        @ToString.Exclude
        @JoinColumn(nullable = false)
        private Veterinario veterinario;

        public Historial() {
        }

        public Historial(Integer codigo, String nombre, Integer fecha) {
                this.codigo = codigo;
                this.nombre = nombre;
                this.fecha = fecha;
        }
}



