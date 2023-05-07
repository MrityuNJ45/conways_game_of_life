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


    @Test
    public void expectsTrueWhenTwoCellsHaveSameIsAliveCondition(){
        Cell cell = new Cell(true);
        Cell anotherCell = new Cell(true);
        assertEquals(true,cell.equals(anotherCell));
    }

    @Test
    public void expectsFalseWhenTwoCellsHaveDifferentIsAliveCondition(){
        Cell cell = new Cell(true);
        Cell anotherCell = new Cell(false);
        assertEquals(false,cell.equals(anotherCell));
    }


    @Test
    public void expectsToGiveSameHashcodeForEqualCells(){
        Cell cell = new Cell(true);
        Cell anotherCell = new Cell(true);
        assertEquals(cell.hashCode(), anotherCell.hashCode());
    }

    @Test
    public void expectsToGiveDifferentHashcodeForDifferentCells(){
        Cell cell = new Cell(true);
        Cell anotherCell = new Cell(false);
        assertNotEquals(cell.hashCode(), anotherCell.hashCode());
    }

}
