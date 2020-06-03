package ec.edu.ecole.enumerator;

public enum ParentescoEnum {

	PADRE("PADRE", "PADRE"), MADRE("MAMA", "MAMA"), TIO("TIO", "TIO"), ABUELO("ABUELO", "ABUELO"), HERMANO("HERMANO",
			"HERMANO"), PRIMO("PRIMO", "PRIMO"), OTRO("OTRO", "OTRO");

	private String codigo;
	private String descripcion;

	private ParentescoEnum(String codigo, String descripcion) {
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
