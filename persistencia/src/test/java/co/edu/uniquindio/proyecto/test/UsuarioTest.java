package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.GeneroPersona;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;


    @Test
    public void registrarTest() {
        Usuario usuario = new Usuario();
        usuario.setCodigo("123");
        usuario.setNombre("pepito");
        usuario.setEmail("pepe@gmail.com");
        usuario.setGenero(GeneroPersona.MASCULINO);
        usuario.setFechaNacimiento(LocalDate.now());
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "171414");
        telefonos.put("celular", "5689855");

        usuario.setNumTelefono(telefonos);

        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        Assertions.assertNotNull(usuarioGuardado);

    }

    @Test
    public void eliminarTest(){
        Usuario usuario = new Usuario();
        usuario.setCodigo("123");
        usuario.setNombre("pepito");
        usuario.setEmail("pepe@gmail.com");
        usuario.setGenero(GeneroPersona.MASCULINO);
        usuario.setFechaNacimiento(LocalDate.now());

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "171414");
        telefonos.put("celular", "5689855");

        usuario.setNumTelefono(telefonos);

        usuarioRepo.save(usuario);
        usuarioRepo.deleteById("123");
        Usuario usuarioBuscado = usuarioRepo.findById("123").orElse(null);
        Assertions.assertNull(usuarioBuscado);
    }
@Test
    public void actualizarTest(){

        //guardo el usuario en bd
    Usuario usuario = new Usuario();
    usuario.setCodigo("123");
    usuario.setNombre("pepito");
    usuario.setEmail("pepe@gmail.com");
    usuario.setGenero(GeneroPersona.MASCULINO);
    usuario.setFechaNacimiento(LocalDate.now());

    Map<String, String> telefonos = new HashMap<>();
    telefonos.put("casa", "171414");
    telefonos.put("celular", "5689855");

    usuario.setNumTelefono(telefonos);
    Usuario guardado = usuarioRepo.save(usuario);

    //modifico el correo
    guardado.setEmail("pepa1@gamil.com");

    //guardar el usuario
    usuarioRepo.save(guardado);
    Usuario usuarioBuscado = usuarioRepo.findById("123").orElse(null);

    Assertions.assertEquals( "pepe1@gmail.com", usuarioBuscado.getEmail());

    }

    public UsuarioTest() {
    }

    @Test
    @Sql("classpath:data.sql")
    public void listarTest(){
        List<Usuario> usuarios = usuarioRepo.findAll();
        System.out.println(usuarios);


    }




}

