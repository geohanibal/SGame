/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author MR. Robot
 */
class Mathe
{
    static int fakultät(final int n){
        if (n == 0)
        {
            return 1;
        }
        else{
            final int f = fakultät( n - 1);
            return n * f;
    }
  }
}
