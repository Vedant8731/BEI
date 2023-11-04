import java.util.*;
public class fibotwo{

    static int rsteps=0;
    static int istepfibo(int n){
        int f[]=new int[n+1];
        f[0]=0;
        f[1]=1;
        for(int i=2;i<=n;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return n;
    }

    static int rstepfibo(int n){
        rsteps++;
        if(n<0) return 0;
        if(n==0||n==1) return 1;
        return rstepfibo(n-1)+rstepfibo(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n=sc.nextInt();
        System.out.println("Fibonacci Value of n: "+rstepfibo(n));
        System.out.println("Steps required using Iteration: "+istepfibo(n));
        System.out.println("Steps required using Recursion: "+rsteps);
    }
}