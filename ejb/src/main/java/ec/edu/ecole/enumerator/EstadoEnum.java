package ec.edu.ecole.enumerator;

public enum EstadoEnum {

	INACTIVO(0, "Inactivo"),
	ACTIVO(1, "Activo"),
	DESIERTO(2,"Desierto");

	private int codigo;
	private String descripcion;

	private EstadoEnum(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
