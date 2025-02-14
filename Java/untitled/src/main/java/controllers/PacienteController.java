package controllers;

import entities.Paciente;
import services.PacienteService;
import java.sql.SQLException;
import java.util.Scanner;

public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController() {
        this.pacienteService = new PacienteService();
    }

    public void registrarPaciente() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese apellido:");
        String apellido = scanner.nextLine();

        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);

        pacienteService.registrarPaciente(paciente);
        System.out.println("Paciente registrado con éxito!");
    }
}
