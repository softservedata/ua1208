package Task2;

public class Rectangle {
    // Fields
    private double width;
    private double height;
    private final double angle; // Angle is always 90 degrees

    // Default constructor
    public Rectangle() {
        this.width = 0.0;
        this.height = 0.0;
        this.angle = 90.0; // Angle is always 90 degrees
    }

    // Constructor with width and height
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.angle = 90.0; // Angle is always 90 degrees
    }

    // Getter and Setter for width
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Getter and Setter for height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Getter for angle (no setter as angle is constant)
    public double getAngle() {
        return angle;
    }

    // Method to calculate the area of the rectangle
    public double calculateArea() {
        return width * height;
    }

    // Method to calculate the perimeter of the rectangle
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    // Method to get the length of the diagonal of the rectangle
    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }
}

