/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 * diese Klasse steuert sich eine NPC
 * 
 * @author MR. Robot
 */
class NPC 
{
    /** @param erzägt neue Objekt */ 
    private final GameObject bot;
    /** @param Anzahl der schritte für eine Hin und Zurückdrehung*/
    private final int stepMax;
    /** @param Zählt die Anzahl der Schritte */
    private int stepCounter;
    

    
    NPC(final GameObject bot,final int stepMax, int stepCounter){
        this.bot = bot;
        this.stepMax = stepMax;
        this.stepCounter = stepCounter;
    } 
    
    /*
     * ein Method act() nbewebung für NPC
     * blick nach 1-  unter (direckt) 2- left 3 oben 0- recht
     */
    
    void act(final GameObject player1){
        
      
        if(bot.getRotation() == 0){
            bot.setLocation(bot.getX() + 1,bot.getY());
        }else if(bot.getRotation() == 1){
            bot.setLocation(bot.getX() ,bot.getY() + 1);
        }else if(bot.getRotation() == 2){
            bot.setLocation(bot.getX() - 1,bot.getY());
        }else if(bot.getRotation() == 3){
            bot.setLocation(bot.getX() ,bot.getY() - 1);
        }
        
        bot.playSound("step");

       
        stepCounter ++;
        
        if(stepCounter == stepMax ){
           bot.setRotation(bot.getRotation() +2);
           stepCounter = 0;
        } 
        
        // grenze für NPC 
         if(bot.getX() == 0 && bot.getRotation() == 2){
            stepCounter = 0;
            
        } else if(bot.getY() == 0 && bot.getRotation() == 3){
            stepCounter = 0;
           
        }
        
        
        //wenn NPC hat gleiche position wie player dann es beendet spiel
        if(player1.getX() == bot.getX() && player1.getY() == bot.getX()){
            player1.setVisible(false);
            final GameObject gameover = new GameObject(2,2,0,"gameover");
        }
        
    }   
    
}
