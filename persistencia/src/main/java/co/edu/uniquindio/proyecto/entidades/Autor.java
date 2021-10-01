package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
    public  class Autor implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Integer codigo;
        @Column(length = 100, nullable = false)
        private String nombre;

        @Column(nullable = false, precision = 4)
        private Integer anioNacimiento;





        public Autor(String nombre, Integer anioNacimiento) {
            this.nombre = nombre;
            this.anioNacimiento = anioNacimiento;
        }

    }

