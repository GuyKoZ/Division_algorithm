import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsynchronousMain {
    static final int MATH = 5;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the desired number\n");
        int number = scanner.nextInt();
        ExecutorService pool = Executors.newFixedThreadPool(MATH);

        Runnable r1 = new Main(number);
        pool.execute(r1);

        Runnable r2 = new Main(number);
        pool.execute(r2);

        Runnable r3 = new Main(number);
        pool.execute(r3);

        Runnable r4 = new Main(number);
        pool.execute(r4);

        Runnable r5 = new Main(number);
        pool.execute(r5);

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        // passes the Task objects to the pool to execute (Step 3)
        // pool shutdown ( Step 4)
        pool.shutdown();
    }
}
