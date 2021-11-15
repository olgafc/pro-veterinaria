package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Propietario;
import co.edu.uniquindio.proyecto.servicio.IPropietarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class PropietarioBean implements Serializable {
    @Getter @Setter
    private Propietario propietario;

    @Autowired
    private IPropietarioServicio propietarioServicio;

    @PostConstruct
    public void inicializar() {
        propietario = new Propietario();
    }

    public void registrarPropietario() {
        try {
            propietarioServicio.registrarPropietario(propietario);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
