package pe.edu.upc.RsReport.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Paolo Ortega on 22/08/2016.
 */
public class DateFormatter {
    static String[] rutaAMes = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "setptiembre", "octubre", "noviembre", "diciembre"};

    public static Date getDate(String dateInString, String pattern) {
        if (dateInString == null) return null;
        if (pattern == null) pattern = "dd-M-yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = df.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getFormatDate(Date date, String pattern) {
        if (date == null) date = new Date();
        if (pattern == null) pattern = "dd-M-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String getCurrentMonth(String newPattern) {
        String pattern = "M";
        if (newPattern != null && !newPattern.isEmpty()) pattern = newPattern;
        Calendar cal = Calendar.getInstance();
        return rutaAMes[Integer.parseInt(new SimpleDateFormat(pattern).format(cal.getTime())) - 1];
    }

    public static String getMonthDesc(Integer index) {
        if (index == null) return null;
        return rutaAMes[index - 1];
    }
}
