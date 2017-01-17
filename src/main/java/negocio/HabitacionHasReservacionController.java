package negocio;

import modelo.HabitacionHasReservacion;
import negocio.util.JsfUtil;
import negocio.util.JsfUtil.PersistAction;
import controlador.HabitacionHasReservacionFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("habitacionHasReservacionController")
@SessionScoped
public class HabitacionHasReservacionController implements Serializable {

    @EJB
    private controlador.HabitacionHasReservacionFacade ejbFacade;
    private List<HabitacionHasReservacion> items = null;
    private HabitacionHasReservacion selected;

    public HabitacionHasReservacionController() {
    }

    public HabitacionHasReservacion getSelected() {
        return selected;
    }

    public void setSelected(HabitacionHasReservacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getHabitacionHasReservacionPK().setReservacionIdreservacion(selected.getReservacion().getIdreservacion());
        selected.getHabitacionHasReservacionPK().setHabitacionIdhabitacion(selected.getHabitacion().getIdhabitacion());
    }

    protected void initializeEmbeddableKey() {
        selected.setHabitacionHasReservacionPK(new modelo.HabitacionHasReservacionPK());
    }

    private HabitacionHasReservacionFacade getFacade() {
        return ejbFacade;
    }

    public HabitacionHasReservacion prepareCreate() {
        selected = new HabitacionHasReservacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("HabitacionHasReservacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("HabitacionHasReservacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("HabitacionHasReservacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<HabitacionHasReservacion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public HabitacionHasReservacion getHabitacionHasReservacion(modelo.HabitacionHasReservacionPK id) {
        return getFacade().find(id);
    }

    public List<HabitacionHasReservacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<HabitacionHasReservacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = HabitacionHasReservacion.class)
    public static class HabitacionHasReservacionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            HabitacionHasReservacionController controller = (HabitacionHasReservacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "habitacionHasReservacionController");
            return controller.getHabitacionHasReservacion(getKey(value));
        }

        modelo.HabitacionHasReservacionPK getKey(String value) {
            modelo.HabitacionHasReservacionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new modelo.HabitacionHasReservacionPK();
            key.setHabitacionIdhabitacion(Integer.parseInt(values[0]));
            key.setReservacionIdreservacion(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(modelo.HabitacionHasReservacionPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getHabitacionIdhabitacion());
            sb.append(SEPARATOR);
            sb.append(value.getReservacionIdreservacion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof HabitacionHasReservacion) {
                HabitacionHasReservacion o = (HabitacionHasReservacion) object;
                return getStringKey(o.getHabitacionHasReservacionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), HabitacionHasReservacion.class.getName()});
                return null;
            }
        }

    }

}
