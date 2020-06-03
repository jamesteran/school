package ec.edu.ecole.enums;
/**
 * 
 */

/**
 * @author 
 *
 */
public enum AccionesUtilEnum {

	C("Crear"), R("Leer"), U("Actualizar"), D("ELiminar"), N("Sin Cambios");

	private String value;

	private AccionesUtilEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
