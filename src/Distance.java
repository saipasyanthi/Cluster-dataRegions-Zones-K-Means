
public class Distance {

	public Distance() {
		
	}
	
	public static double eucledianDistance(double[] point1, double[] point2) {
        double sum = 0.0;
        for(int i = 0; i < point1.length; i++) {
            sum += ((point1[i] - point2[i]) * (point1[i] - point2[i]));
        }
        return Math.sqrt(sum);
    }
    
   
    

}
