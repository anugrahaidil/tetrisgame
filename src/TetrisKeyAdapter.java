import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TetrisKeyAdapter extends KeyAdapter {
    private Board board;

    public TetrisKeyAdapter(Board board) {
        this.board = board;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                board.movePieceLeft();
                break;
            case KeyEvent.VK_RIGHT:
                board.movePieceRight();
                break;
            case KeyEvent.VK_DOWN:
                board.dropPiece();
                break;
            case KeyEvent.VK_UP:
                board.rotatePiece();
                break;
        }
    }
}
