import org.example.Cell;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CellTest {

    @Test
    public void expectsToCreateAnAliveCell(){
        Cell cell = new Cell(0,0,1,1, true);
        assertTrue(cell.isAlive());
    }

    @Test
    public void expectsToCreateAnDeadCell(){
        Cell cell = new Cell(0,0,1,1, false);
        assertTrue(cell.isAlive());
    }



}
