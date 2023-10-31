import java.util.Scanner;
public class fibo {
    static int rSteps = 0;
    static int iStepFibonacci(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return n;
    }

    static int rStepFibonacci(int n) {
        rSteps++;
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
        return rStepFibonacci(n - 1) + rStepFibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        scanner.close();
        System.out.println("Fibonacci Value: " + rStepFibonacci(n));
        System.out.println("Steps required using Iteration: " + iStepFibonacci(n));
        System.out.println("Steps required using Recursion: " + rSteps);
    }
}