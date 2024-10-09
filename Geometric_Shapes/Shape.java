package Geometric_Shapes;

interface Shape {
    double calculateArea();
    default double calculatePerimeter(){
        return 0;
    }

    String getFillColor();
    String getBorderColor();
}
