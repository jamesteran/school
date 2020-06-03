package ec.edu.ecole.enums;

/**
 * Fecha de creacion: 13 oct. 2017
 *
 * @author jaime.teran
 *
 */
public enum CategoriaDocenteEnum {

	HONORARIO("HONORARIO"), INVITADO("INVITADO"), OCACIONAL("OCACIONAL"), TITULAR_AGREGADO("TITULAR AGREGADO"),
	TITULAR_AUXILIAR("TITULAR AUXILIAR"), TITULAR_PRINCIPAL("TITULAR PRINCIPAL");

	private final String categoriaDocente;

	CategoriaDocenteEnum(String categoriaDocente) {
		this.categoriaDocente = categoriaDocente;
	}

	public String getCategoriaDocente() {
		return categoriaDocente;
	}

}
