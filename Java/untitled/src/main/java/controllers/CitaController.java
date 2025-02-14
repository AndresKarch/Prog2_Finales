package controllers;

import entities.Cita;
import services.CitaService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CitaController {
    private final CitaService citaService;

    public CitaController() {
        this.citaService = new CitaService();
    }

    public void registrarCita() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese ID del paciente:");
        int idPaciente = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese fecha de la cita (YYYY-MM-DD HH:MM:SS):");
        String fechaCita = scanner.nextLine();
        System.out.println("Ingrese motivo de la consulta:");
        String motivo = scanner.nextLine();
        System.out.println("Ingrese estado (Pendiente, Completada, Cancelada):");
        String estado = scanner.nextLine();

        Cita cita = new Cita(idPaciente, fechaCita, motivo, estado);
        citaService.registrarCita(cita);
        System.out.println("Cita registrada con éxito!");
    }

    public void filtrarCitas() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese fecha inicio (YYYY-MM-DD):");
        String fechaInicio = scanner.nextLine();
        System.out.println("Ingrese fecha fin (YYYY-MM-DD):");
        String fechaFin = scanner.nextLine();
        System.out.println("Ingrese estado (dejar vacío para todos):");
        String estado = scanner.nextLine();
        System.out.println("Ingrese parte del motivo (dejar vacío para todos):");
        String motivo = scanner.nextLine();

        List<Cita> citas = citaService.filtrarCitas(fechaInicio, fechaFin, estado, motivo);
        for (Cita c : citas) {
            System.out.println("ID: " + c.getIdCita() + " - Paciente: " + c.getIdPaciente() +
                    " - Fecha: " + c.getFechaCita() + " - Motivo: " + c.getMotivoConsulta() +
                    " - Estado: " + c.getEstado());
        }
    }
}
