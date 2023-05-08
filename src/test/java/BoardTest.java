import org.example.Board;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Cell;
import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.List;


public class BoardTest {


    @Test
    void expectsToCreateABoardWithValidInputWithoutThrowingException() {

        assertDoesNotThrow(() -> {
            Board board = new Board(2, 2);
        });

    }

    @Test
    public void expectsToThrowExceptionWhenInvalidInputIsGivenToBoardCreation() {

        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            Board board = new Board(-1, 4);
        });
        assertEquals("Rows and Columns must be above 0", thrown.getMessage());

    }


    @Test
    public void expectsToNotThrowExceptionWhenValidDataIsGivenFor2ndParameterizedConstructorOfBoard() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(false));
        cellList.add(new Cell(true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(true));
        cellList1.add(new Cell(true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        assertDoesNotThrow(() -> {
            Board board = new Board(2, 2, aMatrix);
        });

    }

    @Test
    public void expectsToThrowExceptionWhenInvalidValuesAreGivenFor2ndParameterizedConstructorOfBoard() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(false));
        cellList.add(new Cell(true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(true));
        cellList1.add(new Cell(true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            Board board = new Board(0, 2, aMatrix);
        });
        assertEquals("Invalid data provided...", thrown.getMessage());

    }

    @Test
    public void expectsToCheckTwoBoardsAreEqualOrNot(){



    }

    @Test
    public void expectsToPopulateMeansWillBeDifferentFromTheFirstInitializationOfBoard(){

    }




}
