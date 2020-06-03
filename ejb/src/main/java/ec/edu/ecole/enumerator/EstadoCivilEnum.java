package ec.edu.ecole.enumerator;

public enum EstadoCivilEnum {

	SOLTERO("SOLTERO/A", "SOLTERO/A"), CASADO("CASADO/A", "CASADO/A"), DIVORSIADO("DIVORSIADO/A",
			"DIVORSIADO/A"), VIUDO("VIUDO/A", "VIUDO/A");

	private String codigo;
	private String descripcion;

	private EstadoCivilEnum(String codigo, String descripcion) {
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
