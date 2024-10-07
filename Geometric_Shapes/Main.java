package Lesson_3.Geometric_Shapes;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(10.0, "Зеленый", "Белый");
        Rectangle rectangle = new Rectangle(8.8, 5.5, "Черный", "Золтой");
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, "Розовый", "Фиолетовый");

        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
    }

    public static void printShapeInfo(Shape shape) {
        System.out.println("Фигура: " + shape.getClass().getSimpleName());
        System.out.println("Площадь: " + shape.calculateArea());
        System.out.println("Периметр: " + shape.calculatePerimeter());
        System.out.println("Цвет заливки: " + shape.getFillColor());
        System.out.println("Цвет границ: " + shape.getBorderColor());
        System.out.println("------------------------");
    }
}
