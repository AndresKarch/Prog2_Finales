package dto

// DTO para presupuesto mensual
type PresupuestoRequest struct {
	Ingresos []float64 `json:"ingresos"`
	Gastos   []float64 `json:"gastos"`
}

type PresupuestoResponse struct {
	Balance float64 `json:"balance"`
}

// DTO para interés compuesto
type InteresCompuestoRequest struct {
	CapitalInicial  float64 `json:"capitalInicial"`
	TasaInteresAnual float64 `json:"tasaInteresAnual"`
	Anios           int     `json:"anios"`
}

type InteresCompuestoResponse struct {
	MontoTotal float64 `json:"montoTotal"`
}

// DTO para amortización
type AmortizacionEntry struct {
	Anio       int     `json:"anio"`
	Interes    float64 `json:"interes"`
	SaldoFinal float64 `json:"saldoFinal"`
}

type AmortizacionResponse struct {
	Amortizacion []AmortizacionEntry `json:"amortizacion"`
}
