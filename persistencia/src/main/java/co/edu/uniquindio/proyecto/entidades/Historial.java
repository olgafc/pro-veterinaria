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

public class Ciudad implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include

        private Integer codigo;

        @Column(nullable = false, length = 80)
        private String nombre;

        @OneToMany(mappedBy = "ciudad")
        private List<Propietario> usuarios;

        public Ciudad(String nombre) {this.nombre = nombre; }



    }



