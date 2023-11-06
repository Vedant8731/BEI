public class fibomain{
	public static int fiborec(int n){
		if(n<=1) return n;
		return fiborec(n-1)+fiborec(n-2);
	}
	public static int fibononrec(int n){
		if(n<=1) return n;

		int a=0;
		int b=1;
		int result=0;
		for(int i=2;i<=n;i++){
			result=a+b;
			a=b;
			b=result;
		}

		return result;
	}

	public static void main(String args[]){
		int n=10;
		int r1=fiborec(10);
		int r2=fibononrec(10);
		System.out.println(r1+ " "+r2);
	}
}