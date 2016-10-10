package algorithm;

public class Sort {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		SecureRandom rand = new SecureRandom();	
//		
//		double[] array = new double[30];
//		for(int i = 0 ; i < array.length ; i++){
//			array[i] = rand.nextInt(1000);
//		}
//		mergeSort(array);
//		printArray(array);
//		int index = binarySearch(array,0);
//		System.out.println(index);
	}

	public static void printArray(double[] array){
		for(int i = 0 ; i < array.length ; i++){
			System.out.println(array[i]);
		}
	}
	
	public static void printArrayInt(int[] array){
		for(int i = 0 ; i < array.length ; i++){
			System.out.println(array[i]);
		}
	}
	
	public static void swap(int[] array,int p,int q){
		int temp = array[p];
		array[p] = array[q];
		array[q] = temp;
	}
	
	public static void swap2D(int[][] array,int oldp,int oldq,int p,int q){
		int temp = array[oldp][oldq];
		array[oldp][oldq] = array[p][q];
		array[p][q] = temp;
	}
}
