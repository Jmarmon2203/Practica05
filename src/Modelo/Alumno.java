package Modelo;

public class Alumno {
    private String nombre;
    private String password;
    private String imagen;
    private float notaFinal;

    public Alumno(String nombre, String password, String imagen, float notaFinal) {
        this.nombre = nombre;
        this.password = password;
        this.imagen = imagen;
        this.notaFinal = notaFinal;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }
}