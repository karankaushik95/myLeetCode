import java.util.Scanner;
import java.text.DecimalFormat;

public class Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        if(n%2!=0&&n!=1||n<0)
			return false;
		double exp = Math.log((double)n)/Math.log(2.0);
		if(RoundTo4Decimals(exp) - (int)exp==0)
			return true;
		else return false;
    }
	
	static double RoundTo4Decimals(double val) {
		try{	
				DecimalFormat df2 = new DecimalFormat("###.####");
			return Double.valueOf(df2.format(val));
		}
		catch(NumberFormatException e){
			return 0;
		}
	}
	public static void main(String[] args){
	Power_of_Two po2 = new Power_of_Two();
	Scanner sc = new Scanner(System.in);
	System.out.println(po2.isPowerOfTwo(sc.nextInt()));
	
	
	}
	
}
