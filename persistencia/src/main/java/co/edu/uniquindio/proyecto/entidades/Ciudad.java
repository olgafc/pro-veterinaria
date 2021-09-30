package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Ciudad implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer codigo;
        private String nombre;


        public Ciudad() {
            super();
        }

        public Ciudad(String nombre) {
            this.nombre = nombre;

        }

        public Integer getCodigo() {
            return codigo;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Ciudad ciudad = (Ciudad) o;

            return codigo != null ? codigo.equals(ciudad.codigo) : ciudad.codigo == null;
        }

        @Override
        public int hashCode() {
            return codigo != null ? codigo.hashCode() : 0;
        }
    }



