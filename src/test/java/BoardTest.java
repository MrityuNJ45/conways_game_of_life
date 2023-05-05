import org.example.Board;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Cell;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class BoardTest {

    @Test
    public void expectsToCreatABoardOfNCrossM(){

//        Board board = new Board(3,3);
//        Integer actual = board.getNumOfElements();
//        assertEquals(3*3, actual);

    }

    @Test
    public void expectsToGiveNumberOfLiveCells(){

        List<List<Cell>> cellList = new ArrayList<>();
        List<Cell> list1 = new ArrayList<>();
        list1.add(new Cell(0,0,2,2,false));
        list1.add(new Cell(0,1,2,2,true));
        List<Cell> list2 = new ArrayList<>();
        list2.add(new Cell(1,0,2,2,true));
        list2.add(new Cell(1,1,2,2,true));
        cellList.add(list1);
        cellList.add(list2);
        Board board = new Board(2,2,cellList);
        Integer actual = board.countLiveNeighbours(0,0);
        assertEquals(3,actual);


    }





}
