package services;

import entities.Cita;
import repositories.CitaRepository;
import java.sql.SQLException;
import java.util.List;

public class CitaService {
    private final CitaRepository citaRepository;

    public CitaService() {
        this.citaRepository = new CitaRepository();
    }

    public void registrarCita(Cita cita) throws SQLException {
        if (cita.getFechaCita().isEmpty() || cita.getEstado().isEmpty()) {
            throw new IllegalArgumentException("Fecha y estado son obligatorios");
        }
        citaRepository.agregarCita(cita);
    }

    public List<Cita> filtrarCitas(String fechaInicio, String fechaFin, String estado, String motivo) throws SQLException {
        return citaRepository.buscarCitas(fechaInicio, fechaFin, estado, motivo);
    }
}
