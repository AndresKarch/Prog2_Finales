import controllers.CitaController;
import controllers.PacienteController;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        PacienteController pacienteController = new PacienteController();
        pacienteController.registrarPaciente();
        CitaController citaController = new CitaController();
        citaController.registrarCita();
        citaController.filtrarCitas();
    }
}
