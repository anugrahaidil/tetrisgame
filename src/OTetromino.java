import java.awt.Color;

public class OTetromino extends Tetromino {

    private static final int[][][] SHAPES = {{{1, 1}, {1, 1}}};

    public OTetromino() {
        super(SHAPES, Color.YELLOW);
    }

    @Override
    public void printType() {
        System.out.println("This is an O-Tetromino");
    }
}
