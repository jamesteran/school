package ec.edu.ecole.enumerator;

public enum EstadoStringEnum {

	INACTIVO("I", "Inactivo"),
	ACTIVO("A", "Activo");

	private String codigo;
	private String descripcion;

	private EstadoStringEnum(String codigo, String descripcion) {
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
