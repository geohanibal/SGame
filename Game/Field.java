/**
 * Diese Klasse repräsentiert ein Spielfeld. Ihr Konstruktor bekommt dieses als
 * String-Array übergeben.
 *
 * @author Thomas Röfer
 */
class Field
{
    /**
     * Die Dateinamen der Bodengitterelemente, die direkt mit einer
     * Rotation 0 verwendet werden können. Der Index ergibt sich
     * aus der Summe der folgenden Zahlen:
     * 1: In Richtung 0 (+1, 0) gibt es eine Verbindung.
     * 2: In Richtung 1 (0, +1) gibt es eine Verbindung.
     * 4: In Richtung 2 (-1, 0) gibt es eine Verbindung.
     * 8: In Richtung 3 (0, -1) gibt es eine Verbindung.
     */
    private static final String[] NEIGHBORHOOD_TO_FILENAME = {
        "grass",
        "path-e-0",
        "path-e-1",
        "path-l-0",
        "path-e-2",
        "path-i-0",
        "path-l-1",
        "path-t-1",
        "path-e-3",
        "path-l-3",
        "path-i-1",
        "path-t-0",
        "path-l-2",
        "path-t-3",
        "path-t-2",
        "path-x"
    };

    /**
     * Die Feldbeschreibung. Jede zweite Spalte und Zeile enthält die
     * eigentlichen Zellen. Dazwischen sind die Nachbarschaften
     * vermerkt.
     */
    private final String[] field;

    /**
     * Erzeugt ein neues Feld.
     * @param field Die Feldbeschreibung. Jede zweite Spalte und Zeile
     *         enthält die eigentlichen Zellen. Dazwischen sind die
     *         Nachbarschaften vermerkt.
     */
    Field(final String[] field)
    {
        this.field = field;

        for (int y = 0; y < field.length; y += 2) {
            for (int x = 0; x < field[y].length(); x += 2) {
                new GameObject(x / 2, y / 2, 0, NEIGHBORHOOD_TO_FILENAME[getNeighborhood(x, y)]);
            }
        }
    }

    /**
     * Liefert ein Zeichen der Feldbeschreibung.
     * @param x Die horizontale Koordinate des Zeichens, das
     *         zurückgeliefert wird.
     * @param y Die vertikale Koordinate des Zeichens, das
     *         zurückgeliefert wird.
     * @return Das Zeichen an der entsprechenden Zelle oder ein
     *         Leerzeichen, wenn die Koordinaten außerhalb der
     *         Beschreibung liegen.
     */
    private char getCell(final int x, final int y)
    {
        if (x >= 0 && y >= 0 && y < field.length && x < field[y].length()) {
            return field[y].charAt(x);
        }
        else {
            return ' ';
        }
    }

    /**
     * Liefert die Nachbarschafts-Signatur einer Zelle der
     * Feldbeschreibung zurück.
     * @param x Die horizontale Koordinate der Zelle, deren
     *         Nachbarschafts-Signatur zurückgeliefert wird.
     * @param y Die vertikale Koordinate der Zelle, deren
     *         Nachbarschafts-Signatur zurückgeliefert wird.
     * @return Die Signatur als Summe der Zahlen 1 (x+1, y),
     *         2 (x, y+1), 4 (x-1, y) und 8 (x, y-1), wenn in
     *         der jeweilen Richtung eine Verbindung zum Nachbarn
     *         besteht.
     */
    private int getNeighborhood(final int x, final int y)
    {
        // Die (x, y)-Versätze für die einzelnen Prüfrichtungen
        final int[][] neighbors = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // Anfangs ist die Nachbarschafts-Signatur leer.
        int neighborhood = 0;

        // Variable zum Hochzählen der Signatur-Komponenten
        int bit = 1;

        // Signatur berechnen und zurückgeben
        for (final int[] offsets : neighbors) {
            if (getCell(x + offsets[0], y + offsets[1]) != ' ') {
                neighborhood += bit;
            }
            bit *= 2;
        }
        return neighborhood;
    }

    /** Ein Testfall, der alle Nachbarschaften enthält. */
    static void test()
    {
        new GameObject.Canvas(5, 5, 96, 96);
        new Field(new String[] {
            "O-O-O-O  ",
            "|   |    ",
            "O O-O-O O",
            "| | | | |",
            "O-O-O-O-O",
            "| | | | |",
            "O O-O-O O",
            "    |   |",
            "O-O-O-O-O"
        });
    }
}
