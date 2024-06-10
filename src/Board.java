import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class Board extends JPanel implements ActionListener, Movable {
    private final int boardWidth = 10;
    private final int boardHeight = 20;
    private Tetromino currentPiece;
    private Color[][] board;
    private Timer timer;

    public Board() {
        setPreferredSize(new Dimension(300, 600));
        board = new Color[boardHeight][boardWidth];
        currentPiece = TetrominoFactory.getRandomTetromino();
        currentPiece.setX(boardWidth / 2 - 1);
        timer = new Timer(500, this);
        timer.start();
        setFocusable(true);
        addKeyListener(new TetrisKeyAdapter(this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawCurrentPiece(g);
    }

    private void drawBoard(Graphics g) {
        for (int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidth; x++) {
                if (board[y][x] != null) {
                    g.setColor(board[y][x]);
                    g.fillRect(x * 30, y * 30, 30, 30);
                }
            }
        }
    }

    private void drawCurrentPiece(Graphics g) {
        g.setColor(currentPiece.getColor());
        for (int i = 0; i < currentPiece.getShape().length; i++) {
            for (int j = 0; j < currentPiece.getShape()[i].length; j++) {
                if (currentPiece.getShape()[i][j] == 1) {
                    g.fillRect((currentPiece.getX() + j) * 30, (currentPiece.getY() + i) * 30, 30, 30);
                }
            }
        }
    }

    @Override
    public void dropPiece() {
        if (!canMove(currentPiece, currentPiece.getX(), currentPiece.getY() + 1)) {
            placePiece();
            clearLines();
            currentPiece = TetrominoFactory.getRandomTetromino();
            currentPiece.setX(boardWidth / 2 - 1);
            if (!canMove(currentPiece, currentPiece.getX(), currentPiece.getY())) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "Game Over");
            }
        } else {
            currentPiece.moveDown();
        }
        repaint();
    }

    @Override
    public void movePieceLeft() {
        if (canMove(currentPiece, currentPiece.getX() - 1, currentPiece.getY())) {
            currentPiece.moveLeft();
            repaint();
        }
    }

    @Override
    public void movePieceRight() {
        if (canMove(currentPiece, currentPiece.getX() + 1, currentPiece.getY())) {
            currentPiece.moveRight();
            repaint();
        }
    }

    @Override
    public void rotatePiece() {
        currentPiece.rotate();
        if (!canMove(currentPiece, currentPiece.getX(), currentPiece.getY())) {
            currentPiece.rotateBack();
        }
        repaint();
    }

    private boolean canMove(Tetromino piece, int newX, int newY) {
        int[][] shape = piece.getShape();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == 1) {
                    int x = newX + j;
                    int y = newY + i;
                    if (x < 0 || x >= boardWidth || y < 0 || y >= boardHeight || board[y][x] != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void placePiece() {
        int[][] shape = currentPiece.getShape();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == 1) {
                    board[currentPiece.getY() + i][currentPiece.getX() + j] = currentPiece.getColor();
                }
            }
        }
    }

    private void clearLines() {
        for (int y = 0; y < boardHeight; y++) {
            boolean fullLine = true;
            for (int x = 0; x < boardWidth; x++) {
                if (board[y][x] == null) {
                    fullLine = false;
                    break;
                }
            }
            if (fullLine) {
                for (int i = y; i > 0; i--) {
                    for (int j = 0; j < boardWidth; j++) {
                        board[i][j] = board[i - 1][j];
                    }
                }
                for (int j = 0; j < boardWidth; j++) {
                    board[0][j] = null;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dropPiece();
    }
}
