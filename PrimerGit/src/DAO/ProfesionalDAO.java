package DAO;

import Infraestructura.ClsConexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.ClsProfesional;

/**
 *
 * @author Daniel's
 */
public class ProfesionalDAO {
    
    ClsConexion conexion;
    
    public ProfesionalDAO(){
        conexion = new ClsConexion();
    }

    public boolean guardarProfesional(ClsProfesional proDAO) {
        String consulta = "insert into profesional (especializacion,nombre,apellido,cedula,edad,telefono) values('" 
                + proDAO.getEspecializacion()+ "','" + proDAO.getNombre() + "','" + proDAO.getApellido() + 
                "'," + proDAO.getCedula() +",'"+proDAO.getEdad()+"',"+proDAO.getTelefono()+")";
        return conexion.ejecutar(consulta);
    }

    
    public List<String> buscarProfesiona(String cedula) {
        
        List<String> temp = new ArrayList<String>();
        
        String consulta = "select especializacion,nombre,apellido,cedula,edad,telefono "
                + "from profesional where cedula='" + cedula + "'";
        
        conexion.ejecutarRetorno(consulta);
        
        try {
            if (conexion.getResultadoDB().next()) {
                temp.add(conexion.getResultadoDB().getString("especializacion"));
                temp.add(conexion.getResultadoDB().getString("nombre"));
                temp.add(conexion.getResultadoDB().getString("apellido"));
                temp.add(conexion.getResultadoDB().getString("cedula"));
                temp.add(conexion.getResultadoDB().getInt("edad")+"");
                temp.add(conexion.getResultadoDB().getDouble("telefono")+"");
            }
        } catch (SQLException ex) {
            System.out.println("no es posible realizar la busqueda");
        }
        return temp;
    }

    public boolean modificarProfesiona(ClsProfesional usuDAO) {
        String consulta = "update profesional set especializacion='" + usuDAO.getEspecializacion()
                + "',nombre='" + usuDAO.getNombre() + "'," + "apellido=" + usuDAO.getApellido() + 
                "," +"cedula='" + usuDAO.getCedula() + "',"+"edad="+usuDAO.getEdad()+
                " where telefono='" + usuDAO.getTelefono()+"'";
        return conexion.ejecutar(consulta);
    }

    public boolean eliminarProfesiona(String cedula) {
        String consulta = "delete from profesional where cedula='" + cedula+"'";
        return conexion.ejecutar(consulta);
    }

    public DefaultTableModel listarProfesiona() {

        DefaultTableModel temp;
        String nombreColumnas[] = {"Cedula", "Nombre", "Apellido"};
        temp = new DefaultTableModel(new Object[][]{}, nombreColumnas);

        String consulta = "select cedula,nombre,apellido from profesional";
        conexion.ejecutarRetorno(consulta);

        try {
            while (conexion.getResultadoDB().next()) {
                temp.addRow(new Object[]{
                    conexion.getResultadoDB().getString("cedula"),
                    conexion.getResultadoDB().getString("nombre"),
                    conexion.getResultadoDB().getString("apellido")});
            }
        } catch (SQLException ex) {
            System.out.println("no se puede listar");
        }
        return temp;
    }
}
