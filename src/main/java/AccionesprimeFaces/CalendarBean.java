package AccionesprimeFaces;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import BaseDeDatos.ConexionBaseDeDatos;
import Logica.Usuario;
import antlr.debug.Event;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@ManagedBean
@ViewScoped
public class CalendarBean implements Serializable {
	private String titulo;
	private Date fechaCreacion ;
	private Date fechaVencimiento ;
    
	public CalendarBean(String titulo, Date fechaCreacion, Date fechaVencimiento) {
		super();
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.fechaVencimiento = fechaVencimiento;
	}


	private static final long serialVersionUID = 5L;
    private ScheduleModel eventModel;
    private ScheduleEvent<?> selectedEvent;
    private Event newEvent; // Nueva actividad
    @ManagedProperty("#{vistaProfesores}")
    private VistaProfesores vistaProfesores;
    private String claveUsuari;
    public CalendarBean() {}
    @PostConstruct
    public void init() {
    	System.out.println("dsdsad");
    	 eventModel = new DefaultScheduleModel();
    	 FacesContext context = FacesContext.getCurrentInstance();
         Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        		  claveUsuari=usuario.getClave_usuario();
         // Llama al método para obtener las asignaciones por clave de grupo
         List<CalendarBean> asignaciones = null;
         asignaciones=ConexionBaseDeDatos.consultarDatosFechas(claveUsuari);
         System.out.println(asignaciones.size()+"sdasd "+claveUsuari);
         // Agrega los eventos al eventModel
         for (CalendarBean asignacion : asignaciones) {
        	 System.out.println("Fecha de creación: " + asignacion.getFechaCreacion());
        	    System.out.println("Fecha de vencimiento: " + asignacion.getFechaVencimiento());
        	    LocalDate localFechaCreacion = asignacion.getFechaCreacion().toLocalDate();
                LocalDate localFechaVencimiento = asignacion.getFechaVencimiento().toLocalDate();

                LocalDateTime startDate = localFechaCreacion.atStartOfDay();
                LocalDateTime endDate = localFechaVencimiento.atTime(23, 59, 59); // Se asume que la fecha de vencimiento es hasta el final del día

             ScheduleEvent evento = DefaultScheduleEvent.builder()
                     .title(asignacion.getTitulo())
                     .startDate(startDate)
                     .endDate(endDate)
                     .build();
             eventModel.addEvent(evento);
         }
     }
    

    public ScheduleModel getEventModel() {
        return eventModel;
    }
    public void onEventSelect(SelectEvent<ScheduleEvent<?>> event) {
    	selectedEvent = (ScheduleEvent<?>) event.getObject();
        System.out.println("Evento seleccionado: " + selectedEvent.getTitle());
    }
    public ScheduleEvent<?> getSelectedEvent() {
        return selectedEvent;
    }

  
    public void handleEventSelect(SelectEvent<ScheduleEvent<?>> event) {
        selectedEvent = (ScheduleEvent<?>) event.getObject();
        System.out.println("Evento seleccionado: " + selectedEvent.getTitle());
        PrimeFaces.current().executeScript("PF('eventDialog').show();");
    }


	/**
	 * @return the vistaProfesores
	 */
	public VistaProfesores getVistaProfesores() {
		return vistaProfesores;
	}


	public void setVistaProfesores(VistaProfesores vistaProfesores) {
		this.vistaProfesores = vistaProfesores;
	}


	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * @return the newEvent
	 */
	public Event getNewEvent() {
		return newEvent;
	}


	/**
	 * @return the claveUsuari
	 */
	public String getClaveUsuari() {
		return claveUsuari;
	}


	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	/**
	 * @param eventModel the eventModel to set
	 */
	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}


	/**
	 * @param selectedEvent the selectedEvent to set
	 */
	public void setSelectedEvent(ScheduleEvent<?> selectedEvent) {
		this.selectedEvent = selectedEvent;
	}


	/**
	 * @param newEvent the newEvent to set
	 */
	public void setNewEvent(Event newEvent) {
		this.newEvent = newEvent;
	}


	/**
	 * @param claveUsuari the claveUsuari to set
	 */
	public void setClaveUsuari(String claveUsuari) {
		this.claveUsuari = claveUsuari;
	}
    
}
    
