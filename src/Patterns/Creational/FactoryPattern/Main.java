package Patterns.Creational.FactoryPattern;


import java.util.Objects;

interface Shape {
    void printShapeType();
}

class Circle implements Shape {

    @Override
    public void printShapeType() {
        System.out.println("Circular shape");
    }
}

class Triangle implements Shape {

    @Override
    public void printShapeType() {
        System.out.println("Triangular Shape");
    }
}

class ShapeFactory {

    public Shape getShape(String type) {
        if (Objects.equals(type, "Circle"))
            return new Circle();

        if (Objects.equals(type, "Triange"))
            return new Triangle();

        return null;
    }
}

public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circularShape = shapeFactory.getShape("Circle");
        circularShape.printShapeType();
    }
}
