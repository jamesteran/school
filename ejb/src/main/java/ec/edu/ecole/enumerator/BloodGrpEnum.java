package ec.edu.ecole.enumerator;

public enum BloodGrpEnum {

	O_POS("O+", "O+"), O_NEG("O-", "O-"), A_POS("A+", "A+"), A_NEG("A-", "A-"), B_POS("B+", "B+"), B_NEG("B-",
			"B-"), AB_POS("AB+", "AB+"), AB_NEG("AB-", "AB-");

	private String codigo;
	private String descripcion;

	private BloodGrpEnum(String codigo, String descripcion) {
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
