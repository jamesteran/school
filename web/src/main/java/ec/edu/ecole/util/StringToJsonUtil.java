/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ecole.util;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Fecha de creacion: 7 abr. 2017
 *
 * @author guido.guerrero
 *
 */
@Deprecated
public class StringToJsonUtil {
	/**
	 * Se envía un parametro de tipo object
	 * 
	 * @param objeto
	 *            recibe una entity para convertir la dupla campo:valor en json;
	 *            return StringToJsonUtil.stringToJ(this);
	 * 
	 *            donde this es una clase entity
	 */
	public static String stringToJ(Object objeto) {
		ArrayList<String> list = new ArrayList<String>();
		toString(objeto, objeto.getClass(), list);
		return "{" + list.toString().replace("[", "").replace("]", "") + "}";
	}

	/*
	 * 
	 * 
	 */
	public static boolean isValidJSON(final String json) {
		boolean valid = false;
		try {
			final JsonParser parser = new ObjectMapper().getJsonFactory().createJsonParser(json);
			while (parser.nextToken() != null) {
			}
			valid = true;
		} catch (JsonParseException jpe) {
			jpe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return valid;
	}

	private static void toString(Object objeto, Class<?> clase, List<String> listaCampos) {
		String sTipo;

		Field f[] = clase.getDeclaredFields();
		AccessibleObject.setAccessible(f, true);
		for (int i = 0; i < f.length; i++) {
			try {
				sTipo = f[i].getType().toString();
				if (!Modifier.isFinal(f[i].getModifiers())
						|| (sTipo.startsWith("class") && !sTipo.endsWith(String.class.getCanonicalName())))
					listaCampos.add("\"" + f[i].getName() + "\":\"" + f[i].get(objeto) + "\"");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		if (clase.getSuperclass().getSuperclass() != null) {
			toString(objeto, clase.getSuperclass(), listaCampos);
		}
	}
}
