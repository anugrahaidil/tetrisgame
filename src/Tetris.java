import javax.swing.*;

public class Tetris extends JFrame {
    private Board board;

    public Tetris() {
        board = new Board();
        add(board);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Tetris");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tetris().setVisible(true));
    }
}
