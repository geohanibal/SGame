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
        new GameObject(0, 0, 0, "path-e");
        new GameObject(1, 0, 0, "path-i");
        new GameObject(2, 0, 1, "path-t");
        new GameObject(3, 0, 0, "path-i");
        new GameObject(3, 0, 0, "goal");
        new GameObject(4, 0, 0, "bridge");
        new GameObject(0, 1, 0, "path-e");
        new GameObject(1, 1, 0, "path-i");
        new GameObject(2, 1, 0, "path-x");
        new GameObject(3, 1, 2, "path-e");
        new GameObject(4, 1, 3, "water-l");
        new GameObject(0, 2, 0, "path-e");
        new GameObject(1, 2, 0, "path-i");
        new GameObject(2, 2, 0, "path-x");
        new GameObject(3, 2, 0, "path-i");
        new GameObject(4, 2, 2, "path-e");
        new GameObject(0, 3, 0, "path-e");
        new GameObject(1, 3, 0, "path-i");
        new GameObject(2, 3, 2, "path-l");
        new GameObject(3, 3, 0, "water-l");
        new GameObject(4, 3, 0, "water-i");
        
        //NPC
        new GameObject(1, 0, 2, "claudius");
        new GameObject(0, 1, 0, "laila");
        new GameObject(3, 2, 2, "child");
        
        //Player
        final GameObject player1; // Variable
        player1 = new GameObject(0,3,0,"laila");
        //blick nach 1-  unter (direckt) 2- left 3 oben 0- recht
        player1.setRotation(1);
        
        int key;
        
        while(true){
           key = getNextKey(); // final, es muss nicht gäendert werden
          switch(key){
            case VK_RIGHT:
                player1.setLocation(player1.getX() + 1,player1.getY());
                player1.setRotation(0);
                playSound("step");
                break;
            case VK_LEFT:
                player1.setLocation(player1.getX() - 1, player1.getY());
                player1.setRotation(2);
               // playSound("step");
                break;
            case VK_UP:
                player1.setLocation(player1.getX(), player1.getY() - 1);
                player1.setRotation(3);
               // playSound("step");
                break;
            case VK_DOWN:
                player1.setLocation(player1.getX(), player1.getY() + 1);
                player1.setRotation(1);
               // playSound("step");
                break;
            default:
                playSound("error");
                break; 
         };
         playSound("step");
       //  continue;

        /* if(key == VK_ESCAPE){
             player1.setVisible(false);
             break;
             
         }*/
        }     
      } 
    }  
