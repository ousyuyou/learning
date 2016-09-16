package machine_learning;
public class GradientDescent2 {
	static int iter = 0;
	double precision = 0.0000001;
	double theta0_new = 1.0;
	double theta1_new = 1.0;
	double alpha = 0.01;
	//data set
	long m = 4;
	double x[] = {1,  1.5, 5 ,  3};
	double y[] = {3.1,4.5, 13,  8.3};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GradientDescent2 gd = new GradientDescent2();
		gd.getTheta();
		//System.out.println("theta0_new = " + gd.theta0_new + "theta1_new= "+gd.theta1_new);
	}
	
	private void getTheta(){
		double theta0_old = 0;
		double theta1_old = 0;
		
		while(Math.abs(theta0_new-theta0_old)>precision || 
				Math.abs(theta1_new-theta1_old)>precision){
			
			for (int i=0;i< x.length; i++){
				theta0_old = theta0_new;
				theta1_old= theta1_new;
				theta0_new = theta0_old - alpha*derivativeTheta0(m,theta0_old,theta1_old,x[i],y[i]);
				theta1_new = theta1_old - alpha*derivativeTheta1(m,theta0_old,theta1_old,x[i],y[i]);
				//repeat until convergence
				iter++;
			}
			if(iter>5000){
				break;
			}
			System.out.println("iter= " + iter + " theta0_new = " + theta0_new + " theta1_new= "+ theta1_new);
		}

	}
	
	private double derivativeTheta0(long m,double theta0,double theta1,double x_array,double y_array){
		return theta0 + theta1*x_array-y_array;

	}
	
	private double derivativeTheta1(long m,double theta0,double theta1,double x_array,double y_array){
		return (theta0 + theta1*x_array-y_array)*x_array;
	}
}
