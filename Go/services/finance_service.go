package services

import (
	"errors"
	"examen_final_golang/dto"
	"math"
)

type FinanceService struct{}

func NewFinanceService() *FinanceService {
	return &FinanceService{}
}

// Calcular presupuesto mensual
func (fs *FinanceService) CalcularPresupuesto(req dto.PresupuestoRequest) (dto.PresupuestoResponse, error) {
	var ingresosTotal, gastosTotal float64

	for _, ingreso := range req.Ingresos {
		if ingreso < 0 {
			return dto.PresupuestoResponse{}, errors.New("los ingresos no pueden ser negativos")
		}
		ingresosTotal += ingreso
	}

	for _, gasto := range req.Gastos {
		if gasto < 0 {
			return dto.PresupuestoResponse{}, errors.New("los gastos no pueden ser negativos")
		}
		gastosTotal += gasto
	}

	balance := ingresosTotal - gastosTotal
	return dto.PresupuestoResponse{Balance: balance}, nil
}

// Calcular interés compuesto
func (fs *FinanceService) CalcularInteresCompuesto(req dto.InteresCompuestoRequest) (dto.InteresCompuestoResponse, error) {
	if req.CapitalInicial < 0 || req.TasaInteresAnual < 0 || req.Anios < 0 {
		return dto.InteresCompuestoResponse{}, errors.New("los valores no pueden ser negativos")
	}
	if req.TasaInteresAnual > 100 {
		return dto.InteresCompuestoResponse{}, errors.New("la tasa de interés debe estar entre 0 y 100")
	}

	montoTotal := req.CapitalInicial * math.Pow(1+(req.TasaInteresAnual/100), float64(req.Anios))
	return dto.InteresCompuestoResponse{MontoTotal: montoTotal}, nil
}

// Generar tabla de amortización
func (fs *FinanceService) GenerarTablaAmortizacion(capitalInicial float64, tasaInteresAnual float64, anios int) (dto.AmortizacionResponse, error) {
	if capitalInicial < 0 || tasaInteresAnual < 0 || anios < 0 {
		return dto.AmortizacionResponse{}, errors.New("los valores no pueden ser negativos")
	}
	if tasaInteresAnual > 100 {
		return dto.AmortizacionResponse{}, errors.New("la tasa de interés debe estar entre 0 y 100")
	}

	var amortizacion []dto.AmortizacionEntry
	saldo := capitalInicial

	for i := 1; i <= anios; i++ {
		interes := saldo * (tasaInteresAnual / 100)
		saldo += interes
		amortizacion = append(amortizacion, dto.AmortizacionEntry{
			Anio:       i,
			Interes:    interes,
			SaldoFinal: saldo,
		})
	}

	return dto.AmortizacionResponse{Amortizacion: amortizacion}, nil
}
