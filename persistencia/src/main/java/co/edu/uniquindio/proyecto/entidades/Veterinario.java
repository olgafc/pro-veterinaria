package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;


@Entity
@Table(name="Veterinario")
@Setter
@Getter
@ToString

    public  class Veterinario extends  Persona implements Serializable{


       @EqualsAndHashCode.Include
       @Column(length = 20)
       @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer codigo;




}

