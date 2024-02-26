package Controlador;

import Excepciones.AppErrors;
import Excepciones.ErrorLogger;
import Excepciones.MiExcepcion;
import Modelo.Alumno;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManejoDatosCurso {

    private Statement st = null;
    private ResultSet rs = null;

    public ManejoDatosCurso(int id) throws MiExcepcion {
        try {
            String query = "SELECT * FROM Alumno where cursoID = " + id;
            st = ConexionBD.obtenerConexion().createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            int errorCode = AppErrors.INVALID_RECORD_ID;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }

    }
    
    public List<Alumno> getAlumnos() throws MiExcepcion {
        List<Alumno> list = new ArrayList<>();
       
        try {
            while(rs.next()) {
                list.add(new Alumno (rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4)));
            }
        } catch (SQLException ex) {
            int errorCode = AppErrors.SQL_QUERY_ERROR;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }
        
        return list;
    }

}