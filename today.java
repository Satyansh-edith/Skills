// Program to print "Ping" and "PONG" using two threads

class PingThread extends Thread {
    public void run() {
        while (true) {
            try {
                System.out.println("Ping");
                
                // Random sleep between 0 to 1000 ms
                Thread.sleep((int)(Math.random() * 1000));
            } 
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class PongThread extends Thread {
    public void run() {
        while (true) {
            try {
                System.out.println("PONG");
                
                // Random sleep between 0 to 1000 ms
                Thread.sleep((int)(Math.random() * 1000));
            } 
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class PingPong {
    public static void main(String[] args) {

        // Creating thread objects
        PingThread t1 = new PingThread();
        PongThread t2 = new PongThread();

        // Starting threads
        t1.start();
        t2.start();
    }
}

-----------------------------------------------------

// Producer Consumer Problem using Multithreading

class Buffer {
    int data;
    boolean available = false;

    // Producer method
    synchronized void produce(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        data = value;
        available = true;

        System.out.println("Produced: " + data);

        notify();
    }

    // Consumer method
    synchronized void consume() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("Consumed: " + data);

        available = false;

        notify();
    }
}

// Producer Thread
class Producer extends Thread {
    Buffer b;

    Producer(Buffer b) {
        this.b = b;
    }

    public void run() {
        int i = 1;

        while (true) {
            b.produce(i);

            i++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Consumer Thread
class Consumer extends Thread {
    Buffer b;

    Consumer(Buffer b) {
        this.b = b;
    }

    public void run() {
        while (true) {
            b.consume();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {

        Buffer b = new Buffer();

        Producer p = new Producer(b);
        Consumer c = new Consumer(b);

        p.start();
        c.start();
    }
}

--------------------------------------------------

// Program using multithreading to find
// maximum and average of an array

class MaxThread extends Thread {

    int arr[];
    int max;

    // Constructor
    MaxThread(int arr[]) {
        this.arr = arr;
    }

    // Thread task
    public void run() {

        max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Maximum Element = " + max);
    }

    // Getter method
    int getMax() {
        return max;
    }
}

class AvgThread extends Thread {

    int arr[];
    double avg;

    // Constructor
    AvgThread(int arr[]) {
        this.arr = arr;
    }

    // Thread task
    public void run() {

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        avg = (double) sum / arr.length;

        System.out.println("Average = " + avg);
    }

    // Getter method
    double getAvg() {
        return avg;
    }
}

public class MaxAvg {

    public static void main(String[] args) {

        int arr[] = {10, 20, 30, 40, 50};

        // Creating thread objects
        MaxThread t1 = new MaxThread(arr);
        AvgThread t2 = new AvgThread(arr);

        // Starting threads
        t1.start();
        t2.start();

        // Parent thread waits for child threads
        try {
            t1.join();
            t2.join();
        } 
        catch (InterruptedException e) {
            System.out.println(e);
        }

        // Getting results from threads
        int max = t1.getMax();
        double avg = t2.getAvg();

        // Final calculation
        double result = max / avg;

        System.out.println("(Max of Array) / (Average of Array) = " + result);
    }
}

