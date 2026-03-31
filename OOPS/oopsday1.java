//1
class Welcome {
    public static void main(String[] args) {
        System.out.println("Welcome");
    }
}

//2
import java.util.Scanner;

class Fibonacci {
    
    // Recursive method inside driver class
    static int fib(int n) {
        if (n <= 1)
            return n;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci Series:");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}

//3

class Car {
    int speed;
    boolean started;

    // Constructor
    Car() {
        speed = 0;
        started = false;
    }

    // Start the car
    void carStart() {
        if (started) {
            System.out.println("Car is already started!");
        } else {
            started = true;
            speed = 30;
            System.out.println("Car started.");
            printSpeed();
        }
    }

    // Reduce speed
    void carSlow() {
        if (!started) {
            System.out.println("Car is not started!");
            return;
        }

        speed -= 20;
        if (speed < 0)
            speed = 0;

        printSpeed();
    }

    // Increase speed
    void carFast() {
        if (!started) {
            System.out.println("Car is not started!");
            return;
        }

        speed += 30;
        if (speed > 200)
            speed = 200;

        printSpeed();
    }

    // Print speed
    void printSpeed() {
        System.out.println("Current Speed: " + speed);
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car c = new Car();

        c.carStart();   // start car
        c.carFast();    // speed = 60
        c.carFast();    // speed = 90
        c.carSlow();    // speed = 70
        c.carSlow();    // speed = 50
    }
}

//4
import java.util.Scanner;

public class Main {

    static class ComplexNum {
        int real, imag;

        ComplexNum(int r, int i) {
            real = r;
            imag = i;
        }

        void printComplex() {
            if (imag >= 0)
                System.out.println(real + " + " + imag + "i");
            else
                System.out.println(real + " - " + (-imag) + "i");
        }

        static ComplexNum addComplex(ComplexNum a, ComplexNum b) {
            return new ComplexNum(a.real + b.real, a.imag + b.imag);
        }

        static ComplexNum subComplex(ComplexNum a, ComplexNum b) {
            return new ComplexNum(a.real - b.real, a.imag - b.imag);
        }

        static ComplexNum multComplex(ComplexNum a, ComplexNum b) {
            int real = a.real * b.real - a.imag * b.imag;
            int imag = a.real * b.imag + a.imag * b.real;
            return new ComplexNum(real, imag);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter real and imaginary part of first number: ");
        ComplexNum c1 = new ComplexNum(sc.nextInt(), sc.nextInt());

        System.out.print("Enter real and imaginary part of second number: ");
        ComplexNum c2 = new ComplexNum(sc.nextInt(), sc.nextInt());

        int choice;

        do {
            System.out.println("\n1. Add\n2. Subtract\n3. Multiply\n4. Print\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            ComplexNum result;

            switch (choice) {
                case 1:
                    result = ComplexNum.addComplex(c1, c2);
                    result.printComplex();
                    break;

                case 2:
                    result = ComplexNum.subComplex(c1, c2);
                    result.printComplex();
                    break;

                case 3:
                    result = ComplexNum.multComplex(c1, c2);
                    result.printComplex();
                    break;

                case 4:
                    c1.printComplex();
                    c2.printComplex();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}