import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Diese Klasse zeigt eine Digitaluhr an, bei der sich die Zeit als
 * fünfstellige Zeichenkette setzen lässt.
 *
 * @author Thomas Röfer
 */
class Zeitanzeige extends Game
{
    /** Das Bild, in das gezeichnet wird. */
    private final BufferedImage bild = new BufferedImage(341, 131, BufferedImage.TYPE_INT_ARGB);

    /** Das Spielobjekt, das das Bild kapselt. */
    private final GameObject anzeige;

    /**
     * Erzeugt eine neu Zeitanzeige, die ein Fester öffnet und einen
     * Digitalwecker darin anzeigt.
     */
    Zeitanzeige()
    {
        new GameObject.Canvas(1, 1, 566, 332);
        new GameObject(0, 0, 0, "Wecker");
        anzeige = new GameObject(0, 0, bild);
    }

    /**
     * Zeige eine neue Uhrzeit an.
     * @param zeit Die neue Uhrzeit als fünfstellige Zeichenkette.
     */
    void zeige(final String zeit)
    {
        final Graphics zeichenfläche = bild.getGraphics();

        // Hintergrund in dunkler Farbe löschen
        zeichenfläche.setColor(new Color(23, 22, 20));
        zeichenfläche.fillRect(0, 0, bild.getWidth(), bild.getHeight());

        // Zeichenkette in Grün und großer Schrift ausgeben
        zeichenfläche.setColor(Color.GREEN);
        zeichenfläche.setFont(new Font("Monospaced", Font.BOLD, 110));
        zeichenfläche.drawString(zeit, 5, 120);

        // Bild neu setzten, wodurch ein Neuzeichnen angestoßen wird
        anzeige.setImage(bild);
    }

    /**
     * Erzeugt die Uhr und lässt sie laufen. Aktuell läuft sie 60-mal zu
     * schnell.
     * @param stunden Die Stundenzahl der Anfangsuhrzeit.
     * @param minuten Die Minutenzahl der Anfangsuhrzeit.
     */
    static void main(final int stunden, final int minuten)
    {
        final Uhrenanzeige uhr = new Uhrenanzeige(stunden, minuten);
        while (true) {
            sleep(1000); // Sollte eigentlich 60000 sein!
            uhr.taktsignalGeben();
        }
    }
}
