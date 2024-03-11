// Importieren der VK_*-Tastenkonstanten
import static java.awt.event.KeyEvent.*;
import static java.lang.Thread.sleep;
import java.util.Timer;
import java.util.TimerTask;

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
        // final GameObject bot, final int stepMax,  int stepCounter
        final NPC npc1 = new NPC(new GameObject(1, 0, 2, "claudius"),3,2 );
        final NPC npc2 = new NPC(new GameObject(0, 1, 0, "woman"),3,0);
        final NPC npc3 = new NPC(new GameObject(3, 2, 2, "child"),4,1);
        
        //Player
        final GameObject player1 = new GameObject(0,3,0,"laila");
        
        //blick nach 1-  unter (direckt) 2- left 3 oben 0- recht
        player1.setRotation(1);
        
         // Timer für regelmäßige NPC-Aktionen
        Timer npcTimer = new Timer();
        npcTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                npc1.act(player1);

            }
        }, 0, 1000); // Startet sofort, wiederholt sich alle 1000ms
        

        
               
        int key;
        
        while(player1.isVisible()){
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
         sleep(200);
         
         npc2.act(player1);
         npc3.act(player1);
        

        }

       npcTimer.cancel();
        
      } 
    }  
