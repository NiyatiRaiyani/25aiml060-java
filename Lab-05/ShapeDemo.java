abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class Rectangle extends Shape {
    private double height;
    private double width;

    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    double area() {
        return height * width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

class Triangle extends Shape {
    private double height;
    private double base;

    Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBase(double base) {
        this.base = base;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {

        Shape[] shapes = {
            new Circle(5.0),
            new Rectangle(10.0, 4.0),
            new Triangle(8.0, 6.0),
            new Circle(3.0)
        };

        double total = 0;
        double largest = 0;

        for (Shape shape : shapes) {
            double currentArea = shape.area();

            System.out.println("Area = " + currentArea);

            total += currentArea;

            if (currentArea > largest) {
                largest = currentArea;
            }
        }

        System.out.println("Total Area = " + total);
        System.out.println("Largest Area = " + largest);
    }
}