import java.awt.Color;

public class ITetromino extends Tetromino {

    private static final int[][][] SHAPES = {{{1, 1, 1, 1}}, {{1}, {1}, {1}, {1}}};

    public ITetromino() {
        super(SHAPES, Color.CYAN);
    }

    @Override
    public void printType() {
        System.out.println("This is an I-Tetromino");
    }
}
