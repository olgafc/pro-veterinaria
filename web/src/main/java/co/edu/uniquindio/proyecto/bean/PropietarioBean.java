package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Propietario;
import co.edu.uniquindio.proyecto.servicio.IPropietarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Controller
@Component
@ViewScoped
@RequestMapping("/request")
public class PropietarioBean implements Serializable {
    @Getter @Setter
    private Propietario propietario;

    @Autowired
    private IPropietarioServicio propietarioServicio;

    @PostConstruct
    public void inicializar() {
        propietario = new Propietario();
    }

    @RequestMapping("/registrar")
    public void registrarPropietario() {
        try {
            System.out.println(propietario);
            propietarioServicio.registrarPropietario(propietario);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
