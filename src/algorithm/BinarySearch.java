package algorithm;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static int binarySearch(double[] array,double value){
		return binarySearchLoop(array,value,0,array.length-1);
	}
	
	private static int binarySearchLoop(double[] array,double value,int p,int r){
		int q = (p+r)/2;
		
		if(value == array[q]){
			return q;
		}
		
		if(p < r){
			if(value < array[q]){
				return binarySearchLoop(array,value,p,q);
			} else {
				return binarySearchLoop(array,value,q+1,r);
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
}
