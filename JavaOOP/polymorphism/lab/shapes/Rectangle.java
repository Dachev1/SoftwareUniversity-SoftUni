package polymorphism.lab.shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;


    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    void calculatePerimeter() {
        super.setPerimeter((width * height) * 2);
    }

    @Override
    void calculateArea() {
        super.setArea(width * height);
    }
}
