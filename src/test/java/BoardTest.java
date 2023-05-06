import org.example.Board;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Cell;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class BoardTest {


    @Test
    void expectsToCreateABoardWithValidInputWithoutThrowingException(){

        assertDoesNotThrow(() -> {Board board = new Board(2,2);});

    }

    @Test
    public void expectsToThrowExceptionWhenInvalidInputIsGivenToBoardCreation(){


        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            Board board = new Board(-1,4);
        });

        assertEquals("Rows and Columns must be above 0", thrown.getMessage());

    }


    @Test
    public void expectsToCreatABoardOfNCrossM(){

        Board board = new Board(3,3);
        Integer actual = board.getNumOfElements();
        assertEquals(3*3, actual);

    }

    @Test
    public void expectsPopulationOfCellNotToBeRandomOnlyDeadCellsPresent(){

        Board board = new Board(2,2);
        Integer liveCells = board.numOfLiveCells();
        assertEquals(0, liveCells);

    }

    @Test
    public void expectsPopulationToBeRandomizeBothDeadCellsAndLiveCellsWillBePresent(){

        Board board = new Board(2,2);
        board.populate();
        Integer liveCells = board.numOfLiveCells();
        Integer deadCells = board.getNumOfElements() - liveCells;
        assertEquals(true, liveCells > 0 && deadCells > 0);

    }





}
