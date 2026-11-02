package Task_3;

import java.util.Scanner;

public class Main {
    public static Rectangle verticalRectangle = new Rectangle(-2.0, -4.0, 1.0, 6.0);
    public static Rectangle horizontalRectangle = new Rectangle(-6.0, -2.0, 2.0, 3.0);
    public static Parabola horizontalParabola = new Parabola(-4, -3, -0.25);

    public static void main(String[] args) {
        java.util.Locale.setDefault(java.util.Locale.US);
        Scanner input = new Scanner(System.in);
        // Точки внутри всех зон (7)
        printColorForPoint(0, 0);
        printColorForPoint(0, 5);
        printColorForPoint(0, -3);
        printColorForPoint(1.5, 0);
        printColorForPoint(-3, 0);
        printColorForPoint(10, 10);
        printColorForPoint(-5.5, -1.5);
        // На границе
        printColorForPoint(1, 5);
        printColorForPoint(0, -2);

        printColorForPoint(input.nextDouble(), input.nextDouble());
    }

    public static void printColorForPoint(double x, double y) {
        if (x>10.0 || y>10.0 ||x<-10.0||y<-10.0) {
            System.out.println("Выход за границы диапазона.");
            return;
        }
        SimpleColor color = Main.getColor(x, y);
        System.out.printf("(%.1f, %.1f) -> %s\n", x, y, color);
    }

    public static SimpleColor getColor(double x, double y) {

        // Пересечение прямоугольников
        if (verticalRectangle.isPointInside(x, y) && horizontalRectangle.isPointInside(x, y)) {
            return SimpleColor.ORANGE;
        }
        // Вертикальный сверху
        else if (verticalRectangle.isPointInside(x, y) && y > 0) {
            return SimpleColor.BLUE;
        }
        // Вертикальный снизу
        else if (verticalRectangle.isPointInside(x, y) && y < 0) {
            return SimpleColor.GREEN;
        }
        // Горизонтальный справа
        else if (horizontalRectangle.isPointInside(x, y) && x > 0) {
            return SimpleColor.GRAY;
        }
        // Пересечение параболы и горизонтала
        else if (horizontalRectangle.isPointInside(x, y) && horizontalParabola.isPointInside(x, y)) {
            return SimpleColor.BLUE;
        }
        // Горизонтальный слева
        else if (horizontalRectangle.isPointInside(x, y) && x < 0) {
            return SimpleColor.GRAY;
        }
        // Все остальное
        else {
            return SimpleColor.ORANGE;
        }
    }
}