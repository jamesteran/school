package ec.edu.ecole.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

public final class FechaUtil {

	public static final Locale LOCALIDAD_ECUADOR = new Locale("ES", "EC");
	public static final String PATRON_FECHA_SIMPLE = "yyyy-MM-dd";
	public static final String PATRON_FECHA_SIMPLE_SLASH = "yyyy/MM/dd";
	public static final String PATRON_TIEMPO_SIMPLE = "HH:mm:ss.SSS";
	public static final String PATRON_TIEMPO_SIMPLE_SIN_SEGUNDO = "HH:mm";
	public static final String PATRON_TIEMPO_SIMPLE_SIN_MILISEGUNDO = "HH:mm:ss";
	public static final String PATRON_FECHA_COMPLETO = PATRON_FECHA_SIMPLE + " " + PATRON_TIEMPO_SIMPLE;
	public static final String PATRON_FECHA_COMPLETO_SIN_MILISEGUNDO = PATRON_FECHA_SIMPLE + " "
			+ PATRON_TIEMPO_SIMPLE_SIN_MILISEGUNDO;

	public static final SimpleDateFormat FORMATO_FECHA_SIMPLE = new SimpleDateFormat(PATRON_FECHA_SIMPLE,
			LOCALIDAD_ECUADOR);
	public static final SimpleDateFormat FORMATO_FECHA_SIMPLE_SLASH = new SimpleDateFormat(PATRON_FECHA_SIMPLE_SLASH,
			LOCALIDAD_ECUADOR);
	public static final SimpleDateFormat FORMATO_FECHA_COMPLETO = new SimpleDateFormat(PATRON_FECHA_COMPLETO,
			LOCALIDAD_ECUADOR);
	public static final SimpleDateFormat FORMATO_FECHA_COMPLETO_SIN_MILISEGUNDO = new SimpleDateFormat(
			PATRON_FECHA_COMPLETO_SIN_MILISEGUNDO, LOCALIDAD_ECUADOR);
	public static final SimpleDateFormat FORMTATO_TIEMPO = new SimpleDateFormat(PATRON_TIEMPO_SIMPLE,
			LOCALIDAD_ECUADOR);

	/**
	 * constructor
	 */
	private FechaUtil() {
	}

	/**
	 * Transforma tipo de dato fecha a cadena en un formato fecha tiempo
	 * (dd/MM/yyyy HH:mm)
	 * 
	 * @param fecha
	 * @return cadena en un formato fecha tiempo
	 */
	public static String formatoCompleto(Date fecha) {
		if (fecha == null) {
			return null;
		} else {
			return FORMATO_FECHA_COMPLETO.format(fecha);
		}
	}

	public static String formatoCompletoSinMilisegundo(Date fecha) {
		if (fecha == null) {
			return null;
		} else {
			return FORMATO_FECHA_COMPLETO_SIN_MILISEGUNDO.format(fecha);
		}
	}

	/**
	 * Transforma tipo de dato fecha a cadena en un formato fecha (dd/MM/yyyy)
	 * 
	 * @param fecha
	 * @return cadena en un formato fecha
	 */
	public static String formatoSimple(Date fecha) {
		if (fecha == null) {
			return null;
		} else {
			return FORMATO_FECHA_SIMPLE.format(fecha);
		}
	}

	/**
	 * Transforma tipo de dato fecha a cadena en un formato fecha (yyyy/MM/dd)
	 * 
	 * @param fecha
	 * @return cadena en un formato fecha
	 */
	public static String formatoSimpleFechaSlash(Date fecha) {
		if (fecha == null) {
			return null;
		} else {
			return FORMATO_FECHA_SIMPLE_SLASH.format(fecha);
		}
	}

	/**
	 * Transforma la fecha en texto separado con guiones bajos (underscore _)
	 * 
	 * @return
	 */
	public static String fechaActualUnderscore() {
		java.util.Date date = new java.util.Date();
		DateFormat fechaHora = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_mmm");
		return fechaHora.format(date);
	}

