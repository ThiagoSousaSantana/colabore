package br.com.colabore.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {
    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public static String converteData(Date data) {
        if (data != null) {
            var formatter = new SimpleDateFormat(DATE_FORMAT);
            try {
                return (formatter.format(data));
            } catch (Exception e) {
                return "Erro na converssão da data: " + e.getLocalizedMessage();
            }
        }
        return "";
    }

}
