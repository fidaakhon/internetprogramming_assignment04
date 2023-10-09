class EvenThread extends Thread {
    private int n;

    public EvenThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Even Thread: Printing even numbers up to " + n);
        for (int i = 2; i <= n; i += 2) {
            System.out.println(i);
        }
    }

    @Override
    public String toString() {
        return "EvenThread";
    }
}

class OddThread extends Thread {
    private int m;

    public OddThread(int m) {
        this.m = m;
    }

    @Override
    public void run() {
        System.out.println("Odd Thread: Printing odd numbers up to " + m);
        for (int i = 1; i <= m; i += 2) {
            System.out.println(i);
        }
    }

    @Override
    public String toString() {
        return "OddThread";
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 10;  // Set the upper limit for even numbers
        int m = 10;  // Set the upper limit for odd numbers

        EvenThread evenThread = new EvenThread(n);
        OddThread oddThread = new OddThread(m);

        // Start both threads
        evenThread.start();
        oddThread.start();

        // Wait for both threads to finish
        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread: Both threads have finished.");
    }
}

