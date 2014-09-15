package be.vdab.entities;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lok1109
 */
public class SterrenBeeld {

    public static final String BOOGSCHUTTER = "boogschutter";
    public static final String KREEFT = "kreeft";
    public static final String LEEUW = "leeuw";
    public static final String MAAGD = "maagd";
    public static final String RAM = "ram";
    public static final String SCHORPIOEN = "schorpioen";
    public static final String STEENBOK = "steenbok";
    public static final String STIER = "stier";
    public static final String TWEELING = "tweeling";
    public static final String VISSEN = "vissen";
    public static final String WATERMAN = "waterman";
    public static final String WEEGSCHAAL = "weegschaal";
    public final String naam;

    public SterrenBeeld(Date datum) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(datum);
        final int maand = calendar.get(Calendar.MONTH);
        final int dag = calendar.get(Calendar.DAY_OF_MONTH);
        switch (maand) {
            case Calendar.JANUARY:
                naam = dag >= 21 ? WATERMAN : STEENBOK;
                break;
            case Calendar.FEBRUARY:
                naam = dag >= 20 ? VISSEN : WATERMAN;
                break;
            case Calendar.MARCH:
                naam = dag >= 21 ? RAM : VISSEN;
                break;
            case Calendar.APRIL:
                naam = dag >= 21 ? STIER : RAM;
                break;
            case Calendar.MAY:
                naam = dag >= 21 ? TWEELING : STIER;
                break;
            case Calendar.JUNE:
                naam = dag >= 22 ? KREEFT : TWEELING;
                break;
            case Calendar.JULY:
                naam = dag >= 24 ? LEEUW : KREEFT;
                break;
            case Calendar.AUGUST:
                naam = dag >= 24 ? MAAGD : LEEUW;
                break;
            case Calendar.SEPTEMBER:
                naam = dag >= 24 ? WEEGSCHAAL : MAAGD;
                break;
            case Calendar.OCTOBER:
                naam = dag >= 24 ? SCHORPIOEN : WEEGSCHAAL;
                break;
            case Calendar.NOVEMBER:
                naam = dag >= 23 ? BOOGSCHUTTER : SCHORPIOEN;
                break;
            default:
                naam = dag >= 23 ? STEENBOK : BOOGSCHUTTER;
        }
    }
    public String getNaam() {
        return naam;
    }
}
