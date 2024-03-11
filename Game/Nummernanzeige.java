/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author MR. Robot
 */
class Nummernanzeige
{
    private final int limit;
    private int wert;
    
    Nummernanzeige(final int anzeigeLimit){
        limit = anzeigeLimit;
        wert = 0;
    }
    /**
     * Liefern den aktuellen Wert als Zahl
     * @return Der aktuelle Wert. 
     */
    
    int gibWert()
    {
        return wert;
    }
    
    String gibAnzeigewert()
    {
        if (wert < 10){
            return "0" + wert;
        }
    else {
        return "" + wert;
        }
    }
    
    void setzeWert(final int ersatzwert){
        if (ersatzwert >= 0 && ersatzwert < limit){
                wert = ersatzwert;
            
        }
    }
    void erhöhen(){
        wert = (wert + 1) % limit;
    }
}
