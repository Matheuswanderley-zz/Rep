package br.com.alugueAgora.util;

import org.springframework.util.StringUtils;

public class ValueUtil {

	private ValueUtil() {
	}

	public static boolean checkObjectsIsNotNullOrNotEmpty(Object... listObject) {

		for (Object object : listObject) {

			if (object != null) {

				if (object instanceof Long) {
					if (!object.equals(0L)) {
						return true;
					}
				}

				if (object instanceof String) {
					if (!StringUtils.isEmpty((String) object)) {
						return true;
					}
				}
			}

		}

		return false;
	}

	public static void main(String[] args) {

		String s = "";
		String s1 = null;
		Long l = null;
		Long l1 = 0L;

		System.out.println("A lista de objectos tem itens vazios? " + checkObjectsIsNotNullOrNotEmpty(s, s1, l, l1));

	}
}
