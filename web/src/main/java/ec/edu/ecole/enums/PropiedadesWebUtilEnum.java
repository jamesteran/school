/**
 * 
 */
package ec.edu.ecole.enums;

/**
 * @author 
 *
 */
public enum PropiedadesWebUtilEnum {
	LABELS("lbl"), MESSAGES("msg"), TEMPLATE("tmpl");

	String value;

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	private PropiedadesWebUtilEnum(String value) {
		this.value = value;
	}

}
