package main.com.dateformat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import main.com.business.Constants;

/**
 * This class adapts the LocalDate objects by implementing the XmlAdapter interface in order that
 * JaxB is capable of marshal and unmarshal them
 * 
 */
public class XmlDateAdapter extends XmlAdapter<String, Date>
{

    /**
     * Overrides the unmarshal method of the class XmlAdapter in order to parse a date of the type
     * LocalDate
     * 
     * @param date String
     * @return Date
     * @throws Exception
     */
    public Date unmarshal( String date ) throws Exception
    {
    	DateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT_FROM, Locale.ENGLISH);
        return format.parse(date);
    }

    /**
     * Overrides the marshal method of the class XmlAdapter in order to convert the passed date to
     * an String
     *
     * @param date Date
     * @return String
     * @throws Exception
     */
    public String marshal( Date date ) throws Exception
    {
    	DateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT_TO, Locale.ENGLISH);
        return format.format(date);
    }

}

