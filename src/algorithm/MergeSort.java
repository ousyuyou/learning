package algorithm;

import java.security.SecureRandom;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		SecureRandom rand = new SecureRandom();	
		
		double[] array = new double[30];
		for(int i = 0 ; i < array.length ; i++){
			array[i] = rand.nextInt(1000);
		}
		mergeSort(array);
		Sort.printArray(array);
//		int index = binarySearch(array,0);
//		System.out.println(index);
	}

	private static void mergeSort(double array[]){
		mergeSortLoop(array,0,array.length-1);
	}
	
	private static void mergeSortLoop(double[] array,int p,int r){
		if(p<r){//if p>=r then array.length=1
			int q = (p+r)/2;
			mergeSortLoop(array,p,q);
			mergeSortLoop(array,q+1,r);
			mergeArrayNoGuard(array,p,q,r);
		}
	}
	
	private static void mergeArray(double[] array,int p,int q,int r){
		int n1 = q-p+1;
		int n2 = r-q;
		double[] left = new double[n1+1];
		double[] right = new double[n2+1];
		
		for(int i = 0 ; i < n1; i++){
			left[i] = array[p+i];
		}
		for(int j = 0 ; j < n2; j++){
			right[j] = array[q+j+1];
		}
		
		left[n1]= Double.MAX_VALUE;//guard,prevent check all end
		right[n2]= Double.MAX_VALUE;//guard,prevent check all end
		
		int i = 0;
		int j = 0;
		
		for(int k = p;k<=r; k++){
			if(left[i]<=right[j]){
				array[k] = left[i];
				i++;
			}else{
				array[k] = right[j];
				j++;
			}
		}
	}
	
	private static void mergeArrayNoGuard(double[] array,int p,int q,int r){
		int n1 = q-p+1;
		int n2 = r-q;
		double[] left = new double[n1];
		double[] right = new double[n2];
		
		for(int i = 0 ; i < n1; i++){
			left[i] = array[p+i];
		}
		for(int j = 0 ; j < n2; j++){
			right[j] = array[q+j+1];
		}
		
		int i = 0;
		int j = 0;
		int k = p;
		
		for(;k<=r; k++){
			if(j==n2 || i == n1){
				break;
			}
			if(left[i]<=right[j]){
				array[k] = left[i];
				i++;
			}else{
				array[k] = right[j];
				j++;
			}
		}
		
		if(i==n1){
			System.arraycopy(right, j, array, k, r-k+1);
		} else if(j==n2){
			System.arraycopy(left, i, array, k, r-k+1);
		}
	}
	
}
