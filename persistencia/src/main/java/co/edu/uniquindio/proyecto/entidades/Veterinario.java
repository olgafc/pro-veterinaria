package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Veterinario")
@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class Veterinario extends Persona implements Serializable {


    @EqualsAndHashCode.Include
    @Column(length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;


}

