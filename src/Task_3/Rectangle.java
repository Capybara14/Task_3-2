package Task_3;

public class Rectangle {
    public double x1, x2, y1, y2;

    public Rectangle(double x1, double y1, double x2, double y2) {
        this.x1 = Math.min(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.x2 = Math.max(x1, x2);
        this.y2 = Math.max(y1, y2);
    }

    public boolean isPointInside(double x, double y) {
        return (x >= x1 && x <= x2) && (y >= y1 && y <= y2);
    }
}
