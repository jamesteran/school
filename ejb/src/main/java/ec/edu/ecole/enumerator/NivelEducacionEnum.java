package ec.edu.ecole.enumerator;

public enum NivelEducacionEnum {

	NO_TIENE("NO TIENE", "NO TIENE"), PRIMARIA("PRIMARIA", "PRIMARIA"), SECUNDARIA("SECUNDARIA",
			"SECUNDARIA"), TERCER_NIVEL("TERCER NIVEL", "TERCER NIVEL"), CUARTO_NIVEL("CUARTO NIVEL", "CUARTO NIVEL");

	private String codigo;
	private String descripcion;

	private NivelEducacionEnum(String codigo, String descripcion) {
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
