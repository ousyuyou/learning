package algorithm;

import java.security.SecureRandom;

public class InsertSort {
	private static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[100];
		try{
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			for(int i = 0 ;i <array.length;i++){
				array[i] = random.nextInt(100);
			}
			Sort.printArrayInt(array);
			System.out.println("-----------------------");
//			long t1 = System.currentTimeMillis();
			insertSort(array);
//			long t2 = System.currentTimeMillis();
//			System.out.println(t2-t1);
			Sort.printArrayInt(array);

//			System.out.println("count = "+count);
		}catch(Exception e){
			e.printStackTrace();
		}
		
//		int[] array = new int[]{6,5,7,2,6,3,7,6,8,5,9};
//		Sort.printArrayInt(array);
//		System.out.println("-----------------------");
//
//		insertSort(array);
//		Sort.printArrayInt(array);
//		System.out.println("count = "+count);

	}

	private static void insertSort(int[] array){
		if(array.length < 2)
			return;
					
		for(int i = 1; i < array.length;i++){
			int key = array[i];
			//insert j to array[0~j-1]
			for(int j=i-1;j>=0&&key < array[j];j--){
				Sort.swap(array, j+1, j);
				count++;
			}
		}
	}
}
