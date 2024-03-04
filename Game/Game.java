import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Eine Klasse, die drei Klassenmethoden kapselt, die für Spiele benötigt werden.
 *
 * @author Thomas Röfer
 */
abstract class Game
{
    /**
     * Warten auf und Liefern der nächsten gedrückten Taste.
     * @return Ein Tastencode, wie sie in der Klasse {@link java.awt.event.KeyEvent}
     *         definiert sind.
     */
    static int getNextKey()
    {
        return GameObject.Canvas.getInstance().getNextKey();
    }

    /**
     * Warten für eine bestimmte Zeit.
     * @param millis Die Anzahl Millisekunden, die gewartet wird. Die tatsächliche
     *         Wartezeit kann etwas länger sein.
     */
    static void sleep(final int millis)
    {
        try {
            Thread.sleep(millis);
        }
        catch (final InterruptedException e) {
            // Ignorieren
        }
    }

    /**
     * Abspielen einer Sound-Datei.
     * @param fileName Der Name der Datei. Sie wird im Unterverzeichnis "sounds"
     *         gesucht. Wenn keine Dateiendung angegeben wurde, wird ".wav"
     *         angehängt.
     * @throws IllegalArgumentException Die Datei konnte nicht gefunden werden
     *         oder hat kein akzeptiertes Format.
     */
    static void playSound(final String fileName)
    {
        final int period = fileName.lastIndexOf('.');
        final int separator = fileName.lastIndexOf(File.separator);
        final String completeName = fileName + (period > separator ? "" : ".wav");
        try {
            final Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(
                    new BufferedInputStream(Jar.getInputStream("sounds"
                    + File.separator + completeName))));
            clip.addLineListener(e -> {
                if (e.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
            clip.start();
        }
        catch (final IllegalArgumentException e) {
            // Wenn es keine Soundkarte gibt, erzeuge Ausgabe statt Ausnahme.
            System.err.println("Die Sounddatei '" + completeName
                    + "' konnte nicht abgespielt werden.");
        }
        catch (final IOException e) {
            throw new IllegalArgumentException("Die Sounddatei '" + completeName
                    + "' konnte nicht geladen werden.");
        }
        catch (final UnsupportedAudioFileException e) {
            throw new IllegalArgumentException("Die Sounddatei '" + completeName
                    + "' hat kein unterstütztes Format.");
        }
        catch (final LineUnavailableException e) {
            // Zu viele Sounds gleichzeitig: Diesen einfach nicht abspielen.
        }
    }

    /**
     * Die Klasse enthält eine Methode zum Laden von Dateien, die auch in
     * jar-Archiven funktioniert.
     */
    static class Jar
    {
        /**
         * Liefern eines Datenstroms zu einem Dateinamen. Dies funktioniert sowohl
         * direkt, als auch aus einem jar-Archiv heraus.
         * @param fileName Der Name des Datenstroms, der geliefert werden soll.
         * @throws FileNotFoundException Zu dem Namen gibt es keinen Datenstrom.
         */
        static InputStream getInputStream(String fileName)
                throws FileNotFoundException
        {
            // Ressourcen nutzen / als Verzeichnistrenner, weshalb \ ersetzt wird.
            if (File.separatorChar == '\\') {
                fileName = fileName.replaceAll("\\\\", "/");
            }

            final InputStream stream = Game.class.getResourceAsStream(fileName);
            if (stream != null) {
                return stream;
            }
            else {
                throw new FileNotFoundException("Kann Ressource '" + fileName
                        + "' nicht finden");
            }
        }
    }
}
