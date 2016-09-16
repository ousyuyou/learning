package machine_learning;
public class GradientDescent {
	static int iter = 0;
	double precision = 0.000001;
	double theta0_new = 1.0;
	double theta1_new = 1.0;
	double alpha = 0.1;
	//data set
	long m = 4;
	double x[] = {1,  1.5, 5 ,  3};
	double y[] = {3.1,4.5, 13,  8.3};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GradientDescent gd = new GradientDescent();
		gd.getTheta();
		//System.out.println("theta0_new = " + gd.theta0_new + "theta1_new= "+gd.theta1_new);
	}
	
	private void getTheta(){
		double theta0_old = 0;
		double theta1_old = 0;
		
		while(Math.abs(theta0_new-theta0_old)>precision || 
				Math.abs(theta1_new-theta1_old)>precision){
			
			theta0_old = theta0_new;
			theta1_old= theta1_new;

			//repeat until convergence
			theta0_new = theta0_old - alpha*derivativeTheta0(m,theta0_old,theta1_old,x,y);
			theta1_new = theta1_old - alpha*derivativeTheta1(m,theta0_old,theta1_old,x,y);
			iter++;
			
			System.out.println("iter= " + iter + " theta0_new = " + theta0_new + " theta1_new= "+ theta1_new);
		}

	}
	
	private double derivativeTheta0(long m,double theta0,double theta1,double[] x_array,double[] y_array){
		if(x_array.length != y_array.length){
			throw new IllegalArgumentException("illegal length");
		}
		
		double sum = 0;
		
		for(int i= 0 ; i < x_array.length; i++){
			sum += theta0 + theta1*x_array[i]-y_array[i];
		}

		return sum*1.0/m;
	}
	
	private double derivativeTheta1(long m,double theta0,double theta1,double[] x_array,double[] y_array){
		if(x_array.length != y_array.length){
			throw new IllegalArgumentException("illegal length");
		}
		
		double sum = 0;
		
		for(int i= 0 ; i < x_array.length; i++){
			sum += (theta0 + theta1*x_array[i]-y_array[i])*x_array[i];
		}

		return sum*1.0/m;
	}
}
