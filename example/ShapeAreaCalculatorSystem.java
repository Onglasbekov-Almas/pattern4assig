// Visitor Interface
interface Visitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

// Shape Interface
interface Shape {
    void accept(Visitor visitor);
}

// Circle Class
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Rectangle Class
class Rectangle implements Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// AreaCalculator Visitor
class AreaCalculator implements Visitor {
    public void visit(Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        System.out.println("Area of Circle: " + area);
    }

    public void visit(Rectangle rectangle) {
        double area = rectangle.getWidth() * rectangle.getHeight();
        System.out.println("Area of Rectangle: " + area);
    }
}

// Main Class
public class ShapeAreaCalculatorSystem {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        AreaCalculator calculator = new AreaCalculator();
        circle.accept(calculator);
        rectangle.accept(calculator);
    }
}
