package Patterns.Creational.AbstractFactoryPattern;

import java.util.Objects;

interface Shape {
    void draw();
}

class RoundedRectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Rounded Rectangle");
    }
}

class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Rectangle");
    }
}

class RoundedSquare implements Shape{
    @Override
    public void draw(){
        System.out.println("Rounded Square");
    }
}

class Square implements Shape{
    @Override
    public void draw(){
        System.out.println("Square");
    }
}

class RoundedShapeFactory implements AbstractFactory{

    @Override
    public Shape getShape(String type) {
        if (Objects.equals(type, "Rectangle")) {
            return new RoundedRectangle();
        }

        return new RoundedSquare();
    }
}

class ShapeFactory implements AbstractFactory{

    @Override
    public Shape getShape(String type) {
        if (Objects.equals(type, "Rectangle")) {
            return new Rectangle();
        }

        return new Square();
    }
}

interface AbstractFactory {
    Shape getShape(String type);
}

class Factory {
    public AbstractFactory getFactory(Boolean isRounded) {
        if (isRounded) {
            return new RoundedShapeFactory();
        }

        return new ShapeFactory();
    }
}


public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();
        AbstractFactory abstractFactory = factory.getFactory(true);
        Shape shape = abstractFactory.getShape("Rectangle");
        shape.draw();
    }
}
