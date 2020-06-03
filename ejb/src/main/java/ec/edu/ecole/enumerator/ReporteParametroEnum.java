package ec.edu.ecole.enumerator;

public enum ReporteParametroEnum {

	
	TXT_NOMBRE("TXT_NOMBRE"), 
	FEC_INSCRIPCION("FEC_INSCRIPCION"), 
	TXT_DOMICILIO("TXT_DOMICILIO"), 
	TXT_OFERTA("TXT_OFERTA"), 
	TXT_PROVINCIA("TXT_PROVINCIA"), 
	TXT_CANTON("TXT_CANTON"),
	TXT_PARROQUIA("TXT_PARROQUIA"), 
	TXT_HORARIO("TXT_HORARIO"),
	TXT_MODALIDAD("TXT_MODALIDAD"), 
	TXT_JORNADA("TXT_JORNADA"),
	TXT_PERIODO("TXT_PERIODO"), 
	TXT_SEDE("TXT_SEDE"),
	TXT_TIPO_INSTITUCION("TXT_TIPO_INSTITUCION"),
	LOGO("LOGO"),
	TXT_IDENTIFICACION("TXT_IDENTIFICACION"),
	TXT_INSTITUCION("TXT_INSTITUCION"),
	TXT_PARALELO("TXT_PARALELO");
	

	private String descripcion;

	private ReporteParametroEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
