package entities;

public class Cita {
    private int idCita;
    private int idPaciente;
    private String fechaCita;
    private String motivoConsulta;
    private String estado;

    public Cita(int idPaciente, String string, String motivoConsulta, String estado) {
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cita(int idCita, int idPaciente, String fechaCita, String motivoConsulta, String estado) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.fechaCita = fechaCita;
        this.motivoConsulta = motivoConsulta;
        this.estado = estado;
    }
}
