package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Planes;
import co.edu.uniquindio.proyecto.entidades.Propietario;
import co.edu.uniquindio.proyecto.servicio.IPlanServicio;
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
public class PlanBean implements Serializable {
    @Getter @Setter
    private Planes planes;

    @Autowired
    private IPlanServicio planServicio;

    @PostConstruct
    public void inicializar() {
        planes = new Planes();
    }

    public void crearPlan() {
        try {
            planServicio.crearPlan(planes);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "El plan se creó con éxito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void actualizarPlan() {
        try {
            planServicio.actualizarPlan(planes);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "El plan se actualizó con éxito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
