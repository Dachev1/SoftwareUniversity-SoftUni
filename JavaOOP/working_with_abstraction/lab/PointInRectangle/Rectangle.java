package working_with_abstraction.lab.PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        boolean isInHorizontal = bottomLeft.getX() <= point.getX() && topRight.getX() >= point.getX();
        boolean isInVertical = bottomLeft.getY() <= point.getY() && topRight.getY() >= point.getY();

        return isInHorizontal && isInVertical;
    }
}
