package services;

import entities.Paciente;
import repositories.PacienteRepository;
import java.sql.SQLException;

public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService() {
        this.pacienteRepository = new PacienteRepository();
    }

    public void registrarPaciente(Paciente paciente) throws SQLException {
        if (paciente.getNombre().isEmpty() || paciente.getApellido().isEmpty()) {
            throw new IllegalArgumentException("El nombre y apellido son obligatorios");
        }
        pacienteRepository.agregarPaciente(paciente);
    }
}
