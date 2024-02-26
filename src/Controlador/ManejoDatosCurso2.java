package Controlador;

import Excepciones.AppErrors;
import Excepciones.ErrorLogger;
import Excepciones.MiExcepcion;
import Modelo.Curso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Util.Util;

public class ManejoDatosCurso2 {

    private Statement st;
    private ResultSet rs;

    public ManejoDatosCurso2(int cursoID) throws MiExcepcion {
        try {
            String query = "SELECT * FROM Curso WHERE cursoID = " + cursoID;
            st = ConexionBD.obtenerConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(query);
            rs.next();
        } catch (SQLException ex) {
            int errorCode = AppErrors.SQL_QUERY_ERROR;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }

    }

    public Curso leer() throws MiExcepcion {
        Curso evento = null;
        try {
            evento = new Curso(rs.getInt(1), rs.getString(2), rs.getString(3), Util.dateToGC(rs.getDate(4)),
                    rs.getFloat(5), rs.getFloat(6));

        } catch (SQLException ex) {
            int errorCode = AppErrors.SQL_QUERY_ERROR;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }

        return evento;
    }

    public void calcularMediaCalificaciones(Curso curso) throws MiExcepcion {
        try {
            String query = "SELECT AVG(notaFinal) FROM Alumno WHERE cursoID = " + curso.getCursoID();
            st = ConexionBD.obtenerConexion().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                float mediaCalificaciones = rs.getFloat(1);
                curso.setMediaCalificaciones(mediaCalificaciones);
            }

        } catch (SQLException ex) {
            int errorCode = AppErrors.SQL_QUERY_ERROR;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);
        }

    }

}