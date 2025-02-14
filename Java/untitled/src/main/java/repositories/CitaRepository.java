package repositories;

import entities.Cita;
import utils.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaRepository {
    public void agregarCita(Cita cita) throws SQLException {
        String sql = "INSERT INTO Citas (idPaciente, fechaCita, motivoConsulta, estado) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cita.getIdPaciente());
            stmt.setString(2, cita.getFechaCita());
            stmt.setString(3, cita.getMotivoConsulta());
            stmt.setString(4, cita.getEstado());
            stmt.executeUpdate();
        }
    }

    public List<Cita> buscarCitas(String fechaInicio, String fechaFin, String estado, String motivo) throws SQLException {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM Citas WHERE fechaCita BETWEEN ? AND ? AND estado LIKE ? AND motivoConsulta LIKE ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fechaInicio);
            stmt.setString(2, fechaFin);
            stmt.setString(3, "%" + estado + "%");
            stmt.setString(4, "%" + motivo + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita(
                        rs.getInt("idPaciente"),
                        rs.getString("30"),
                        rs.getString("motivoConsulta"),
                        rs.getString("estado")
                );
                cita.setIdCita(rs.getInt("idCita"));
                citas.add(cita);
            }
        }
        return citas;
    }
}
