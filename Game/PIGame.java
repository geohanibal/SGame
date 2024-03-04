// Importieren der VK_*-Tastenkonstanten
import static java.awt.event.KeyEvent.*;

/**
 * Dies ist die Hauptklasse eines Spiels. Sie enthält die Hauptmethode, die zum
 * Starten des Spiels aufgerufen werden muss.
 *
 * @author MR. Robot
 */
abstract class PIGame extends Game
{
    
    /** Das Spiel beginnt durch Aufruf dieser Methode. */
    static void main()
    {
        // Map Objecten
        new GameObject(0,0,0,"path-l");
        new GameObject(1,0,1,"path-l");
        new GameObject(0,1,3,"path-l");
        new GameObject(1,1,2,"path-l");
        
        
        
        //Player
        final GameObject player1; // Variable
        player1 = new GameObject(0,0,0,"laila");
        //blick nach 1-  unter (direckt) 2- left 3 oben 0- recht
        player1.setRotation(1);
        
        
        final int key = getNextKey(); // final, es muss nicht gäendert werden
        while(true){
            switch(key){
            case VK_RIGHT:
                player1.setLocation(player1.getX() + 1,player1.getY());
                player1.setRotation(0);
                playSound("step");
                break;
            case VK_LEFT:
                player1.setLocation(player1.getX() - 1, player1.getY());
                player1.setRotation(2);
                playSound("step");
                break;
            case VK_UP:
                player1.setLocation(player1.getX(), player1.getY() - 1);
                player1.setRotation(3);
                playSound("step");
                break;
            case VK_DOWN:
                player1.setLocation(player1.getX(), player1.getY() + 1);
                player1.setRotation(1);
                playSound("step");
                break;
            default:
                playSound("error");
                break; 
        };sleep(100);
       
    }  
    }
}
