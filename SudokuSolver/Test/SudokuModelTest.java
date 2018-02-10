import model.SudokuModel4x4;
import org.junit.*;
import org.junit.Test;

/**
 * Created by E633828 on 7/17/2017.
 */
public class SudokuModelTest {
    SudokuModel4x4 model = new SudokuModel4x4();
    String row1 = "1234";
    String row2 = "----";
    String row3 = "1-2-";
    String row4 = "-z-z";
    String row5 = "1a2b";
    String row6 = "-1ab";
    String test = "1234" +
            "2341" +
            "3412" +
            "4123";


//    @Test
//    public void checkRowTest() {
//        Assert.assertEquals(model.checkRow(row1), true);
//        Assert.assertEquals(model.checkRow(row2), true);
//        Assert.assertEquals(model.checkRow(row3), true);
//        Assert.assertEquals(model.checkRow(row4), false);
//        Assert.assertEquals(model.checkRow(row5), false);
//        Assert.assertEquals(model.checkRow(row6), false);
//    }

    @Test
    public void fillBoardTest() {

    }
}
