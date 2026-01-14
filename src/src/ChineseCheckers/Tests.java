package ChineseCheckers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    public void testCheckers() {
        Checker checker = new Checker(new Cell(0, false), 1, 0);
        checker.getCell().setFree(true);
        Assertions.assertFalse(checker.getCell().isFree());
    }

    @Test
    public void testCells() {
        Cell cell = new Cell(1, false);
        cell.setFree(true);
    }
}
