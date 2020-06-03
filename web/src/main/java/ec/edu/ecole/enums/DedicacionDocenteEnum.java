package ec.edu.ecole.enums;

/**
 * Fecha de creacion: 13 oct. 2017
 *
 * @author jaime.teran
 *
 */
public enum DedicacionDocenteEnum {

	EXCLUSIVA_COMPLETA("EXCLUSIVA O COMPLETA"), SEMIEXCLUSIVA_MEDIOTIEMPO("SEMI EXCLUSIVA O MEDIO TIEMPO"),
	TIEMPO_PARCIAL("TIEMPO PARCIAL");

	private final String dedicacionDocente;

	DedicacionDocenteEnum(String dedicacionDocente) {
		this.dedicacionDocente = dedicacionDocente;
	}

	public String getDedicacionDocente() {
		return dedicacionDocente;
	}

}
