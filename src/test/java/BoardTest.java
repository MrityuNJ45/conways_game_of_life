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
        cellList.add(new Cell(0, 0, false));
        cellList.add(new Cell(0, 1, true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(1, 0, true));
        cellList1.add(new Cell(1, 1, true));
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
        cellList.add(new Cell(0, 0, false));
        cellList.add(new Cell(0, 1, true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(1, 0, true));
        cellList1.add(new Cell(1, 1, true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            Board board = new Board(0, 2, aMatrix);
        });
        assertEquals("Invalid data provided...", thrown.getMessage());

    }

    @Test
    public void expectsTrueWhenBoardsAreEqual() {

        Board board = new Board(2, 2);
        Board anotherBoard = new Board(2, 2);
        assertEquals(true, board.equals(anotherBoard));

    }

    @Test
    public void expectsFalseWhenBoardsAreNotEqual() {

        Board board = new Board(2, 2);
        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(0, 0, false));
        cellList.add(new Cell(0, 1, true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(1, 0, true));
        cellList1.add(new Cell(1, 1, true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        Board anotherBoard = new Board(2, 2, aMatrix);
        assertEquals(false, board.equals(anotherBoard));


    }

    @Test
    public void expectsToPopulateMeansWillBeDifferentFromTheFirstInitializationOfBoard() {

        Board board = new Board(2, 2);
        Board anotherBoard = new Board(2, 2);
        board.populate();
        assertEquals(false, board.equals(anotherBoard));

    }

    @Test
    public void expectsToTrueWhenABoardIsComparedWithCorrectNextGenerationBoard() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(0, 0, false));
        cellList.add(new Cell(0, 1, true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(1, 0, true));
        cellList1.add(new Cell(1, 1, true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        Board board = new Board(2, 2, aMatrix);

        List<List<Cell>> anotherMatrix = new ArrayList<>();
        List<Cell> cellList3 = new ArrayList<>();
        cellList3.add(new Cell(0, 0, true));
        cellList3.add(new Cell(0, 1, true));
        List<Cell> cellList4 = new ArrayList<>();
        cellList4.add(new Cell(1, 0, true));
        cellList4.add(new Cell(1, 1, true));
        anotherMatrix.add(cellList3);
        anotherMatrix.add(cellList4);
        Board correctNextGenBoard = new Board(2, 2, anotherMatrix);

        assertTrue(board.boardForNextGeneration().equals(correctNextGenBoard));

    }

    @Test
    public void expectFalseWhenABoardIsComparedWithInCorrectNextGenerationBoard() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(0, 0, false));
        cellList.add(new Cell(0, 1, true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(1, 0, true));
        cellList1.add(new Cell(1, 1, true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        Board board = new Board(2, 2, aMatrix);

        List<List<Cell>> anotherMatrix = new ArrayList<>();
        List<Cell> cellList3 = new ArrayList<>();
        cellList3.add(new Cell(0, 0, false));
        cellList3.add(new Cell(0, 1, true));
        List<Cell> cellList4 = new ArrayList<>();
        cellList4.add(new Cell(1, 0, true));
        cellList4.add(new Cell(1, 1, true));
        anotherMatrix.add(cellList3);
        anotherMatrix.add(cellList4);
        Board randomBoard = new Board(2, 2, anotherMatrix);

        assertFalse(board.boardForNextGeneration().equals(randomBoard));

    }


}
