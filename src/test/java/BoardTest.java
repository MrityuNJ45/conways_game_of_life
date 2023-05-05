import org.example.Board;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class BoardTest {

    @Test
    public void expectsToCreatABoardOfNCrossM(){

        Board board = new Board(3,3);
        Integer actual = board.getNumOfElements();
        assertEquals(3*3, actual);

    }






}
