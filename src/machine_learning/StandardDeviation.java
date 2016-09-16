package machine_learning;

public class StandardDeviation {
	double x[] = {1,  1.5, 5 ,  3};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardDeviation sd = new StandardDeviation();
		sd.getStandardDeviations(sd.x);
	}
	//x(n)=(x(n)-u)/s(n)
	private double[] getStandardDeviations(double[] x_array){
		double sum = 0;
		for(int i=0;i<x_array.length;i++){
			sum+=x_array[i];
		}
		double u=sum/x_array.length;
		
		double sumDeviation = 0;
		for(int i=0;i<x_array.length;i++){
			sumDeviation+=(x_array[i]-u)*(x_array[i]-u);
		}
		sumDeviation = Math.sqrt(sumDeviation/1.0*x_array.length);
		//new return
		double[] x_array_new = new double[x_array.length];
		for(int i = 0 ; i < x_array_new.length;i++){
			x_array_new[i] = (x_array[i]-u)/sumDeviation;
			System.out.println(x_array_new[i]);

		}
		
		return x_array_new;
	}
	
}
