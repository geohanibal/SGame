// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse <Klasse ergänzen>.
 *
 * @author MR. Robot
 */
public class TurnerTest
{
    private Turner turner1;

    

    @BeforeEach
    public void setUp()
    {
        turner1 = new Turner(new GameObject(4, 0, 0, "grass"), 1);
    }
}
