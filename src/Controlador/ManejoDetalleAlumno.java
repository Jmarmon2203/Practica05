package Controlador;

import Excepciones.AppErrors;
import Excepciones.ErrorLogger;
import Excepciones.MiExcepcion;
import Modelo.Alumno;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejoDetalleAlumno {

    private PreparedStatement st = null;
    private ResultSet rs = null;

    public ManejoDetalleAlumno(int cursoID) throws MiExcepcion {
        try {
            String query = "SELECT * FROM Alumno WHERE cursoID = ?";
            st = ConexionBD.obtenerConexion().prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            st.setInt(1, cursoID);
            rs = st.executeQuery();
            primero();
        } catch (SQLException ex) {
            int errorCode = AppErrors.USER_NOT_FOUND;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }
        
    }

    public boolean esVacio() throws MiExcepcion {
        try {
            if (rs.next()) {
                rs.beforeFirst();
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            int errorCode = AppErrors.INVALID_RECORD_ID;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }
    }

    public boolean anterior() throws MiExcepcion {
        try {
            return rs.previous();
        } catch (SQLException ex) {
            int errorCode = AppErrors.INVALID_RECORD_ID;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        } 
    }

    public boolean siguiente() throws MiExcepcion {
        try {
            return rs.next();
        } catch (SQLException ex) {
            int errorCode = AppErrors.INVALID_RECORD_ID;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }
    }

    public boolean primero() throws MiExcepcion {
        try {
            return rs.first();
        } catch (SQLException ex) {
            int errorCode = AppErrors.INVALID_RECORD_ID;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }
    }

    public boolean ultimo() throws MiExcepcion {
        try {
            return rs.last();
        } catch (SQLException ex) {
            int errorCode = AppErrors.INVALID_RECORD_ID;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }
    }

    public boolean esUltimo() throws MiExcepcion {
        try {
            return rs.isLast();
        } catch (SQLException ex) {
            int errorCode = AppErrors.INVALID_RECORD_ID;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }
    }

    public boolean esPrimero() throws MiExcepcion {
        try {
            return rs.isFirst();
        } catch (SQLException ex) {
            int errorCode = AppErrors.INVALID_RECORD_ID;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }
    }

    public Alumno leer() {
        Alumno alumnoALeer = null;
            try {
                alumnoALeer = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4));

            } catch (SQLException ex) {
                Logger.getLogger(ManejoDetalleAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        return alumnoALeer;
    }

        public void insertar(Alumno alumno) throws MiExcepcion {
        try {
              rs.moveToInsertRow();
              rs.updateString("usuario", alumno.getNombre());
              rs.updateString("password", alumno.getPassword());
              rs.insertRow();
              rs.moveToCurrentRow();
              ConexionBD.obtenerConexion().commit();
        } catch (SQLException ex) {
            int errorCode = AppErrors.SQL_QUERY_ERROR;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }
    }
    
    
    public void actualizar(Alumno alumno) throws MiExcepcion {
        try {
            rs.updateString("usuario", alumno.getNombre());
            rs.updateString("password", alumno.getPassword());

            rs.updateRow();

            ConexionBD.obtenerConexion().commit();
        } catch (SQLException ex) {
            int errorCode = AppErrors.SQL_QUERY_ERROR;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }
    }
}
