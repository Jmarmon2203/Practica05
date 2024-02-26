package Controlador;

import Excepciones.AppErrors;
import Excepciones.ErrorLogger;
import Excepciones.MiExcepcion;
import java.sql.*;

public class ConexionBD {

    private static final String URL = "jdbc:derby://localhost:1527/examen";
    private static final String USUARIO = "examen";
    private static final String CONTRASENA = "examen";

    private static Connection conexion;

    public static void abrirConexion() throws MiExcepcion {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            System.out.println("Conexión establecida.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            int errorCode = AppErrors.DATABASE_OPEN_ERROR;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(errorCode);

        }
    }

    public static boolean cerrarConexion() throws MiExcepcion {
        try {
            conexion.close();
            return true;
        } catch (SQLException e) {
            int errorCode = AppErrors.DATABASE_CLOSE_ERROR;
            ErrorLogger.getInstance().logError(errorCode);
            throw new MiExcepcion(AppErrors.DATABASE_CLOSE_ERROR);
        } finally {
            return false;
        }
    }

    public static Connection obtenerConexion() {
        return conexion;
    }
}