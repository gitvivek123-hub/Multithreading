/*c) Write a program that implements a multi-thread application that has three threads.
First thread generates random integer every 1 second and if the value is even, second
thread computes the square of the number and prints. If the value is odd, the third
thread will print the value of cube of the number.*/
import java.util.Random;

class NumberGenerator extends Thread {
    public void run() {
        Random r = new Random();
        while (true) {
            int n = r.nextInt(10);
            System.out.println("Generated: " + n);
            if (n % 2 == 0)
                new SquareThread(n).start();
            else
                new CubeThread(n).start();
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

class SquareThread extends Thread {
    int n;
    SquareThread(int n) { this.n = n; }
    public void run() {
        System.out.println("Square: " + (n * n));
    }
}

class CubeThread extends Thread {
    int n;
    CubeThread(int n) { this.n = n; }
    public void run() {
        System.out.println("Cube: " + (n * n * n));
    }
}

public class MultiThreadApp {
    public static void main(String[] args) {
        new NumberGenerator().start();
    }
}
