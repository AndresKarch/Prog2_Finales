CREATE TABLE IF NOT EXISTS Pacientes (
    idPaciente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Citas (
    idCita INT AUTO_INCREMENT PRIMARY KEY,
    idPaciente INT NOT NULL,
    fechaCita DATETIME NOT NULL,
    motivoConsulta VARCHAR(255),
    estado ENUM('Pendiente', 'Completada', 'Cancelada') NOT NULL,
    FOREIGN KEY (idPaciente) REFERENCES Pacientes(idPaciente)
);

-- Insertar datos iniciales
INSERT INTO Pacientes (nombre, apellido, fechaNacimiento, telefono, email) VALUES
('María', 'López', '1985-06-12', '1123456789', 'maria.lopez@gmail.com'),
('Carlos', 'Pérez', '1990-09-25', '1198765432', 'carlos.perez@gmail.com');

INSERT INTO Citas (idPaciente, fechaCita, motivoConsulta, estado) VALUES
(1, '2024-12-15 09:30:00', 'Chequeo General', 'Pendiente'),
(2, '2024-12-16 14:00:00', 'Dolor de cabeza', 'Completada'),
(1, '2024-12-17 11:00:00', 'Revisión de análisis', 'Cancelada');
