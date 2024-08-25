package Task2;

public class RectangleTest {
    public static void main(String[] args) {
        // Testing default constructor
        Rectangle rect1 = new Rectangle();
        System.out.println("Rectangle 1 (Default Constructor)");
        System.out.println("Width: " + rect1.getWidth());
        System.out.println("Height: " + rect1.getHeight());
        System.out.println("Angle: " + rect1.getAngle());
        System.out.println("Area: " + rect1.calculateArea());
        System.out.println("Perimeter: " + rect1.calculatePerimeter());
        System.out.println("Diagonal: " + rect1.getDiagonal());

        // Testing parameterized constructor
        Rectangle rect2 = new Rectangle(5.0, 7.0);
        System.out.println("\nRectangle 2 (Parameterized Constructor)");
        System.out.println("Width: " + rect2.getWidth());
        System.out.println("Height: " + rect2.getHeight());
        System.out.println("Angle: " + rect2.getAngle());
        System.out.println("Area: " + rect2.calculateArea());
        System.out.println("Perimeter: " + rect2.calculatePerimeter());
        System.out.println("Diagonal: " + rect2.getDiagonal());

        // Testing setters
        rect2.setWidth(10.0);
        rect2.setHeight(6.0);
        System.out.println("\nUpdated Rectangle 2 (Using Setters)");
        System.out.println("Width: " + rect2.getWidth());
        System.out.println("Height: " + rect2.getHeight());
        System.out.println("Angle: " + rect2.getAngle());
        System.out.println("Area: " + rect2.calculateArea());
        System.out.println("Perimeter: " + rect2.calculatePerimeter());
        System.out.println("Diagonal: " + rect2.getDiagonal());
    }
}


