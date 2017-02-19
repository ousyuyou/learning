package test;

import algorithm.SortUtil;

public class MaxSumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array = SortUtil.createArray(5, 100);
//		for(int i  = 0 ; i < array.length; i++){
//			System.out.print(array[i] + " ");
//		}
//		System.out.println("maxnotnearsum: "+getMaxNotNearSum(array));
		
		String str = "****a*b*1**2**c*98*";
		System.out.println(swapChar(str));
		
		String l1 = "1234567891011121314151617181920";
		String l2 = "2019181716151413121110987654321";
		
	}
	
	public static int getMaxNotNearSum(int[] array){
		int fn = 0;
		int fn_1 = array[0];
		int fn_2 = 0;
		for(int i=1; i<array.length;i++){
			fn = fn_2 + array[i] >= fn_1?fn_2 + array[i]:fn_1;
			fn_2 = fn_1;
			fn_1 = fn;
		}
		
		return fn;
	}
	//
	public static String swapChar(String str){
		char[] carray = str.toCharArray();
		StringBuilder builder = new StringBuilder();
		int count = 0;
		for(int i = 0 ; i < carray.length; i++){
			if(carray[i] == '*'){
				builder.insert(count, carray[i]);
				count++;
			} else {
				builder.append(carray[i]);
			}
		}
		return builder.toString();
	}
}
