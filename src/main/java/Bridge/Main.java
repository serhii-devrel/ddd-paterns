package Bridge;

public class Main {
    public static void main(String[] args) {
        IRenderer raster = new RasterRenderer();

        Rectangle rectangle = new Rectangle(raster);
        rectangle.draw();

        Circle circle = new Circle(raster);
        circle.draw();
    }
}

interface IRenderer {
    void drawCircle();
    void drawRectangle();
}

class RasterRenderer implements IRenderer {
    @Override
    public void drawCircle() {
        System.out.println("Drawing circle with raster renderer");
    }

    @Override
    public void drawRectangle() {
        System.out.println("Drawing rectangle with raster renderer");
    }
}

class VectorRenderer implements IRenderer {
    @Override
    public void drawCircle() {
        System.out.println("Drawing circle with vector renderer");

    }

    @Override
    public void drawRectangle() {
        System.out.println("Drawing rectangle with vector renderer");
    }
}

abstract class Shape {
    protected IRenderer renderer;

    public Shape(IRenderer renderer) {
        this.renderer = renderer;
    }
}

class Circle extends Shape {
    public Circle(IRenderer renderer) {
        super(renderer);
    }

    public void draw() {
        this.renderer.drawCircle();
    }
}

class Rectangle extends Shape {
    public Rectangle(IRenderer renderer) {
        super(renderer);
    }

    public void draw() {
        this.renderer.drawRectangle();
    }
}
