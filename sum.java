/*a) Write a program to calculate the sum and average of an array of 1000 integers
(generated randomly) using 10 threads. Each thread calculates the sum of 100
integers. Use these values to calculate average. [Use join method ].*/
import java.util.Random;

class SumThread extends Thread {
    int[] arr;
    int start, end;
    int sum = 0;

    SumThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++)
            sum += arr[i];
    }
}

public class SumAverage {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[1000];
        Random r = new Random();

        for (int i = 0; i < 1000; i++)
            arr[i] = r.nextInt(100);

        SumThread[] threads = new SumThread[10];
        int totalSum = 0;

        for (int i = 0; i < 10; i++) {
            threads[i] = new SumThread(arr, i * 100, (i + 1) * 100);
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
            totalSum += threads[i].sum;
        }

        System.out.println("Sum = " + totalSum);
        System.out.println("Average = " + (totalSum / 1000.0));
    }
}
