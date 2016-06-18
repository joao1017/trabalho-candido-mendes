package br.com.controlealuno.util;

import java.text.SimpleDateFormat;

public class DateUtil {
	
	static final SimpleDateFormat formatUTIL = new SimpleDateFormat("dd/MM/yyyy");
	static final SimpleDateFormat formatSQL  = new SimpleDateFormat("yyyy-MM-dd");

	public static String formataDataParaString(java.sql.Date data){
		return formatUTIL.format(data);
	}
	
	public static String formataDataParaString(java.util.Date data){
		return formatUTIL.format(data);
	}
	
	public static java.sql.Date formataStringParaSqlDate(String data){
		java.sql.Date dataSQL = null;
		try{
			dataSQL = new java.sql.Date(formatUTIL.parse(data).getTime());
		}catch(Throwable cause){
			cause.printStackTrace();
		}
		
		return dataSQL;
	}
	
	public static java.util.Date formataStringParaUtilDate(String data){
		java.util.Date dataUTIL = null;
		try{
			dataUTIL = formatUTIL.parse(data);
		}catch(Throwable cause){
			cause.printStackTrace();
		}
		
		return dataUTIL;
	}
}