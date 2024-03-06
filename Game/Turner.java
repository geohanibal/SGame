/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author MR. Robot
 */
class Turner
{
    private final GameObject avatar;
    private final int maxCounter;
    private int counter = 0;
    //konstruktor
    Turner(final GameObject avatar2, final int maxCounter)
    {
        this.avatar = avatar2; //inizialisung
        this.maxCounter = maxCounter; 
    }
    
    void act()
    {
         
        counter ++;
        if(counter == maxCounter / 2){
           
           turn(2);
        }else if(counter == maxCounter){
            turn(-2);
            
            counter = 0;
        }
       
        
    }
    
    // Verwendung von Parameter
    private void turn(final int direction){
        avatar.setRotation(avatar.getRotation() + direction);
        avatar.playSound("step");
    }
}
