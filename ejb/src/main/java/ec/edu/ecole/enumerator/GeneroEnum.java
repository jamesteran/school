package ec.edu.ecole.enumerator;

public enum GeneroEnum {

	MASCULINO("MASCULINO", "MASCULINO"),
	FEMENINO("FEMENINO", "FEMENINO");

	private String codigo;
	private String descripcion;

	private GeneroEnum(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
