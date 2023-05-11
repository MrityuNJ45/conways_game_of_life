import org.example.Cell;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CellTest {

    @Test
    public void expectsToCreateCell() {

        assertDoesNotThrow(() -> new Cell(0, 0, true));

    }

    @Test
    public void expectsToGetTrueWhenAliveCellCheckedForIsAlive() {
        assertTrue(new Cell(0, 0, true).isAlive());
    }

    @Test
    public void expectsToGetFalseWhenDeadCellCheckedForIsAlive() {
        assertFalse(new Cell(0, 0, false).isAlive());
    }

    @Test
    public void expects3LiveNeighbours() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(0, 0, false));
        cellList1.add(new Cell(0, 1, true));
        List<Cell> cellList2 = new ArrayList<>();
        cellList2.add(new Cell(1, 0, true));
        cellList2.add(new Cell(1, 1, true));
        aMatrix.add(cellList1);
        aMatrix.add(cellList2);
        Cell cell = new Cell(0, 0, false);
        Integer ans = cell.getNoOfLiveNeighbours(aMatrix);
        assertEquals(3, ans);

    }

    @Test
    public void expectsCellForNextGenerationToBeAliveWhenSurroundedWith3AliveNeighbours() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(0, 0, false));
        cellList1.add(new Cell(0, 1, true));
        List<Cell> cellList2 = new ArrayList<>();
        cellList2.add(new Cell(1, 0, true));
        cellList2.add(new Cell(1, 1, true));
        aMatrix.add(cellList1);
        aMatrix.add(cellList2);
        Cell cell = new Cell(0, 0, false);
        Integer ans = cell.getNoOfLiveNeighbours(aMatrix);
        Cell result = cell.cellForNextGeneration(ans);

        assertTrue(result.isAlive());

    }

    @Test
    public void expectsCellForNextGenerationToBeDeadWhenSurroundedWithLessThan2AliveNeighbours() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(0, 0, false));
        cellList1.add(new Cell(0, 1, true));
        List<Cell> cellList2 = new ArrayList<>();
        cellList2.add(new Cell(1, 0, true));
        cellList2.add(new Cell(1, 1, false));
        aMatrix.add(cellList1);
        aMatrix.add(cellList2);
        Cell cell = new Cell(0, 0, false);
        Integer ans = cell.getNoOfLiveNeighbours(aMatrix);
        Cell result = cell.cellForNextGeneration(ans);

        assertTrue(!result.isAlive());

    }


}
