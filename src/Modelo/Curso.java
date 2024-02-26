package Modelo;

import java.util.GregorianCalendar;

public class Curso {
    private int cursoID;
    private String nombre;
    private String password;
    private GregorianCalendar fecha;
    private float notaCorte;
    private float mediaCalificaciones = 0;

    public Curso(int cursoID, String nombre, String password, GregorianCalendar fecha, float notaCorte, float mediaCalificaciones) {
        this.cursoID = cursoID;
        this.nombre = nombre;
        this.password = password;
        this.fecha = fecha;
        this.notaCorte = notaCorte;
        this.mediaCalificaciones = mediaCalificaciones;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public float getNotaCorte() {
        return notaCorte;
    }

    public void setNotaCorte(float notaCorte) {
        this.notaCorte = notaCorte;
    }

    public float getMediaCalificaciones() {
        return mediaCalificaciones;
    }

    public void setMediaCalificaciones(float mediaCalificaciones) {
        this.mediaCalificaciones = mediaCalificaciones;
    }
}