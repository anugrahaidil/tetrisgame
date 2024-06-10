import java.awt.Color;

public abstract class Tetromino {
    protected int[][][] shapes;
    protected int currentShape;
    protected Color color;
    protected int x, y;

    public Tetromino(int[][][] shapes, Color color) {
        this.shapes = shapes;
        this.color = color;
        this.currentShape = 0;
        this.x = 0;
        this.y = 0;
    }

    public int[][] getShape() {
        return shapes[currentShape];
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void rotate() {
        currentShape = (currentShape + 1) % shapes.length;
    }

    public void rotateBack() {
        currentShape = (currentShape + shapes.length - 1) % shapes.length;
    }

    public abstract void printType();
}
