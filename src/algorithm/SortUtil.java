package algorithm;

import java.security.SecureRandom;

public class SortUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int[] createArray(int length,int range){
		int[] array = new int[length];
		try{
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			for(int i = 0 ;i <array.length;i++){
				array[i] = random.nextInt(range);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return array;
	}
}
