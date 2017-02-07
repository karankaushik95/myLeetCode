import java.util.*;
import java.io.*;

class KMeans{

	double DistanceFormula(double x1, double x2, double y1, double y2){
	
		return Math.hypot(x1-x2, y1-y2);
	}

	public static void main(String[] args) throws IOException{
	
	//Kmeans Cluster = new Kmeans();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of clusters");
	int k = sc.nextInt();
	Scanner input = new Scanner(new File("input.txt"));
	List<Double> InputList = new List<Double>();
	while (input.hasNextDouble()){		
		double input = input.nextDouble();
		InputList.add(input);
		
	}
	
	}
}
