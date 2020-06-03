package ec.edu.ecole.enums;

/**
 * Fecha de creacion: 21 sep. 2017
 *
 * @author joffre.avendanio
 *
 */
public enum ParametrosSubCompEnum {

	D1_ASIGNATURA("D1_ASIGNATURA"), D1_PARALELO("D1_PARALELO"), D1_AULA("D1_AULA"), D3_TIPO("D3_TIPO"),
	D3_NOMBRE("D3_NOMBRE"), D3_META("D3_META"), D3_OBSERVACION("D3_OBSERVACION"), D4_ASIGNATURA("D4_ASIGNATURA"),
	D4_PARARLELO("D4_PARARLELO"), D4_LUGAR("D4_LUGAR"), D5_ASIGNATURA("D5_ASIGNATURA"), D5_PARARLELO("D5_PARARLELO"),
	D5_LUGAR("D5_LUGAR"), D6_ASIGNATURA("D6_ASIGNATURA"), D6_PARARLELO("D6_PARARLELO"), D6_ACUERDO("D6_ACUERDO"),
	D6_EMPRESA("D6_EMPRESA"), D8_ESTUDIANTE("D8_ESTUDIANTE"), D8_TRABAJO("D8_TRABAJO"), D9_CODIGO("D9_CODIGO"),
	D9_NOMBRE("D9_NOMBRE"), D10_TIPO("D10_TIPO"), D10_CODIGO("D10_CODIGO"), D10_NOMBRE("D10_NOMBRE"),
	D10_AULA("D10_AULA"), D11_PROGRAMA("D11_PROGRAMA"), D11_CODIGO("D11_CODIGO"), D11_PROYECTO("D11_PROYECTO"),
	D12_TIPO("D12_TIPO"), D12_DESCRIPCION("D12_DESCRIPCION"), D13_TIPO("D13_TIPO"), D14_ASIGNATURA("D14_ASIGNATURA"),
	D14_AULA("D14_AULA"), D15_DESCRIPCION("D15_DESCRIPCION"), I1_INVESTIGACION("I1_INVESTIGACION"),
	I1_PARTICIPACION("I1_PARTICIPACION"), I1_CODIGO("I1_CODIGO"), I1_PROYECTO("I1_PROYECTO"), I3_TIPO("I3_TIPO"),
	I3_DESCRIPCION("I3_DESCRIPCION"), I5_ESTUDIANTE("I5_ESTUDIANTE"), I5_NOMBRE("I5_NOMBRE"), I6_AMBITO("I6_AMBITO"),
	I6_TIPO("I6_TIPO"), I6_CODIGO("I6_CODIGO"), I6_PROYECTO("I6_PROYECTO"), I7_AMBITO("I7_AMBITO"),
	I7_PARTICIPACION("I7_PARTICIPACION"), I7_NOMBRE("I7_NOMBRE"), I8_TIPO("I8_TIPO"), I8_DESCRIPCION("I8_DESCRIPCION"),
	I9_RESULTADO("I9_RESULTADO"), I9_DESCRIPCION("I9_DESCRIPCION"), I9_PUBLICACION("I9_PUBLICACION"),
	I11_CODIGO("I11_CODIGO"), I11_NOMBRE("I11_NOMBRE"), I12_PRESTACION("I12_PRESTACION"),
	I12_DESCRIPCION("I12_DESCRIPCION"), G1_CARGO("G1_CARGO"), G2_CARGO("G2_CARGO"), G3_AMBITO("G3_AMBITO"),
	G3_TIPO("G3_TIPO"), G4_CARGO("G4_CARGO"), G4_DESCRIPCION("G4_DESCRIPCION"), G5_TIPO("G5_TIPO"),
	G5_DESCRIPCION("G5_DESCRIPCION"), G7_CARRERA("G7_CARRERA"), G7_DESCRIPCION("G7_DESCRIPCION"), G12_TIPO("G12_TIPO"),
	G12_DESCRIPCION("G12_DESCRIPCION"), G6_TIPO("G6_TIPO"), G6_DESCRIPCION("G6_DESCRIPCION"), G14_TIPO("G14_TIPO"),
	G14_DESCRIPCION("G14_DESCRIPCION");

	private final String codigoParametro;

	ParametrosSubCompEnum(String codigoParametro) {
		this.codigoParametro = codigoParametro;
	}

	public String getCodigoParametro() {
		return codigoParametro;
	}

}
