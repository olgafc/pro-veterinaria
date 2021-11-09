package co.edu.uniquindio.proyecto.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.*;

import javax.persistence.*;

    @Setter
    @Getter
    @NoArgsConstructor
    @Entity
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    @MappedSuperclass
    @AllArgsConstructor


    public class Persona implements Serializable {

    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
        private  String codigo;

    @Column(nullable = false, length = 100)
        private String nombre;

    @Column(nullable = false)
        private LocalDate fechaNacimiento;



}
