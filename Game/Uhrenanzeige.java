/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author MR. Robot
 */
class Uhrenanzeige
{
    /** Die Anzeige für Stunden. */
    private final Nummernanzeige stunden;

    /** Die Anzeige für Minuten. */
    private final Nummernanzeige minuten;

    /** Die eigentliche grafische Darstellung. */
    private final Zeitanzeige zeitanzeige = new Zeitanzeige();

    /**
     * Konstruktor für eine Instanz der Uhrenanzeige.
     * Mit diesem Konstruktor wird die Anzeige auf 00:00 initialisiert.
     */
    Uhrenanzeige()
    {
        stunden = new Nummernanzeige(24);
        minuten = new Nummernanzeige(60);
        anzeigeAktualisieren();
    }

    /**
     * Konstruktor für eine Instanz der Uhrenanzeige.
     * Mit diesem Konstruktor wird die Anzeige auf den Wert
     * initialisiert, der durch 'stunde' und 'minute'
     * definiert ist.
     * @param stunde Die Stunde der Uhrzeit.
     * @param minute Die Minute der Uhrzeit.
     */
    Uhrenanzeige(final int stunde, final int minute)
    {
        stunden = new Nummernanzeige(24);
        minuten = new Nummernanzeige(60);
        setzeUhrzeit(stunde, minute);
    }

    /**
     * Aktualisiere die Anzeige aus den intern gespeicherten Werten für
     * Stunden und Minuten.
     */
    private void anzeigeAktualisieren()
    {
        zeitanzeige.zeige(stunden.gibAnzeigewert() + ":" + minuten.gibAnzeigewert());
    }

    /**
     * Stellen der Anzeige auf den Wert, der durch 'stunde' und
     * 'minute' definiert ist.
     * @param stunde Die Stunde der Uhrzeit.
     * @param minute Die Minute der Uhrzeit.
     */
    void setzeUhrzeit(final int stunde, final int minute)
    {
        stunden.setzeWert(stunde);
        minuten.setzeWert(minute);
        anzeigeAktualisieren();
    }

    /**
     * Lasse die Uhr eine Minute weiterzählen.
     */
    void taktsignalGeben()
    {
        minuten.erhöhen();
        if (minuten.gibWert() == 0) 
        {
            stunden.erhöhen();
        }
        anzeigeAktualisieren();
    }
}