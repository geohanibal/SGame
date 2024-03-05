/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author MR. Robot
 */
class Turner
{
    final GameObject avatar;
    int counter = 0;
    //
    Turner(final GameObject avatar2)
    {
        this.avatar = avatar2;
        counter = 0;
    }
    
    void act()
    {
        counter ++;
    }
}
