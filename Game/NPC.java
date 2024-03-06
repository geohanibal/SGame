/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author MR. Robot
 */
class NPC
{
    private final GameObject bot;
    private final int stepMax;
    private int stepCounter;
    private int step = 1;
    
    NPC(final GameObject bot,final int stepMax, int stepCounter){
        this.bot = bot;
        this.stepMax = stepMax;
        this.stepCounter = stepCounter;
    } 
    
    void act(){
        stepCounter ++;
        if(stepCounter == stepMax/2 ){
            turn(2);
            step = -1;
            
        }else if(stepCounter == stepMax  ){
            turn(-2);
            stepCounter = 0;
            step = 1;
        }
        bot.setLocation(bot.getX() + step,bot.getY());

    }
    
    private void turn (final int direction){
        bot.setRotation(bot.getRotation() + direction);
    }
    
    
}
