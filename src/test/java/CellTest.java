import org.example.Cell;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CellTest {

    @Test
    public void expectsToCreateAnAliveCell(){
        Cell cell = new Cell( true);
        assertTrue(cell.isAlive());
    }

    @Test
    public void expectsToCreateAnDeadCell(){
        Cell cell = new Cell( false);
        assertFalse(cell.isAlive());
    }



}
