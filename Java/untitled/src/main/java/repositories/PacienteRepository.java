package repositories;

import entities.Paciente;
import utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteRepository {
    public void agregarPaciente(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO Pacientes (nombre, apellido, fechaNacimiento, telefono, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellido());
            stmt.setString(3, paciente.getFechaNacimiento());
            stmt.setString(4, paciente.getTelefono());
            stmt.setString(5, paciente.getEmail());
            stmt.executeUpdate();
        }
    }
}
