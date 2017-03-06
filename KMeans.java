import java.util.*;
import java.io.*;

class KMean {

	double DistanceFormula(double x1, double y1, double x2, double y2) {

		return Math.hypot(x1 - x2, y1 - y2);
	}

	double[][] dummyfunction(double oldcluster[][], double newcluster[][], double entries[][], int iteration, KMean Clusters)
	{
		int i;
		double distance=9999.9999;
		int clusters[]=new int[oldcluster.length];
		System.out.println("Iteration number: "+iteration);
		System.out.println("Data Item\t\t\t Cluster Number\t\t\t\tDistance");
		for(i=0;i<entries.length;i++){
			int clusterno = 0;
			for(int j=0;j<oldcluster.length;j++){
				double distanceinloop = Clusters.DistanceFormula(entries[i][0], entries[i][1], oldcluster[j][0], oldcluster[j][1]);
				if(distance>distanceinloop){
					distance = distanceinloop;
					clusterno = j+1;
					clusters[j]++;
				}	
			}
			System.out.println(entries[i][0]+","+entries[i][1]+"\t\t\t\t\t"+clusterno+"\t\t\t\t"+distance);
			newcluster[clusterno-1][0]+=entries[i][0];
			newcluster[clusterno-1][1]+=entries[i][1];
			distance=9999.9999;
		}	
		for(i=0;i<newcluster.length;i++){
			newcluster[i][0]/=clusters[i];
			newcluster[i][1]/=clusters[i];
		}	
		return newcluster;
	}
	
	void kmeansclustering(int k, KMean Clusters, int noofentries, double entries[][]){
		int[] random = initialclusters(k, noofentries);
		int i;
		double[][] oldcluster = new double[k][2];
		for(i=0;i<k;i++){
			oldcluster[i][0] = entries[random[i]][0];
			oldcluster[i][1] = entries[random[i]][1];
		}
		int iteration = 1;
		double[][] newcluster = new double[k][2];
		newcluster = dummyfunction(oldcluster,newcluster, entries, iteration, Clusters);
		while(!Arrays.deepEquals(oldcluster,newcluster)){
			for(int l=0; l<oldcluster.length; l++)
				for(int m=0; m<oldcluster[l].length; m++)
					oldcluster[l][m]=newcluster[l][m];
			for( i = 0; i < newcluster.length; i++ )
				Arrays.fill( newcluster[i], 0 );
			dummyfunction(oldcluster, newcluster, entries, ++iteration, Clusters);	
		}
	}
	
	int[] initialclusters(int k, int noofentries){
		ArrayList<Integer> list = new ArrayList<Integer>();
        int[] random = new int[k];
		for (int i=1; i<noofentries; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
		for (int i=0; i<k; i++) {
            random[i]=list.get(i);
        }
		return random;
	}
	
	
	public static void main(String[] args) throws IOException, NumberFormatException {

		KMean Cluster = new KMean();
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of clusters");
		int k = sc.nextInt();
		int noofentries = 0;
		Scanner input = new Scanner(new File("input.txt"));
		while (input.hasNextLine()){	
			String random = input.nextLine();
			noofentries++;
		}	
		//System.out.println("Success till step 1!"+noofentries);
		double[][] entries = new double[noofentries][2];
		Scanner input2 = new Scanner(new File("input.txt"));
		int no = 0;
		while (input2.hasNextLine()) {
			String splitset = input2.nextLine();
			String[] parts = splitset.split(" ");
			entries[no][0] = Double.parseDouble(parts[0]);
			entries[no++][1] = Double.parseDouble(parts[1]);
		}		
		Cluster.kmeansclustering(k, Cluster, noofentries, entries);
		//System.out.println("Success till step 2!");
		//for(i=0;i<noofentries;i++){
		//	System.out.println(entries[i][0]+","+entries[i][1]);
		//}
	}
}
