package br.com.controlealuno.util;

import java.io.Serializable;

public class StringUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	public static String leftLike(String query) {
		return "%".concat(query);
	}

	public static String rightLike(String query) {
		return query.concat("%");
	}

	public static String leftAndRightLike(String query) {
		return rightLike(leftLike(query));
	}
	
	/**
	 * Insere o formato 99.999.999-9
	 * @param rg
	 * @return
	 */
	public static String formatRG(String rg){
		return rg.substring(0,2).concat(".").concat(rg.substring(2,5)).concat(rg.substring(5,8)).concat("-").concat(rg.substring(8,9));
	}
}