	/**
	 * 
	 * @param formato
	 *            por defecto dd-MM-yyyy HH:mm:ss
	 * @param fechaInicio
	 * @param fechaFin
	 * @param fechaIncioCom
	 * @param fechaFinCom
	 * @return true si hay interseccion
	 */
	public static Boolean seIntersecanFechas(String formato, Date fechaInicio, Date fechaFin, Date fechaIncioCom,
			Date fechaFinCom) {

		Boolean ban = Boolean.FALSE;
		/* caso 1.- iiff */
		if (fechaInicio.compareTo(fechaIncioCom) < 0 && fechaFin.compareTo(fechaIncioCom) > 0) {
			ban = Boolean.TRUE;
		}
		/* caso 2 */
		if (fechaInicio.compareTo(fechaIncioCom) < 0 && fechaFin.compareTo(fechaFinCom) > 0) {
			ban = Boolean.TRUE;
		}
		/* caso 3 */
		if (fechaInicio.compareTo(fechaIncioCom) > 0 && fechaFin.compareTo(fechaFinCom) < 0) {
			ban = Boolean.TRUE;
		}
		/* caso 4 */
		// fechaInicio.before(fechaIncioCom) && fechaFin.after(fechaFinCom)
		if (fechaInicio.compareTo(fechaFinCom) < 1 && fechaFin.compareTo(fechaFinCom) > 1) {
			ban = Boolean.TRUE;
		}

		/*   */
		if (fechaInicio.after(fechaIncioCom) && fechaInicio.before(fechaFinCom) && fechaFin.after(fechaFinCom)) {
			ban = Boolean.TRUE;
		}

		SimpleDateFormat formatComparacion = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		if (!StringUtils.isEmpty(formato)) {
			formatComparacion = new SimpleDateFormat(formato);
		}

		if (StringUtils.equals(formatComparacion.format(fechaInicio), formatComparacion.format(fechaIncioCom))
				&& fechaFin.before(fechaFinCom)) {
			ban = Boolean.TRUE;
		}

		if (StringUtils.equals(formatComparacion.format(fechaInicio), formatComparacion.format(fechaIncioCom))
				&& fechaFin.after(fechaIncioCom)) {
			ban = Boolean.TRUE;
		}

		if (StringUtils.equals(formatComparacion.format(fechaFin), formatComparacion.format(fechaFinCom))
				&& fechaInicio.before(fechaIncioCom)) {
			ban = Boolean.TRUE;
		}

		if (StringUtils.equals(formatComparacion.format(fechaFin), formatComparacion.format(fechaFinCom))
				&& fechaInicio.after(fechaIncioCom)) {
			ban = Boolean.TRUE;
		}

		/* caso 6.- cuando son iguales */
		if (StringUtils.equals(formatComparacion.format(fechaInicio), formatComparacion.format(fechaIncioCom))
				&& StringUtils.equals(formatComparacion.format(fechaFin), formatComparacion.format(fechaFinCom))) {
			ban = Boolean.TRUE;
		}

		return ban;
	}

	public Date obtenerDiaDeFecha(Date fecha, Calendar dia) {

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(fecha);
		cal.set(Calendar.DAY_OF_WEEK, dia.get(Calendar.DAY_OF_WEEK));
		return cal.getTime();

	}

	/**
	 * Transforma tipo de dato fecha de cadena a un formato fecha definido por
	 * el solicitante
	 * 
	 * @param fecha
	 *            en String
	 * @param formato
	 *            en el que se paso la fecha ejemplo "d/M/yyyy"
	 * @return formato Date
	 */
	public static Date obtenerFechaFormatoGenerico(String fecha, String formato) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat(formato);
		Date fechaFormateada = new Date();
		try {
			return fechaFormateada = formatoFecha.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaFormateada;
	}

	public static String obtenerFechaEnFormato(Date fecha, String formato, Locale locale) {

		if (null == locale) {
			locale = new Locale("es", "ES");
		}

		SimpleDateFormat formatoFecha = new SimpleDateFormat(formato, locale);

		return formatoFecha.format(fecha);
	}

	public static Boolean fechaEntrePeriodo(Date fechaEvaluada, Date fechaInicial, Date fechaFinal) {

		return fechaInicial.compareTo(fechaEvaluada) * fechaEvaluada.compareTo(fechaFinal) >= 0;

	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public static Double diferenciaFechasMinutos(Date fechaInicio, Date fechaFin) {
		long diff = fechaFin.getTime() - fechaInicio.getTime();
		return (double) (diff / (60 * 1000));

	}

	public static Date obtenerInicioDia(Date fecha) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date obtenerFinDia(Date fecha) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();

	}

	public static Boolean estaContenida(Date fecha, Date fechaInicio, Date fechaFin) {
		Interval interval = new Interval(new DateTime(fechaInicio), new DateTime(fechaFin));
		return interval.contains(new DateTime(fecha));
	}

	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public static List<Date> obtenerDiasEntreFechas(Date fechaInicio, Date fechaFin) {
		Set<Date> lstDias = new HashSet<>();
		Calendar iterador = Calendar.getInstance();
		iterador.setTime(fechaInicio);
		if (fechaInicio.before(fechaFin)) {
			while (iterador.getTime().before(fechaFin)) {
				lstDias.add(iterador.getTime());
				iterador.add(Calendar.DAY_OF_YEAR, 1);
			}
		}

		return new ArrayList<>(lstDias);

	}

	/**
	 * 
	 * @param dia
	 * @param diaDelaSemana
	 *            domingo 1, lunes 2
	 * @return
	 */
	public static Date obtenerDiaDelaSemanaAtrasDesde(Date dia, int diaDelaSemana) {

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setFirstDayOfWeek(diaDelaSemana);
		calendar.setTime(dia);

		while (diaDelaSemana != calendar.get(Calendar.DAY_OF_WEEK)) {
			calendar.add(Calendar.DAY_OF_YEAR, -1);
		}

		return calendar.getTime();
	}

	/**
	 * 
	 * @param dia
	 * @param diaDelaSemana
	 *            domingo 1, lunes 2
	 * @return
	 */
	public static Date obtenerDiaDelaSemanaSiguienteDesde(Date dia, int diaDelaSemana) {

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setFirstDayOfWeek(diaDelaSemana);
		calendar.setTime(dia);

		while (diaDelaSemana != calendar.get(Calendar.DAY_OF_WEEK)) {
			calendar.add(Calendar.DAY_OF_YEAR, +1);
		}

		return calendar.getTime();
	}

	public static Integer obtenerEdadAnios(Date fechaNacimiento, Date fechaLimite) {

		LocalDate fechaNacimientoFormato = new LocalDate(fechaNacimiento);
		LocalDate fechaLimiteFormato = new LocalDate(fechaLimite);
		Period period = new Period(fechaNacimientoFormato, fechaLimiteFormato, PeriodType.yearMonthDay());

		return period.getYears();
	}

}
