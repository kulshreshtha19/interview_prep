package Patterns.Structural.ProxyPattern;


interface Image {
    void display();
}

class ImageObject implements Image {

    @Override
    public void display() {
        System.out.println("Hello image");
    }
}

class ImageProxy implements Image {

    ImageObject imageObject;

    @Override
    public void display() {
        if (imageObject == null) {
            this.imageObject = new ImageObject();
        }

        this.imageObject.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Image image = new ImageProxy();
        image.display();
    }
}
