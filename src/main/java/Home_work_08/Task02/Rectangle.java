package Home_work_08.Task02;

public class Rectangle {
    private double width;
    private double height;
    private double angle = 90;  // Always 90 degrees

    public Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAngle() {
        return angle;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(3, 4);
        System.out.println("Area: " + rect.calculateArea());  // 12.0
        System.out.println("Perimeter: " + rect.calculatePerimeter());  // 14.0
        System.out.println("Diagonal: " + rect.getDiagonal());  // 5.0
    }
}
