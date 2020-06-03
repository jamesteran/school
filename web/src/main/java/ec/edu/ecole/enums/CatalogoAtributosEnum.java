package ec.edu.ecole.enums;

/**
 * Fecha de creacion: 21 sep. 2017
 *
 * @author joffre.avendanio
 *
 */
public enum CatalogoAtributosEnum {

	D10_TIPO("TIPO_D10"), D12_TIPO("TIPO_D12"), TIPO_D13("TIPO_D13"), D3_TIPO("TIPO_D3"), G3_TIPO("TIPO_G3"),
	G5_TIPO("TIPO_G5"), G6_TIPO("TIPO_G6"), G7_TIPO("TIPO_G7"), I12_TIPO("TIPO_I12"), I3_TIPO("TIPO_I3"),
	I6_TIPO("TIPO_I6"), I7_TIPO("TIPO_I7"), G1_CARGO("CARGO_G1"), G2_CARGO("CARGO_G2"), G3_AMBITO("AMBITO_G3"),
	G4_CARGO("CARGO_G4"), I6_AMBITO("AMBITO_I6"), I1_TIPO_INV("TIPO_INV_I1"), I1_TIPO_PAR("TIPO_PAR_I1"),
	I9_TIPO_PUB("TIPO_PUB_I9"), I9_TIPO_RES("TIPO_RES_I9");

	private final String codigoAtributo;

	CatalogoAtributosEnum(String codigoAtributo) {
		this.codigoAtributo = codigoAtributo;
	}

	public String getCodigoAtributo() {
		return codigoAtributo;
	}

}
