import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("Welcome to the Java OO Shapes Program");
                System.out.println("Select from the menu below:");
                System.out.println("1. Construct a Circle");
                System.out.println("2. Construct a Rectangle");
                System.out.println("3. Construct a Square");
                System.out.println("4. Construct a Triangle");
                System.out.println("5. Construct a Sphere");
                System.out.println("6. Construct a Cube");
                System.out.println("7. Construct a Cone");
                System.out.println("8. Construct a Cylinder");
                System.out.println("9. Construct a Torus");
                System.out.println("10. Exit the program");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                Shape shape = null;
                switch (choice) {
                    case 1:
                        System.out.print("Enter radius: ");
                        double radius = scanner.nextDouble();
                        shape = new Circle(radius);
                        System.out.println("Area of Circle: " + ((Circle) shape).getArea());
                        break;
                    case 2:
                        System.out.print("Enter length: ");
                        double length = scanner.nextDouble();
                        System.out.print("Enter width: ");
                        double width = scanner.nextDouble();
                        shape = new Rectangle(length, width);
                        System.out.println("Area of Rectangle: " + ((Rectangle) shape).getArea());
                        break;
                    case 3:
                        System.out.print("Enter side: ");
                        double side = scanner.nextDouble();
                        shape = new Square(side);
                        System.out.println("Area of Square: " + ((Square) shape).getArea());
                        break;
                    case 4:
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter height: ");
                        double height = scanner.nextDouble();
                        shape = new Triangle(base, height);
                        System.out.println("Area of Triangle: " + ((Triangle) shape).getArea());
                        break;
                    case 5:
                        System.out.print("Enter radius: ");
                        radius = scanner.nextDouble();
                        shape = new Sphere(radius);
                        System.out.println("Volume of Sphere: " + ((Sphere) shape).getVolume());
                        break;
                    case 6:
                        System.out.print("Enter side: ");
                        side = scanner.nextDouble();
                        shape = new Cube(side);
                        System.out.println("Volume of Cube: " + ((Cube) shape).getVolume());
                        break;
                    case 7:
                        System.out.print("Enter radius: ");
                        radius = scanner.nextDouble();
                        System.out.print("Enter height: ");
                        height = scanner.nextDouble();
                        shape = new Cone(radius, height);
                        System.out.println("Volume of Cone: " + ((Cone) shape).getVolume());
                        break;
                    case 8:
                        System.out.print("Enter radius: ");
                        radius = scanner.nextDouble();
                        System.out.print("Enter height: ");
                        height = scanner.nextDouble();
                        shape = new Cylinder(radius, height);
                        System.out.println("Volume of Cylinder: " + ((Cylinder) shape).getVolume());
                        break;
                    case 9:
                        System.out.print("Enter major radius: ");
                        double majorRadius = scanner.nextDouble();
                        System.out.print("Enter minor radius: ");
                        double minorRadius = scanner.nextDouble();
                        shape = new Torus(majorRadius, minorRadius);
                        System.out.println("Volume of Torus: " + ((Torus) shape).getVolume());
                        break;
                    case 10:
                        System.out.println("Thank you for using the Java OO Shapes Program!");
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        System.out.println("Current date and time: " + dtf.format(now));
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 10);
            scanner.close();
        }
    }
