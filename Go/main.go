package main

import (
	"log"
	"net/http"

	"github.com/gorilla/mux"
	"examen_final_golang/handlers"
	"examen_final_golang/middlewares"
	"examen_final_golang/services"
)

func main() {
	r := mux.NewRouter()

	// Crear instancia del servicio de finanzas
	financeService := services.NewFinanceService()

	// Crear instancia del handler y pasar el servicio
	financeHandler := handlers.NewFinanceHandler(financeService)

	// Aplicar middleware de autenticación
	r.Use(middlewares.AuthMiddleware)

	// Rutas
	r.HandleFunc("/presupuesto-mensual", financeHandler.CalcularPresupuestoMensual).Methods("POST")
	r.HandleFunc("/interes-compuesto", financeHandler.CalcularInteresCompuesto).Methods("POST")
	r.HandleFunc("/amortizacion", financeHandler.GenerarTablaAmortizacion).Methods("GET")

	// Iniciar servidor
	log.Println("Servidor iniciado en :8080")
	log.Fatal(http.ListenAndServe(":8080", r))
}
