package gestiontusanatorio.back.Models;

public class Obras_sociales {
    private int idObraSocial;
    private String nombre;

    public Obras_sociales(int idObraSocial, String nombre) {
        this.idObraSocial = idObraSocial;
        this.nombre = nombre;
    }

    public int getIdObraSocial() {
        return idObraSocial;
    }

    public void setIdObraSocial(int idObraSocial) {
        this.idObraSocial = idObraSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;  // Para mostrar en JComboBox
    }
}
