package controlador;

import DAO.ProfesionalDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.ClsProfesional;

/**
 * @author Daniel´s
 * 
 */
public class CtlProfesional {
    ProfesionalDAO usuDAO = new ProfesionalDAO();
       
    public boolean SolicitudGuardar(String especializacion, String nombre, String apellido, String cedula, int edad, String telefono) {
        ClsProfesional usuario = new ClsProfesional(especializacion, nombre, apellido, cedula, edad, telefono);
        return usuDAO.guardarProfesional(usuario);
    }
    
    public List<String> SolicitudBuscar(String cedula) {        
        return usuDAO.buscarProfesiona(cedula);
    }

    public boolean SolicitudModificar(String especializacion, String nombre, String apellido, String cedula, int edad, String telefono) {
        ClsProfesional usuario = new ClsProfesional(especializacion, nombre, apellido, cedula, edad, telefono);        
        return usuDAO.modificarProfesiona(usuario);
    }

    public boolean solicitudEliminar(String cedula) {        
        return usuDAO.eliminarProfesiona(cedula);
    }

    public DefaultTableModel SolicitudListar() {        
        return usuDAO.listarProfesiona();        
    }
}
