import org.example.Cell;
import org.example.CellBoardCommuter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CellBoardCommuterTest {

    @Test
    public void expectsToReturnTrueWhenAliveCellIsPresent(){

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(false));
        cellList.add(new Cell(true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(true));
        cellList1.add(new Cell(true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        boolean actual = CellBoardCommuter.isCellAliveAt(0,1,aMatrix);
        assertEquals(true,actual);

    }

    @Test
    public void expectsToGetAnIntegerWhenCheckingForAliveNeighbours(){
        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(false));
        cellList.add(new Cell(true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(true));
        cellList1.add(new Cell(true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        Integer actual = CellBoardCommuter.getNumberOfLiveNeighboursAt(0,0, aMatrix);
        assertEquals(3,actual);
    }


}
