package machine_learning;
public class GradientDescentForMultipule {
	static int iter = 1;
	double precision = 0.0000001;
	double alpha = 0.1;
	//data set
	long m = 4;
	int n = 2;
	
	double[] theta_array_new = new double[]{1.0,2.0,3.0};
	double y[] = {6.9,11.6,23.5,22.4};
	double[][] x_arrays = new double[][]{
			{1,1,1},
			{1,1.5,2},
			{1,5,3},
			{1,3,4}
	};
	
//	double[][] x_arrays = new double[][]{
//		{1,1},
//		{1,1.5},
//		{1,5},
//		{1,3}
//};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GradientDescentForMultipule gd = new GradientDescentForMultipule();
		gd.getTheta();
		//System.out.println("theta0_new = " + gd.theta0_new + "theta1_new= "+gd.theta1_new);
	}
	
	private void getTheta(){
		double[] theta_array_old = new double[n+1];
		boolean loop = true;
		
		while(loop){
			//set the new value
			for(int j = 0 ; j < theta_array_old.length;j++){
				theta_array_old[j] = theta_array_new[j];
			}
			//repeat until convergence
			for(int j = 0 ; j < theta_array_old.length;j++){
				theta_array_new[j] = theta_array_old[j] - alpha/m*derivativeTheta(m,theta_array_old,x_arrays,y,j);
				System.out.println("iter= " + iter + " j= " +j+" theta_new = " + theta_array_new[j]);

			}
			iter++;
			//when all theta convergence quit
			for(int j = 0 ; j < theta_array_old.length;j++){
				if(Math.abs(theta_array_new[j]-theta_array_old[j])>precision){
					break;//go to while(loop)
				}
				//all thetas is OK
				loop = false;
			}
//			System.out.println("iter= " + iter + " theta0_new = " + theta0_new + " theta1_new= "+ theta1_new);
		}
	}
	
	//j : Theta(j),parameter index,start with 0
	private double derivativeTheta(long m,
			double[] theta_array,
			double[][] x_array,
			double[] y_array,
			int j){

		double sum = 0;
		
		for(int i= 0 ; i < x_array.length; i++){
			double hThetax = 0 ;
			for(int k = 0 ; k < x_array[i].length; k++){
				//H_theta_x = theta0*x0+theta1*x1+...thetan*xn;
				hThetax += theta_array[k]*x_array[i][k];
			}
			//sum[(H_theta_Xi-Yi)*Xij]
			sum += (hThetax - y_array[i])*x_array[i][j];
		}

		return sum;
	}
}
