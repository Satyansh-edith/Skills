//1
import java.util.Scanner;

public class OddSum2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows, cols, sum = 0;

        System.out.print("Enter rows and columns: ");
        rows = sc.nextInt();
        cols = sc.nextInt();

        int arr[][] = new int[rows][cols];

        System.out.println("Enter elements:");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();

                if(arr[i][j] % 2 != 0) {
                    sum += arr[i][j];
                }
            }
        }

        System.out.println("Sum of odd numbers = " + sum);
    }
}

//2
import java.util.Scanner;

public class TransposeMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows, cols;

        System.out.print("Enter rows and columns: ");
        rows = sc.nextInt();
        cols = sc.nextInt();

        int arr[][] = new int[rows][cols];

        System.out.println("Enter elements:");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Transpose Matrix:");

        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }
}

//3matrix class

import java.util.Scanner;

class Matrix {
    int row, col;
    int mat[][];

    // NxN Matrix
    Matrix(int n) {
        row = col = n;
        mat = new int[n][n];
    }

    // MxN Matrix
    Matrix(int r, int c) {
        row = r;
        col = c;
        mat = new int[r][c];
    }

    void get_Data() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements:");
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }

    void print_Mat() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    Matrix add_Mat(Matrix m) {
        Matrix res = new Matrix(row, col);

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                res.mat[i][j] = this.mat[i][j] + m.mat[i][j];
            }
        }
        return res;
    }

    static Matrix mult_Mat(Matrix m1, Matrix m2) {
        if(m1.col != m2.row) {
            System.out.println("Multiplication not possible");
            return null;
        }

        Matrix res = new Matrix(m1.row, m2.col);

        for(int i = 0; i < m1.row; i++) {
            for(int j = 0; j < m2.col; j++) {
                res.mat[i][j] = 0;
                for(int k = 0; k < m1.col; k++) {
                    res.mat[i][j] += m1.mat[i][k] * m2.mat[k][j];
                }
            }
        }
        return res;
    }
}

//3 driverclass

import java.util.Scanner;

public class MatrixDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Matrices");
            System.out.println("2. Multiply Matrices");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter rows and cols: ");
                    int r = sc.nextInt();
                    int c = sc.nextInt();

                    Matrix m1 = new Matrix(r, c);
                    Matrix m2 = new Matrix(r, c);

                    System.out.println("Matrix 1:");
                    m1.get_Data();

                    System.out.println("Matrix 2:");
                    m2.get_Data();

                    Matrix sum = m1.add_Mat(m2);

                    System.out.println("Result:");
                    sum.print_Mat();
                    break;

                case 2:
                    System.out.print("Enter rows and cols of Matrix 1: ");
                    int r1 = sc.nextInt();
                    int c1 = sc.nextInt();

                    System.out.print("Enter rows and cols of Matrix 2: ");
                    int r2 = sc.nextInt();
                    int c2 = sc.nextInt();

                    Matrix m3 = new Matrix(r1, c1);
                    Matrix m4 = new Matrix(r2, c2);

                    System.out.println("Matrix 1:");
                    m3.get_Data();

                    System.out.println("Matrix 2:");
                    m4.get_Data();

                    Matrix prod = Matrix.mult_Mat(m3, m4);

                    if(prod != null) {
                        System.out.println("Result:");
                        prod.print_Mat();
                    }
                    break;
            }

        } while(choice != 3);
    }
}

//4 math opeeration class

class mathoperation {
    static double PI = 3.1416;

    static double mul(double a, double b) {
        return a * b;
    }

    static double div(double a, double b) {
        return a / b;
    }
}

//4 driver class
import java.util.Scanner;

public class HalfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter diameter: ");
        double d = sc.nextDouble();

        double r = mathoperation.div(d, 2);

        double area = mathoperation.div(
                        mathoperation.mul(mathoperation.PI, r * r), 2);

        System.out.println("Area of half circle = " + area);
    }
}
