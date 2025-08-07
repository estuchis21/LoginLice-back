package gestiontusanatorio.back.Models;

public class Medico {
    private int idMedico;
    private String nombreCompleto;

    public Medico(int idMedico, String nombreCompleto) {
        this.idMedico = idMedico;
        this.nombreCompleto = nombreCompleto;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return nombreCompleto;  // Esto muestra el nombre en el JComboBox
    }
}
