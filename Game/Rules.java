import static java.lang.Math.abs; // Absolutwert
import static java.lang.Math.max; // Maximum zweier Zahlen

/**
 * Diese klasse prüft gültigkeit von Zügen.
 * das ist für Objekten.
 * @author Sergi Koniashvili und Thomas Röfer
 */

class Rules
{
    /** es zeichnet X Koordinat */
    private final int centerX;
    /** es zeichnet X Koordinat */
    private final int centerY;

    /**
     * Erzeugt eine neue Regel-Objekt.
     * @param x  Die x-Koordinate der Mitte beider Quadrate, also des Spielfelds.
     * @param y  Die y-Koordinate der Mitte beider Quadrate, also des Spielfelds. 
     */
    Rules(final int x, final int y)
    {
        centerX = x;
        centerY = y;
    }

    /**
     *überpruft, ob ein Zug legal ist.
     *@param object das Object, das den zug ausFühren soll;
     *@param dirX,das x-Koordinate  darf nur -1,0,1 sein
     *@param dirX,das x-Koordinate  darf nur -1,0,1 sein
     *@param return darf oder nicht diese bewegung gemacht werden?
     */
    boolean isLegal(final GameObject object, final int dirX, final int dirY)
    {
        //es ist nicht erlaubt, sich nicht zu bewegen.
        if (dirX == 0 && dirY == 0) {
            return false;
        }
        
        //es darf nur entweder in x- oder in y- Rivchtungen gelaufen werden. 
        if (dirX != 0 && dirY != 0) {
            return false;
        }

        //schrite nicht große als 1 darf
        if (abs(dirX) > 1 || abs(dirY) > 1) {
            return false;
        }

        //es erlaubt nur demselber Quadrat zu bleiben
        final int fromLevel = maxAbs(object.getX(), object.getY());
        final int toLevel = maxAbs(object.getX() + dirX, object.getY() + dirY);
        if (fromLevel == toLevel) {
            return true;
        }

         // Ab hier geht es um den Wechsel zwischen Quadraten (Leveln).
         // Ein Wechsel ist nur in der Mitte einer Kante erlaubt.
        if (object.getX() != centerX && object.getX() != centerY) {
            return false;
        }


        
        final int outerLevel = maxAbs(fromLevel, toLevel);
        return outerLevel == 2;
    }
        /**
     *Diese method bestimt, auf welche Qzadrat sich eine Position befindet.
     *@param dirX,das x-Koordinate  darf nur -1,0,1 sein
     *@param dirX,das x-Koordinate  darf nur -1,0,1 sein
     *@param return darf oder nicht diese bewegung gemacht werden?
     */

    private int maxAbs(final int x, final int y)
    {
        return max(abs(x - centerX), abs(y - centerY));
    }
}