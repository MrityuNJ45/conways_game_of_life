import org.example.Board;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Cell;
import org.junit.jupiter.api.Test;

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
    public void expectsToCreateABoardOfNCrossM() {

        Board board = new Board(3, 3);
        Integer actual = board.getNumOfElements();
        assertEquals(3 * 3, actual);

    }

    @Test
    public void expectsPopulationOfCellNotToBeRandomOnlyDeadCellsPresentAtBoardCreation() {

        Board board = new Board(2, 2);
        Integer liveCells = board.numOfLiveCells();
        assertEquals(0, liveCells);

    }

    @Test
    public void expectsPopulationToBeRandomizeBothDeadCellsAndLiveCellsWillBePresent() {

        Board board = new Board(2, 2);
        board.populate();
        Integer liveCells = board.numOfLiveCells();
        Integer deadCells = board.getNumOfElements() - liveCells;
        assertEquals(true, liveCells > 0 && deadCells > 0);

    }

    @Test
    public void expectsToGiveTheStatusOfNeighbourAtParticularPosition() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(false));
        cellList.add(new Cell(true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(true));
        cellList1.add(new Cell(true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        Board board = new Board(2, 2, aMatrix);
        assertEquals(true, board.isNeighbourAliveAt(0, 1));

    }


    @Test
    public void expectsToGiveTheCountOfLiveNeighboursForACertainCell() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(false));
        cellList.add(new Cell(true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(true));
        cellList1.add(new Cell(true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        Board board = new Board(2, 2, aMatrix);
        Integer liveNeighbours = board.countLiveNeighbours(0, 0);
        assertEquals(3, liveNeighbours);

    }

    @Test
    public void expectsToGiveALiveCellWhenADeadCellIsSurroundedBy3LiveCells() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(false));
        cellList.add(new Cell(true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(true));
        cellList1.add(new Cell(true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        Board board = new Board(2, 2, aMatrix);
        Cell resultCell = board.cellForNextGeneration(0, 0);
        assertEquals(true, resultCell.isAlive());

    }


    @Test
    public void expectsToGiveALiveCellWhenALiveCellIsSurroundedWith2or3LiveNeighbours() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(false));
        cellList.add(new Cell(true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(true));
        cellList1.add(new Cell(true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        Board board = new Board(2, 2, aMatrix);
        Cell resultCell = board.cellForNextGeneration(0, 1);
        assertEquals(true, resultCell.isAlive());

    }

    @Test
    public void expectsToGiveADeadCellWhenALiveCellIsSurroundedWithLessThan2LiveCells() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(false));
        cellList.add(new Cell(false));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(true));
        cellList1.add(new Cell(true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        Board board = new Board(2, 2, aMatrix);
        Cell resultCell = board.cellForNextGeneration(1, 0);
        assertEquals(false, resultCell.isAlive());

    }

    @Test
    public void expectsToGiveTrueWhenTwoBoardsAreComparedAfterCreationBeforePopulate() {

        Board board = new Board(3, 3);
        Board anotherBoard = new Board(3, 3);
        assertEquals(true, board.equals(anotherBoard));

    }

    @Test
    public void expectsToGiveFalseWhenTwoBoardsAreComparedAfterOneBeingPopulated() {

        Board board = new Board(3, 3);
        board.populate();
        Board anotherBoard = new Board(3, 3);
        assertEquals(false, board.equals(anotherBoard));

    }

    @Test
    public void expectsToGiveADeadCellWhenALiveCellIsSurroundedWithMoreThan3LiveCells() {

        List<List<Cell>> aMatrix = new ArrayList<>();
        List<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(false));
        cellList.add(new Cell(true));
        cellList.add(new Cell(true));
        List<Cell> cellList1 = new ArrayList<>();
        cellList1.add(new Cell(true));
        cellList1.add(new Cell(true));
        cellList1.add(new Cell(true));
        List<Cell> cellList2 = new ArrayList<>();
        cellList2.add(new Cell(true));
        cellList2.add(new Cell(true));
        cellList2.add(new Cell(true));
        aMatrix.add(cellList);
        aMatrix.add(cellList1);
        aMatrix.add(cellList2);
        Board board = new Board(3, 3, aMatrix);
        Cell resultCell = board.cellForNextGeneration(1, 1);
        assertEquals(false, resultCell.isAlive());

    }


    @Test
    public void expectsToGiveBoardForNextGenerationWhichWillBeDifferentThanTheFirstOne() {

        Board board = new Board(2, 2);
        board.populate();
        Board nextBoard = board.boardForNextGeneration();
        assertTrue(!(board.equals(nextBoard)));

    }


}
