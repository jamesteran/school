package ec.edu.ecole.enums;

public enum IngresoHorarioEnum {
	DIA("Fecha"), RANGO("Rango de Fechas");
	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	IngresoHorarioEnum(String texto) {
		this.texto = texto;
	}

}
