import java.util.Map;

interface IShape {
    double area(Map<String, Object> parameters);           //abstract area method
}

class Shapes {
    static class Rectangle implements IShape {
        double length;
        double width;

        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double area(Map<String, Object> parameters) {
            return length * width;
        }

        public void perimeter(Map<String, Object> parameters) {
            double perimeter = 2 * (length + width);
            System.out.println("Perimeter of Rectangle: " + perimeter);
        }
    }

    static class Circle implements IShape {
        double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area(Map<String, Object> parameters) {
            return Math.PI * radius * radius;
        }

        public void perimeter(Map<String, Object> parameters) {
            double perimeter = 2 * Math.PI * radius;
            System.out.println("Perimeter of Circle: " + perimeter);
        }
    }
}

public class Main {
    public static void main(String[] args) {
    	
    	//If we want input from user we can use scanner class
    	
        Shapes.Rectangle rectangle = new Shapes.Rectangle(5, 10);      //class and subclass are called here
        Shapes.Circle circle = new Shapes.Circle(5);             //shapes is a main class and circle is subclass

        Map<String, Object> parameters = null;

        double rectangleArea = rectangle.area(parameters);
        System.out.println("Area of Rectangle: " + rectangleArea);   //what is out in System.out.println
        rectangle.perimeter(parameters);

        double circleArea = circle.area(parameters);
        System.out.println("Area of Circle: " + circleArea);
        circle.perimeter(parameters);
    }
}
