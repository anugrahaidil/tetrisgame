import java.awt.Color;
import java.util.Random;

public class TetrominoFactory {
    private static final int[][][] I_SHAPE = {{{1, 1, 1, 1}}, {{1}, {1}, {1}, {1}}};
    private static final int[][][] O_SHAPE = {{{1, 1}, {1, 1}}};
    private static final int[][][] T_SHAPE = {{{0, 1, 0}, {1, 1, 1}}, {{1, 0}, {1, 1}, {1, 0}}, {{1, 1, 1}, {0, 1, 0}}, {{0, 1}, {1, 1}, {0, 1}}};
    private static final int[][][] S_SHAPE = {{{0, 1, 1}, {1, 1, 0}}, {{1, 0}, {1, 1}, {0, 1}}};
    private static final int[][][] Z_SHAPE = {{{1, 1, 0}, {0, 1, 1}}, {{0, 1}, {1, 1}, {1, 0}}};
    private static final int[][][] J_SHAPE = {{{1, 0, 0}, {1, 1, 1}}, {{1, 1}, {1, 0}, {1, 0}}, {{1, 1, 1}, {0, 0, 1}}, {{0, 1}, {0, 1}, {1, 1}}};
    private static final int[][][] L_SHAPE = {{{0, 0, 1}, {1, 1, 1}}, {{1, 0}, {1, 0}, {1, 1}}, {{1, 1, 1}, {1, 0, 0}}, {{1, 1}, {0, 1}, {0, 1}}};

    private static final Color[] COLORS = {Color.CYAN, Color.YELLOW, Color.MAGENTA, Color.GREEN, Color.RED, Color.BLUE, Color.ORANGE};
    private static final int[][][][] SHAPES = {I_SHAPE, O_SHAPE, T_SHAPE, S_SHAPE, Z_SHAPE, J_SHAPE, L_SHAPE};

    public static Tetromino getRandomTetromino() {
        Random rand = new Random();
        int shapeIndex = rand.nextInt(SHAPES.length);
        return new GenericTetromino(SHAPES[shapeIndex], COLORS[shapeIndex]);
    }
}
