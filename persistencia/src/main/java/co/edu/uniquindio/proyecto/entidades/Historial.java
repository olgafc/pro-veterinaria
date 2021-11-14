package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

        @ManyToMany
        private List<Veterinario> veterinarios;

        public Historial() {
        }

        public Historial(Integer codigo, String nombre, Integer fecha, List<Veterinario> veterinarios) {
                this.codigo = codigo;
                this.nombre = nombre;
                this.fecha = fecha;
                this.veterinarios = veterinarios;
        }
}



