package handlers

import (
	"encoding/json"
	"net/http"
	"strconv"

	"examen_final_golang/dto"
	"examen_final_golang/services"
)

type FinanceHandler struct {
	service *services.FinanceService
}

func NewFinanceHandler(service *services.FinanceService) *FinanceHandler {
	return &FinanceHandler{service: service}
}

// Handler para calcular presupuesto mensual
func (fh *FinanceHandler) CalcularPresupuestoMensual(w http.ResponseWriter, r *http.Request) {
	var req dto.PresupuestoRequest
	if err := json.NewDecoder(r.Body).Decode(&req); err != nil {
		http.Error(w, "Error en la solicitud", http.StatusBadRequest)
		return
	}

	res, err := fh.service.CalcularPresupuesto(req)
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}

	json.NewEncoder(w).Encode(res)
}

// Handler para calcular interés compuesto
func (fh *FinanceHandler) CalcularInteresCompuesto(w http.ResponseWriter, r *http.Request) {
	var req dto.InteresCompuestoRequest
	if err := json.NewDecoder(r.Body).Decode(&req); err != nil {
		http.Error(w, "Error en la solicitud", http.StatusBadRequest)
		return
	}

	res, err := fh.service.CalcularInteresCompuesto(req)
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}

	json.NewEncoder(w).Encode(res)
}

// Handler para la tabla de amortización
func (fh *FinanceHandler) GenerarTablaAmortizacion(w http.ResponseWriter, r *http.Request) {
	capitalInicial, _ := strconv.ParseFloat(r.URL.Query().Get("capitalInicial"), 64)
	tasaInteresAnual, _ := strconv.ParseFloat(r.URL.Query().Get("tasaInteresAnual"), 64)
	anios, _ := strconv.Atoi(r.URL.Query().Get("anios"))

	res, err := fh.service.GenerarTablaAmortizacion(capitalInicial, tasaInteresAnual, anios)
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}

	json.NewEncoder(w).Encode(res)
}
