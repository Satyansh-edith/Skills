//1
import java.util.Scanner;

class Grader {
    int score;

    // Constructor
    Grader(int s) {
        score = s;
    }

    // Method to return grade
    char letterGrade() {
        if (score >= 90) return 'O';
        else if (score >= 80) return 'E';
        else if (score >= 70) return 'A';
        else if (score >= 60) return 'B';
        else if (score >= 50) return 'C';
        else return 'F';
    }
}

public class GraderDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score;
        do {
            System.out.print("Enter score (0-100): ");
            score = sc.nextInt();
        } while (score < 0 || score > 100);

        Grader g = new Grader(score);

        System.out.println("Grade: " + g.letterGrade());

        sc.close();
    }
}

//2
class Box {
    double width, height, length;

    // Constructor 1
    Box(double w, double h, double l) {
        width = w;
        height = h;
        length = l;
    }

    // Constructor 2 (cube)
    Box(double side) {
        width = height = length = side;
    }

    // Method to calculate volume
    double volume() {
        return width * height * length;
    }
}

public class BoxDemo {
    public static void main(String[] args) {
        Box b1 = new Box(2, 3, 4);
        Box b2 = new Box(5);

        System.out.println("Volume of Box 1: " + b1.volume());
        System.out.println("Volume of Box 2: " + b2.volume());
    }
}

//3
import java.util.Scanner;

public class ArraySumAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        int sum = 0;

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        double avg = (double) sum / n;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);

        sc.close();
    }
}

//4
import java.util.Scanner;

class Stack {
    int arr[];
    int top;
    int size;

    Stack(int s) {
        size = s;
        arr = new int[size];
        top = -1;
    }

    void push(int x) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
        } else {
            arr[++top] = x;
            System.out.println(x + " pushed");
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(arr[top--] + " popped");
        }
    }

    void peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element: " + arr[top]);
        }
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack s = new Stack(5);

        s.push(10);
        s.push(20);
        s.push(30);
        s.peek();
        s.pop();
        s.peek();

        sc.close();
    }
}

