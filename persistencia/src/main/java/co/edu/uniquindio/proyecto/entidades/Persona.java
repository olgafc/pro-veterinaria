package co.edu.uniquindio.proyecto.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import lombok.*;

import javax.persistence.*;


    @Entity
    @Table(name="Persona")
    @Getter
    @Setter
    @ToString
    @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    //@MappedSuperclass

    public class Persona implements Serializable {
        @Id
        @Column(nullable = false, length = 100)
        private Integer nombre;

        @ElementCollection
        @JoinColumn(nullable = false)
        private Map<String, String> numTelefono;

        public Persona() {
        }

        public Persona(Integer nombre, Map<String, String> numTelefono) {
            this.nombre = nombre;
            this.numTelefono = numTelefono;
        }
    }
